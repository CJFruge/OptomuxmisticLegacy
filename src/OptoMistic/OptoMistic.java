/*
 * OptoMistic.java
 *
 * Created on April 29, 2007, 12:58 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMistic;

import SerialIOSync.*;
import gnu.io.*;
import java.io.*;
import java.util.*;
import OptoMistic.Enum.*;

public class OptoMistic {
    
    private MisticCRC mCRC;
    private CRCType crcT;
    private SerialIOSync optoSIO = null;
    private StringBuilder cmdString = new StringBuilder();
    private String dataString = new String();
    private MisticCommand lastCmd;
    private int[] ioConfig = new int[Constants.MAX_CHANNELS.getValue()];
    // jth array is for field index
    // kth array is for values or bits
    private int[][] f = new int[Constants.MAX_FIELDS.getValue()][Constants.MAX_CHANNELS.getValue()];
    private int[] result = new int[Constants.MAX_LATCHES.getValue()];
    private int devID = -1;
    
    public OptoMistic(SerialIOSync sio,CRCType crcType,int deviceID,int[] chanIOConfig) {    
        optoSIO = sio;
	mCRC = new MisticCRC(crcType,Constants.MISTIC_CRC_INIT.getValue());
        copyArray(chanIOConfig,ioConfig);
        devID = deviceID & 0xff;
	for ( int j=0; j<Constants.MAX_FIELDS.getValue(); j++ ) {
	    clearArray(f[j],0);
	}
    }
    
    public final int getDeviceID() { return devID; }
    public final MisticCommand getLastCmd() { return lastCmd; }
    public void setDeviceID(int deviceID) { devID = deviceID & 0xff; }
    public final int[] getResults() { return result; }
    public final int getResult(int ix) { return result[ix %= result.length]; }
    public final String getDataString() { return dataString; }
    
    public void setField(int fieldix, int chan, int val) {
	fieldix = Math.abs(fieldix);
	chan = Math.abs(chan);
	f[fieldix %= Constants.MAX_FIELDS.getValue()][chan %= Constants.MAX_CHANNELS.getValue()] = val;
    }

    public void clearArray(int[] intArray, int toValue) {
        for ( int j : intArray ) { j = toValue; }
    }

    public void copyArray(int[] src, int[] dst) {
        try {
            System.arraycopy(src,0,dst,0,dst.length > src.length ? src.length : dst.length);
        } catch (IndexOutOfBoundsException e) { e.printStackTrace(); }
    }
    
    protected final DeviceType getDeviceType() {
	boolean rtn = false;
	DeviceType dtFound = DeviceType.UNKNOWN;
	try {
	    rtn = misticCommand(MisticCmdSet.identifyType);
	} catch (Exception e) { e.printStackTrace(); }
	if ( rtn ) {
	    for ( DeviceType dt : DeviceType.values() ) {
		if ( result[0] == dt.getValue() ) { dtFound = dt; break; }
	    }
	}
	return dtFound;
    }
    
    protected final void rawCommand(String cmd) throws Exception {
	try {
	    optoSIO.sendCommand(cmd);
	} catch (Exception e) { e.printStackTrace(); throw e; }
    }
    
    protected final boolean misticCommand(MisticCommand cmd) throws Exception {
	boolean rtn = false;
	clearArray(result,0);
	try {
	    rtn = sendCommand(cmd);
	} catch (Exception e) { e.printStackTrace(); throw e; }
	if ( rtn ) {
	    String s = dataString.substring(1,dataString.length()-crcT.getWidth());
	    switch (cmd.getDRAction()) {
		case DECODE_MASK:
		    try {
			decodeMask(s,result);
		    } catch (Exception e) { e.printStackTrace(); throw e; }
		    break;
		case DECODE_ARRAY:
		case DECODE_ARRAY_MASKS:
		    try {
			decodeWord(s,result,cmd);
		    } catch (Exception e) { e.printStackTrace(); throw e; }
		    break;
		case NONE:    
		default:
		    break;
	    }
	}
	for ( int j=0; j<Constants.MAX_FIELDS.getValue(); j++ ) {
	    clearArray(f[j],0);
	}
	lastCmd = cmd;
	return rtn;
    }

    private final boolean sendCommand(MisticCommand cmd) throws Exception {
	int ckSum = 0, ckSumRx = 1, nBitsSet = 0;
	//int ftemp[] = new int[Constants.MAX_CHANNELS.getValue()];
	StringBuilder fFmt = new StringBuilder();
        cmdString.delete(0,cmdString.length());
        cmdString.append(String.format(">%02X%s",devID,cmd.getCmd()));
	
	int lim = cmd.getFieldType().getSize();
	for ( int j=0; j<lim; j++ ) {
	    if ( cmd.getFieldType().getWidth(j) > 0 ) {
		if ( ! cmd.getFieldType().getMask(j) ) {
		    int width = cmd.getFieldType().getWidth(j);
		    for ( int k=0; k<width; k++ ) {
			generateFormatString(fFmt,width);
			cmdString.append(String.format(fFmt.substring(0),f[j][k]));		
		    }
		}
		else { 
		    generateFormatString(fFmt,cmd.getFieldType().getWidth(j));
		    cmdString.append(String.format(fFmt.substring(0),generateBitMask(f[j],nBitsSet))); 
		}
	    }		
	}
	
	cmdString.append(mCRC.calcCRC(cmdString.substring(1)));
	cmdString.append('\r');
	try {
	    optoSIO.sendCommand(cmdString.substring(0));
	    optoSIO.getResponse();
	} catch(IOException e) { e.printStackTrace(); throw e; }
	
	dataString = optoSIO.getData();
	if ( dataString.charAt(0) == 'T' ) { return false; }

        int ix = dataString.lastIndexOf('\r');
	if ( ix > 0 ) { dataString = dataString.substring(0,ix); }
	else { return false; }
	int len = dataString.length();
        try {
            ckSumRx = Integer.parseInt(dataString.substring(len-crcT.getWidth(),len-1),16);
	    ckSum = Integer.parseInt(mCRC.calcCRC(dataString.substring(0,len-1-crcT.getWidth())));
        } catch (NumberFormatException e) { e.printStackTrace(); throw e; }
	boolean rtn = ( ckSum == ckSumRx );
	if ( rtn  && dataString.charAt(0) == 'N' ) { parseError(); return false; }
	return rtn;
    }
    
    private void generateFormatString(StringBuilder sb, int width) {
	sb.delete(0,sb.length());
	sb.append("%0");
	sb.append(String.format("%1d",width) + "X");
    }
    
    private void decodeWord(String s,int[] dest,MisticCommand cmd) throws Exception {
        String num = new String();
        clearArray(dest,0);
	int end = s.length(), ix = 0;
	int lim = cmd.getDecodeLength();
	for ( int j=0; j<lim; j++,ix++ ) {
	    int width = cmd.getDecodeWidth(j);
	    if ( width == Constants.END_OF_ARRAY.getValue() ) {
		j -= 1;
		width = cmd.getDecodeWidth(j);
	    }
	    int stS = end - width;
	    if ( stS < 0 ) { return; }
	    try {
		num = s.substring(stS,stS+width);
	    } catch (IndexOutOfBoundsException e) { e.printStackTrace(); throw e; }
	    end = stS - 1;
	    try {
                if ( num.charAt(0) != '?' ) { dest[ix %= dest.length] = Integer.parseInt(num,16); }
            } catch (NumberFormatException e) { e.printStackTrace(); throw e; }
        }
    }

    private int generateBitMask(int[] intArray,int bitsSet) {
        bitsSet = 0;
	int mask = 0;
        for ( int j=0; j<intArray.length; j++ ) {
	    bitsSet += intArray[j];
            mask |= intArray[j] << j;
        }
        return mask & 0xffff;
    }
    
    private void decodeMask(String s,int[] dest) throws NumberFormatException {
	int mask = 0;
	try {
	    mask = Integer.parseInt(s);
	} catch (NumberFormatException e) { e.printStackTrace(); throw e; }
        mask &= 0xffff;
        for ( int j=0; j<dest.length; j++ ) { dest[j] = mask & (1 << j); }
    }
    
    private void parseError() throws NumberFormatException {
        int err = -100;
        try {
            err = Integer.parseInt(dataString.substring(1,2),16);
        } catch (NumberFormatException e) {e.printStackTrace(); throw e; }    
	for ( ErrorType et : ErrorType.values() ) {
	    if ( err == et.getValue() ) {
		dataString = et.getErrorString();
		break;
	    }
	}
    }
}///:~
