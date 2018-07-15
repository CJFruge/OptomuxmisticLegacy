/*
 * SerialIOSync.java
 *
 * Created on April 23, 2007, 2:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package SerialIOSync;

import gnu.io.*;
import java.io.*;
import java.util.*;

public class SerialIOSync {

    private CommPortIdentifier portId = null;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private SerialPort serialPort = null;
    private StringBuilder response = new StringBuilder();
    private long msTimeOut = 2000;
    private String data = new String();
    
    public static void main(String[] args) {
        try {
            SerialIOSync sio = new SerialIOSync(args[0],38400,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,true);
        }
        catch (Exception e) { System.err.println(e); }
    }
    
    public SerialIOSync(String comPortName, int baudRate, int dataBits, int stopBits, int parity, boolean RTS_CTS) throws Exception {

        try {
            portId = CommPortIdentifier.getPortIdentifier(comPortName);
            serialPort = (SerialPort) portId.open(this.getClass().getName(), 2000);
        } catch (PortInUseException e) { e.printStackTrace(); throw e; }

        try {
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
        } catch (IOException e) { 
            if ( portId.isCurrentlyOwned() ) { serialPort.close(); }
            e.printStackTrace(); 
            throw e; 
        }
        
        try {
            serialPort.setSerialPortParams(baudRate,dataBits,stopBits,parity);
            serialPort.setDTR(false);
            serialPort.setRTS(RTS_CTS);
        } catch (UnsupportedCommOperationException e) {
            if ( portId.isCurrentlyOwned() ) { serialPort.close(); }
            e.printStackTrace(); 
            throw e; 
        }
    }
 
    protected void finalize() { 
        try {
            super.finalize(); close(); 
        } catch (Throwable e) { e.printStackTrace(); }
    }
    
    public void close() { if ( portId.isCurrentlyOwned() ) serialPort.close(); }
    
    public void getResponse () throws IOException {
        byte[] readBuff = {0};
        int charAvail;
        response.delete(0,response.length());
        long ts = Calendar.getInstance().getTimeInMillis();
        try {
            while ( readBuff[readBuff.length-1] != '\r' ) {
                charAvail = inputStream.available();
                if ( charAvail > 0 ) {
                    readBuff = new byte[charAvail];
                    inputStream.read(readBuff);
                    response.append(new String(readBuff));
                }
                if ( Calendar.getInstance().getTimeInMillis() > (ts + msTimeOut) ) {
                    response.delete(0,response.length());
                    response.append("TIMEOUT");
                    break;
                }
            }
        } catch (IOException e) { e.printStackTrace(); throw e; }         
        data = response.substring(0);
    }
    
    public String getData() { return data; }
    
    public void setTimeOut(long newMsTimeOut) { msTimeOut = newMsTimeOut; }
    
    public void sendCommand(String cmd) throws IOException {
        try {
            byte[] outBytes = cmd.getBytes();
            outputStream.write(outBytes,0,outBytes.length);                
        } catch ( IOException e ) { e.printStackTrace(); throw e; }            
    }
} //*~
