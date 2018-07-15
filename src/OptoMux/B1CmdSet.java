/*
 * B1CmdSet.java
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

public class B1CmdSet {
    
    //setup commands
    public final OMUXCommand setTimerResolution = new OMUXCommand('n',"","","%04X",0,IOAction.NONE);   
    public final OMUXCommand setDigitalWatchdog = new OMUXCommand('D',"","","%1X",0,IOAction.NONE);
    public final OMUXCommand setEnhancedWatchdog = new OMUXCommand('m',"%04X","","%04X",0,IOAction.NONE);
    
    // status and on/off outputs
    public final OMUXCommand writeOutputs = new OMUXCommand('J',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand activateOutputs = new OMUXCommand('K',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand deactivateOutputs = new OMUXCommand('L',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand readStatus = new OMUXCommand('M',"%04X","","",0,IOAction.DECODE_MASK);
    
    // input latches
    public final OMUXCommand setLatchEdges = new OMUXCommand('N',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand setOffToOnLatches = new OMUXCommand('O',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand setOnToOffLatches = new OMUXCommand('P',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand readLatches = new OMUXCommand('Q',"","","",0,IOAction.DECODE_MASK);
    public final OMUXCommand readClearLatches = new OMUXCommand('R',"%04X","","",0,IOAction.DECODE_MASK);
    public final OMUXCommand clearLatches = new OMUXCommand('S',"%04X","","",0,IOAction.NONE);
    
    // input counters
    public final OMUXCommand startStopCounters = new OMUXCommand('T',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand startCounters = new OMUXCommand('U',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand stopCounters = new OMUXCommand('V',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand readCounters = new OMUXCommand('W',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand readClearCounters = new OMUXCommand('X',"%04X","","",4,IOAction.DECODE_ARRAY);
    public final OMUXCommand clearCounters = new OMUXCommand('Y',"%04X","","",0,IOAction.NONE);
    
    // time delay and pulse output
    public final OMUXCommand setTimeDelay_Z = new OMUXCommand('Z',"%04X","%c","%04X",0,IOAction.NONE);
    public final OMUXCommand initiateSquareWave_Z = new OMUXCommand('Z',"%04X","%c","%02X",0,IOAction.NONE);
    public final OMUXCommand turnOffTimeDelaySquareWave_Z = new OMUXCommand('Z',"%04X","%c","",0,IOAction.NONE);
    public final OMUXCommand highResolutionSquareWave_Z = new OMUXCommand('Z',"%04X","%c","%02X",0,IOAction.NONE);
    public final OMUXCommand startOnPulse = new OMUXCommand('k',"%04X","","%04X",0,IOAction.NONE);
    public final OMUXCommand startOffPulse = new OMUXCommand('l',"%04X","","%04X",0,IOAction.NONE);
    public final OMUXCommand retriggerTimeDelay = new OMUXCommand('h',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand generateNPulses = new OMUXCommand('i',"%04X","%02X","%04X",0,IOAction.NONE);

    // pulse duration inputs
    public final OMUXCommand setPulseTriggerPolarity = new OMUXCommand('a',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand triggerOnPositivePulse = new OMUXCommand('b',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand triggerOnNegativePulse = new OMUXCommand('c',"%04X","","",0,IOAction.NONE);
    public final OMUXCommand readPulseCompleteBits = new OMUXCommand('d',"","","",0,IOAction.DECODE_MASK);
    public final OMUXCommand readDurationCounters = new OMUXCommand('e',"%04X","","",0,IOAction.DECODE_MASK);
    public final OMUXCommand readClearDurationCounters = new OMUXCommand('f',"%04X","","",0,IOAction.DECODE_MASK);
    public final OMUXCommand clearDurationCounters = new OMUXCommand('g',"%04X","","",0,IOAction.DECODE_MASK);
}///:~
