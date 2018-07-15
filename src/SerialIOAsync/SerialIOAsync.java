 /* Created on April 22, 2007, 4:47 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package SerialIOAsync;

import gnu.io.*;
import java.io.*;
import java.util.*;

public class SerialIOAsync implements Runnable, SerialPortEventListener {

    private CommPortIdentifier portId = null;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private SerialPort serialPort = null;
    private Thread readThread = null;
    private StringBuffer response = new StringBuffer();
    private String data = new String();
    
    public SerialIOAsync(String comPortName, int baudRate, int dataBits, int stopBits, int parity, boolean RTS_CTS) throws Exception {

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
            serialPort.addEventListener(this);
        } catch (TooManyListenersException e) {
            if ( portId.isCurrentlyOwned() ) { serialPort.close(); }
            e.printStackTrace(); 
            throw e; 
        }
        
        try {
            serialPort.notifyOnDataAvailable(true);
            serialPort.setSerialPortParams(baudRate,dataBits,stopBits,parity);
            serialPort.setDTR(false);
            serialPort.setRTS(RTS_CTS);
        } catch (UnsupportedCommOperationException e) {
            if ( portId.isCurrentlyOwned() ) { serialPort.close(); }
            e.printStackTrace(); 
            throw e; 
        }

        readThread = new Thread(this);
        readThread.start();
    }
    
    protected void finalize() { 
        try {
            super.finalize(); close(); 
        } catch (Throwable e) { e.printStackTrace(); }
    }
 
    public void close() { if ( portId.isCurrentlyOwned() ) serialPort.close(); }
    
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
    
    public void serialEvent(SerialPortEvent event) {
        int charAvail;
        byte[] readBuff = {0};
        switch(event.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:    
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                response.delete(0,response.length());
                try {
		    charAvail = inputStream.available();
		    if ( charAvail > 0 ) {
			readBuff = new byte[charAvail];
			inputStream.read(readBuff);
			response.append(new String(readBuff));
		    }
	    } catch (IOException e) { e.printStackTrace(); }         
                data = response.substring(0);
                break;
        }
    }

    public final String getData() { return data; }
 
    public void sendCommand(String cmd) throws IOException {
        try {
            byte[] outBytes = cmd.getBytes();
            outputStream.write(outBytes,0,outBytes.length);                
        } catch ( IOException e ) { e.printStackTrace(); throw e; }            
    }
} //*~