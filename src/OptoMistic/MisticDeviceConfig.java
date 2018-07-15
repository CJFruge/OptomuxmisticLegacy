/*
 * MisticDeviceConfig.java
 *
 * Created on May 2, 2007, 4:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMistic;

import OptoMistic.Enum.*;
import java.io.*;


public class MisticDeviceConfig implements Serializable {
    
    private int[] ioConfig = new int[Constants.MAX_CHANNELS.getValue()];
    private int devID;

    public MisticDeviceConfig() {
    }
    
}
