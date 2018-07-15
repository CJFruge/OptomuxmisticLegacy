/*
 * Optob1.java
 *
 * Created on April 23, 2007, 12:01 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux;

import OptoMux.Enum.*;
import SerialIOSync.*;
import OptoMux.*;
import java.util.*;
import gnu.io.*;
import java.io.*;

public class OptoB1 extends OptoComm {    
    
    public B1CmdSet b1CmdSet = new B1CmdSet();
//    public ZCommandModifier zCommandModifier = new ZCommandModifier();
//    public WatchDogTimer watchDogTimer = new WatchDogTimer();

    private boolean isDigital = false;
    private int[] counterConfig = new int[OptoComm.MAX_CHANNELS];
    private int[] latchConfig = new int[OptoComm.MAX_CHANNELS];
    private int[] counters = new int[OptoComm.MAX_CHANNELS];
    private int[] bits = new int[OptoComm.MAX_CHANNELS];

    // constructor
    public OptoB1(SerialIOSync sio,int deviceID,int[] ioCfg,int[] latchCfg,int[] counterCfg) {
        super(sio,deviceID,ioCfg);
        boolean rtn = false;
        copyArray(latchCfg,latchConfig);
        copyArray(counterCfg,counterConfig);
        try {
            rtn = b1Command(omuxCmdSet.identifyDevice);
        } catch (Exception e) { e.printStackTrace(); }
        if ( rtn ) { isDigital = (getResult(0) == DeviceType.DIGITAL.getValue()); }
    }
    
    public int b1Init(boolean forceInit) {
        int rtn = 0;
        if ( isDigital ) {
            try {
                rtn = initDevice(forceInit);
            } catch (Exception e) { e.printStackTrace(); }    
        }
        return rtn;
    }
    
    // accessors
    public int[] getSetLatchConfig() { return latchConfig; }

    public int[] getSetCounterConfig() { return counterConfig; }
    
    public final boolean isDigital() { return isDigital; }
    
    public final int[] getCounters() { return counters; }
    public final int[] getBits() { return bits; }
    
    public final int getCounter(int position) {
        position &= 0xf;
        return counters[position];
    }

    public final int getBit(int position) {
        position &= 0xf;
        return bits[position];
    }

    public final boolean b1Command(OMUXCommand cmd) throws Exception {
        boolean rtn = false;
        try {
            rtn = omuxCommand(cmd);
        } catch (Exception e) { e.printStackTrace(); throw e; }
        if ( rtn ) {
            switch (cmd.ioAction) {
                case DECODE_MASK:
                    copyArray(getResults(),bits);
                    break;
                case DECODE_ARRAY:
                    copyArray(getResults(),counters);
                    break;
                case NONE:    
                default:
                    break;
            }        
        }
        return rtn;
    }
} ///:~
