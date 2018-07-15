/*
 * MisticCommand.java
 *
 * Created on May 1, 2007, 3:50 PM
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

public class MisticCommand {
   
    private String cmdS;
    private CmdField fT;
    private int[] decodeWordWidth;
    private DRAction drAction;

    MisticCommand
        (String newCmd, 
        CmdField newFT,
        int[] newDecodeWordWidth,
        DRAction newDrAction) {

        cmdS = new String(newCmd);
        fT = newFT;
        decodeWordWidth = newDecodeWordWidth;
        drAction = newDrAction;
    }
    public final CmdField getFieldType() { return fT; }
    public final int getDecodeLength() { return decodeWordWidth.length; }
    public final int getDecodeWidth(int f) { 
	if ( f >= decodeWordWidth.length ) { return Constants.END_OF_ARRAY.getValue(); }
	else { return decodeWordWidth[f %= decodeWordWidth.length]; }
    }	
    public final DRAction getDRAction() { return drAction; }
    public final String getCmd() { return cmdS; }
}///:~
