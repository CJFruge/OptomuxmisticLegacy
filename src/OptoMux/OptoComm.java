/*
 * OptoComm.java
 *
 * Created on April 22, 2007, 4:44 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux;

import SerialIOSync.*;
import OptoMux.Enum.*;
import gnu.io.*;
import java.io.*;
import java.util.*;

public class OptoComm { 

//    class IO { static final int out = 1; static final int in = 0; }
    
    
    public OMUXCmdSet omuxCmdSet = new OMUXCmdSet();
//    public DeviceType deviceType = new DeviceType();
//    public OMUXProtocol omuxProtocol = new OMUXProtocol();
//    public TurnAroundDelay turnAroundTime = new TurnAroundDelay();
    
    private SerialIOSync optoSIO = null;
    private StringBuilder cmdString = new StringBuilder();
    private String dataString = new String();
    public static final int MAX_CHANNELS = 16;
    public static final int END_OF_ARRAY = -1;
    private int taDelay = 0;
    private int[] ioConfig = new int[MAX_CHANNELS];
    private int[] pos = new int[MAX_CHANNELS];
    private int[] mod = new int[MAX_CHANNELS];
    private int[] data = new int[MAX_CHANNELS];
    private int[] result = new int[MAX_CHANNELS];
    private int devID = -1;

    protected OptoComm(SerialIOSync sio, int deviceID, int[] chanIOConfig) throws IndexOutOfBoundsException {
        optoSIO = sio;
        copyArray(chanIOConfig,ioConfig);
        devID = deviceID & 0xff;
        clearArray(pos,END_OF_ARRAY);
        clearArray(mod,END_OF_ARRAY);
        clearArray(data,END_OF_ARRAY);
        clearArray(result,END_OF_ARRAY);
    }
   
    protected boolean sendCommand(OMUXCommand cmd) throws Exception {
        
        int ckSum, ckSumSent;

        cmdString.delete(0,cmdString.length());
        cmdString.append(String.format(">%02X%c",devID,cmd.cmdChar));

        if ( ! cmd.posFormat.isEmpty() ) { 
            cmdString.append(String.format(cmd.posFormat,generateBitMask(pos)));
        }
        
        if ( ! cmd.modFormat.isEmpty() ) {
            for ( int j : mod ) {
                if ( j == END_OF_ARRAY ) { break; }
                if ( cmd.modFormat == "%c" ) { cmdString.append(String.format(cmd.modFormat,(char)j)); }
                else { cmdString.append(String.format(cmd.modFormat,j)); }
            }
        }
        
        if ( ! cmd.dataFormat.isEmpty() ) {
            for ( int j : data ) { 
                if ( j > END_OF_ARRAY ) { break; }
                cmdString.append(String.format(cmd.dataFormat,j));
            }
        }
        // add cksum to string
        byte[] cmdByte = cmdString.substring(1).getBytes();
        ckSum = 0;
        for ( int b : cmdByte ) { ckSum += b; }
        ckSum %= 0x100;
        cmdString.append(String.format("%02X\r",ckSum));
            
        // write to the comm port & get response
        try { 
            optoSIO.sendCommand(cmdString.substring(0));
            optoSIO.getResponse();
        } catch (IOException e) { e.printStackTrace(); throw e; }
        dataString = optoSIO.getData();
        
        // special device conditions
        if ( dataString.charAt(0) == 'A' && dataString.length() == 2 ) { return true; }
        if ( dataString.charAt(0) == 'N' ) { parseError();  return false; }
        if ( dataString.charAt(0) == 'T' ) { return false; }
        
        // get cksum sent from device
        int ix = dataString.lastIndexOf('\r') - 2;
        if ( ix < 0 ) { return false; }
        try {
            ckSumSent = Integer.parseInt(dataString.substring(ix, ix + 1),16);
        } catch (NumberFormatException e) { e.printStackTrace(); throw e; }
        
        // calc cksum from string
        byte[] dataByte = dataString.substring(0,ix).getBytes();
        ckSum = 0;
        for ( int b : dataByte ) { ckSum += b; }
        
        // return true if cksums match
        return ( ckSumSent == ckSum );
    }
 
    private void parseError() throws NumberFormatException {
        int err = 7;
        try {
            err = Integer.parseInt(dataString.substring(1,2),16);
        } catch (NumberFormatException e) {e.printStackTrace(); throw e; }    
        switch (err) {
            case 0: dataString = "ERR0_PUCLEAR_EXPECTED"; break;
            case 1: dataString = "ERR1_UNDEFINED_CMD"; break;
            case 2: dataString = "ERR2_CKSUM_ERROR"; break;
            case 3: dataString = "ERR3_BUFFER_OVERRUN"; break;
            case 4: dataString = "ERR4_BAD_CHARACTER"; break;
            case 5: dataString = "ERR5_DATA_FIELD_ERROR"; break;
            case 6: dataString = "ERR6_WATCHDOG_TIMEOUT"; break;
            default:
            case 7: dataString = "ERR7_UNDEFINED_ERROR"; break;
        }
    }
    
    protected void decodeWord(int width) throws NumberFormatException {
        String num;
        clearArray(data,0);
        for ( int k=dataString.length()-3, j=k-width, ix=0; j>0 && ix<pos.length; ix++ ) {
            num = dataString.substring(j-=width,k-=width);
            try {
                if ( num.charAt(0) != '?' ) { 
                    result[pos[ix] == END_OF_ARRAY ? ix : pos[ix]] = Integer.parseInt(num,16); 
                }
            } catch (NumberFormatException e) { e.printStackTrace(); throw e; }
        } 
    }   
    
    protected void decodeMask() throws NumberFormatException {
        int mask = 0;
        try {
            mask = Integer.parseInt(dataString.substring(1,dataString.length()-3),16);
        } catch (NumberFormatException e) { e.printStackTrace(); throw e; }
        //mask &= ~generateBitMask(ioConfig);
        mask &= 0xffff;
        for ( int j=0; j<result.length; j++ ) { result[j] = mask & (1 << j); }
    }

    protected int getArrayDelimiter(int[] checkArray) {
        int rtn = 0;
        for ( int j : checkArray ) {
            if ( j == END_OF_ARRAY ) { rtn = j-1; break; }
        }
        return rtn;
    }   
    
    protected void clearArray(int[] intArray, int toValue) {
        for ( int j : intArray ) { j = toValue; }
    }

    protected int generateBitMask(int[] intArray) {
        int mask = 0;
        for ( int j : intArray ) { 
            if ( j == END_OF_ARRAY ) { break; }
            mask |= 1 << j;
        }
        return mask & 0xffff;
    }
    
    protected void copyArray(int[] src, int[] dst) {
        try {
            System.arraycopy(src,0,dst,0,MAX_CHANNELS);
        } catch (IndexOutOfBoundsException e) { e.printStackTrace(); }
    }
    
    // get/set funcs
    protected int[] getSetData() { return data; }
    
    protected int[] getSetPosition() { return pos; }
    
    protected int[] getSetModifier() { return mod; }
    
    protected int[] getSetIOConfiguration() { return ioConfig; }

    // get only
    public final int[] getResults() { return result; }

    public final int getResult(int position) {
        position &= 0xf;
        return result[position];
    }
    
    public final String getDataString() { return dataString; }
    
    public final int getTurnAroundDelay() { return taDelay; }
    
    public final int getDeviceID() { return devID; }
    public void setDeviceID(int deviceID) { devID = deviceID & 0xff; }

    // initializer
    protected final int initDevice(boolean forceInit) throws Exception {
        int dev = DeviceType.UNKNOWN.getValue();
        boolean rtn = false;
        try {
            rtn = omuxCommand(omuxCmdSet.identifyDevice);
            dev = result[0];
            if ( dataString.substring(0,3) == "ERR0" || forceInit ) {
                rtn = omuxCommand(omuxCmdSet.powerUpClear);
                if ( rtn ) { rtn = omuxCommand(omuxCmdSet.reset); }
                copyArray(ioConfig,pos);
                if ( rtn ) { rtn = omuxCommand(omuxCmdSet.configurePositions); }
                if ( rtn ) { rtn = omuxCommand(omuxCmdSet.identifyDevice); }
                dev = result[0];
            }
        } catch (Exception e) { e.printStackTrace(); throw e; }
        return dev;
    }
    
    protected final String omuxCustomCommand(String cmd) throws IOException {
        try { 
            optoSIO.sendCommand(cmd);
            optoSIO.getResponse();
        } catch (IOException e) { e.printStackTrace(); throw e; }
        return optoSIO.getData();
    }
    
    protected final boolean omuxCommand(OMUXCommand cmd) throws Exception {
        boolean rtn = false;
        clearArray(result,0);
        try {
            rtn = sendCommand(cmd);
        } catch ( Exception e ) { e.printStackTrace(); throw e; }
        if ( rtn ) {
            switch (cmd.ioAction) {
                case DECODE_MASK:
                    decodeMask();
                    break;
                case DECODE_ARRAY:
                case DECODE_ARRAY_MASKS:
                    decodeWord(cmd.decodeWordWidth);
                    break;
                case NONE:    
                default:
                    break;
            }
        }
        clearArray(pos,END_OF_ARRAY);
        clearArray(mod,END_OF_ARRAY);
        clearArray(data,END_OF_ARRAY);
        return rtn;
    }
}///:~
