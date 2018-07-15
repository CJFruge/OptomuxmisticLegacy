/*
 * OMUXCmdSet.java
 *
 * Created on April 28, 2007, 11:35 PM
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

public class OMUXCmdSet {
    
    public final OMUXCommand powerUpClear = new OMUXCommand('A',"","","",0,IOAction.NONE);
    public final OMUXCommand reset = new OMUXCommand('B',"","","",0,IOAction.NONE);
    public final OMUXCommand setTurnaroundDelay = new OMUXCommand('C',"","","%01X",0,IOAction.NONE);
    public final OMUXCommand setProtocol = new OMUXCommand('E',"","","%01X",0,IOAction.NONE);
    public final OMUXCommand identifyDevice = new OMUXCommand('F',"","","",2,IOAction.DECODE_ARRAY);
    public final OMUXCommand configurePositions = new OMUXCommand('G',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand configureInputs = new OMUXCommand('H',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand configureOutputs = new OMUXCommand('I',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand readModuleConfiguration = new OMUXCommand('j',"","","",0,IOAction.DECODE_MASK);
    public final OMUXCommand dateOfFirmware = new OMUXCommand('`',"","","",0,IOAction.GET_STRING); 
}///:~
