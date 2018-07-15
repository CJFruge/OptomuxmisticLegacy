/*
 * B2CmdSet.java
 *
 * Created on April 28, 2007, 11:29 PM
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

public class B2CmdSet {
    
    // setup commands
    public final OMUXCommand setAnalogWatchdog = new OMUXCommand('D',"%04X","","%1X",0,IOAction.NONE);
    public final OMUXCommand setAnalogWatchdogTimeout = new OMUXCommand('m',"%04X","","%03X",0,IOAction.NONE);
    public final OMUXCommand setTemperatureProbeType = new OMUXCommand('k',"%04X","","%1X",0,IOAction.NONE);
     
    // output commands
    public final OMUXCommand writeAnalogOutputs = new OMUXCommand('J',"%04X","","%03X",0,IOAction.NONE);
    public final OMUXCommand readAnalogOutputs = new OMUXCommand('K',"%04X","","",3,IOAction.DECODE_ARRAY);
    public final OMUXCommand updateAnalogOutputs = new OMUXCommand('S',"%04X","","%02X",0,IOAction.NONE);

    // input commands
    public final OMUXCommand readAnalogInputs = new OMUXCommand('L',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand startAveragingInputs = new OMUXCommand('T',"%04X","","%02X",0,IOAction.NONE);
    public final OMUXCommand readAveragedInputs = new OMUXCommand('U',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand readAverageCompleteBits = new OMUXCommand('i',"","","",0,IOAction.DECODE_MASK);

    // temp commands
    public final OMUXCommand readTemperatureInputs = new OMUXCommand('l',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand readAverageTemperatureInputs = new OMUXCommand('o',"%04X","","",4,IOAction.DECODE_ARRAY);

    // input range commands
    public final OMUXCommand setInputRange = new OMUXCommand('N',"%04X","","%03X",0,IOAction.NONE);
    public final OMUXCommand readOutOfRangeLatches = new OMUXCommand('O',"","","",4,IOAction.DECODE_ARRAY_MASKS);
    public final OMUXCommand readClearOutOfRangeLatches = new OMUXCommand('P',"%04X","","",4,IOAction.DECODE_ARRAY_MASKS);
    public final OMUXCommand clearOutOfRangeLatches = new OMUXCommand('Q',"%04X","","",0,IOAction.NONE); 
    public final OMUXCommand readLowestValues = new OMUXCommand('a',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand clearLowestValues = new OMUXCommand('b',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand readClearLowestValues = new OMUXCommand('c',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand readPeakValues = new OMUXCommand('d',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand clearPeakValues = new OMUXCommand('e',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand readClearPeakValues = new OMUXCommand('f',"%04X","","",4,IOAction.DECODE_ARRAY);

    // conversion input commands
    public final OMUXCommand calculateOffsets = new OMUXCommand('g',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand setOffsets = new OMUXCommand('W',"%04X","","%04X",0,IOAction.NONE);
    public final OMUXCommand calculateSetOffsets = new OMUXCommand('h',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand calculateGainCoefficients = new OMUXCommand('X',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand setGainCoefficients = new OMUXCommand('Y',"%04X","","%04X",0,IOAction.NONE);
    public final OMUXCommand calculateSetGainCoefficients = new OMUXCommand('Z',"%04X","","",4,IOAction.DECODE_ARRAY);
    
    //public final OMUXCommand setOutputWaveform = new OMUXCommand('R',"%04X","%1X","%02X",0,IOAction.NONE);
}
