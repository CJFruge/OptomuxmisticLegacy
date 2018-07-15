/*
 * maintest.java
 *
 * Created on April 24, 2007, 2:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package maintest;

import OptoMux.*;
//import OptoMux.Enum.*;
import SerialIOSync.*;
import gnu.io.*;
import OptoMistic.*;
import OptoMistic.Enum.*;

/**
 *
 * @author cjf
 */

class MyOpto extends OptoMistic {

    //MisticCmdSet t = new MisticCmdSet();
    //DigitalCmdSet u = new DigitalCmdSet();
    
    public MyOpto(SerialIOSync sio, CRCType crc, int devID, int[] chanConfig) {
        super(sio,crc,devID,chanConfig);
    }
 //   public void test(MisticCommand tx) { boolean b = tx.getFieldType().getMask(0); }
    public void initDevice() { 
        //int devType = b1Init(true);
	try {
	    misticCommand(MisticCmdSet.enableDisableEventEntryGroup);
	} catch (Exception e) { e.printStackTrace(); }
    }
/*    public void initDevice() { 
        //int devType = b1Init(true);
        if ( isDigital() ) {
            try {
                copyArray(getSetCounterConfig(),getSetPosition());
                b1Command(b1CmdSet.startCounters);
                copyArray(getSetLatchConfig(),getSetPosition());
                b1Command(b1CmdSet.setOffToOnLatches);
                omuxCommand(b1CmdSet.readStatus);
            } catch (Exception e) { e.printStackTrace(); }
        }
	test(t.powerUpClear);
    }*/
}

public class maintest {
    
    /** Creates a new instance of maintest */
    public maintest() {
    }
      public static void main(String[] args) {
        SerialIOSync sio = null;
        MyOpto mo = null;
        int[] chanconfig = {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] latchconfig = {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] counterconfig = {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        try {
          sio = new SerialIOSync(args[0],19200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,false);
        } catch (Exception e) { e.printStackTrace(); }
        sio.setTimeOut(1200);
        mo = new MyOpto(sio,CRCType.CRC_16R,0x8b,chanconfig);
        
	mo.initDevice();
        //ob1.b1Command(b1Cmd.clearLatches);
        //mo.misticCommand(misticCmdSet.powerUpClear);
        //System.out.println(ob1.getDataString());
        //sio.close();
	
	System.out.println(mo.getDataString());
	sio.close();
	return;
        // strange error ob1.getDataString() += "test";
    }  
}
