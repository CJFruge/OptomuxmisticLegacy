/*
 * OptoB2.java
 *
 * Created on April 28, 2007, 7:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
*/
/**
 *
 * @author cjf
 *
*/

package OptoMux;

import OptoMux.Enum.*;
import SerialIOSync.*;
import OptoMux.*;
import java.util.*;
import gnu.io.*;
import java.io.*;

public class OptoB2 extends OptoComm {
    
    public B2CmdSet b2CmdSet = new B2CmdSet();
    private int[] avgConfig = new int[MAX_CHANNELS];
    private int[] bits = new int[MAX_CHANNELS];
    private int[] analog = new int[MAX_CHANNELS];
    private int[] latch = new int[MAX_CHANNELS];
    private int[] offset = new int[MAX_CHANNELS];
    private int[] coefficient = new int[MAX_CHANNELS];
    private boolean isAnalog;
    
    public OptoB2(SerialIOSync sio,int deviceID,int[] ioCfg,int[] averageConfig) {
        super(sio,deviceID,ioCfg);
        copyArray(averageConfig,avgConfig);
        //b2Command(identifyDevice);
        isAnalog = (getResult(0) == DeviceType.ANALOG.getValue());
    }
    
    public int[] getSetAverageConfig() { return avgConfig; }
    
    public final boolean isAnalog() { return isAnalog; }
    
    public final int[] getValues() { return analog; }
    public final int[] getBits() { return bits; }
    public final int[] getLatches() { return latch; }
    public final int[] getOffsets() { return offset; }
    
    public final int getValue(int position) {
        position &= 0xf;
        return analog[position];
    }

    public final int getBit(int position) {
        position &= 0xf;
        return bits[position];
    }    
    
    public boolean b2Command(OMUXCommand cmd) throws Exception {
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
                    copyArray(getResults(),analog);
                    for ( int j : analog ) { j -= 0x1000; }
                    break;
                case DECODE_ARRAY_MASKS:
                    int lo = getResult(0);
                    int hi = getResult(1);
                    for ( int j=0; j<latch.length; j++ ) {
                        latch[j] = 0;
                        latch[j] += (lo & (1 << j)) == 1 ? 1 : 0; 
                        latch[j] += (hi & (1 << j)) == 1 ? 2 : 0; 
                    }
                    break;
                case NONE:    
                default:
                    break;
            }
        }
        return rtn;
    }
}///:~
