/*
 * DigitalCmdSet.java
 *
 * Created on May 2, 2007, 5:40 AM
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

public interface DigitalCmdSet {

// configuration
public final MisticCommand resetAllToDefault = new MisticCommand("x",new CmdField(),new int[]{0},DRAction.NONE);
public final MisticCommand setWatchDogMomoAndDelay = new MisticCommand("D",new CmdField(true,4,true,4,false,4),new int[]{0},DRAction.NONE);

// read/write & latch commands
public final MisticCommand clearOutput = new MisticCommand("e",new CmdField(false,2),new int[]{0},DRAction.NONE);
public final MisticCommand readClearLatchesGroup = new MisticCommand("S",new CmdField(true,2),new int[]{4},DRAction.DECODE_ARRAY_MASKS);
public final MisticCommand readClearLatch = new MisticCommand("w",new CmdField(false,2), new int[]{0},DRAction.NONE);
public final MisticCommand readModuleStatus = new MisticCommand("R",new CmdField(),new int[]{4},DRAction.DECODE_MASK); 
public final MisticCommand setOutputStateGroup = new MisticCommand("J",new CmdField(true,4,true,4),new int[]{0},DRAction.NONE);
public final MisticCommand setOutput = new MisticCommand("d",new CmdField(false,2),new int[]{0},DRAction.NONE);

// counter commands
public final MisticCommand clearCounter = new MisticCommand("c",new CmdField(false,2),new int[]{0},DRAction.NONE);
public final MisticCommand enableDisableCounterGroup = new MisticCommand("H",new CmdField(true,4,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand enableDisableCounter = new MisticCommand("b",new CmdField(false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand read16BitCounter = new MisticCommand("m",new CmdField(false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand read32BitCounterGroup = new MisticCommand("T",new CmdField(true,4),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand read32BitCounter = new MisticCommand("l",new CmdField(false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readClear16BitCounter = new MisticCommand("o",new CmdField(false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readClear32BitCounterGroup = new MisticCommand("U",new CmdField(true,4),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readClear32BitCounter = new MisticCommand("n",new CmdField(false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readCounterStatus = new MisticCommand("u",new CmdField(),new int[]{4},DRAction.DECODE_MASK);
public final MisticCommand readFrequency = new MisticCommand("t",new CmdField(false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readFrequencyGroup = new MisticCommand("Z",new CmdField(true,4),new int[]{4},DRAction.DECODE_ARRAY);

// time delay and pulse commands (output)
public final MisticCommand generateNPulses = new MisticCommand("i",new CmdField(false,8,false,8,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand readOutputTimer = new MisticCommand("k",new CmdField(false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand setTPOPeriod = new MisticCommand("]",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setTPOPercentage = new MisticCommand("j",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand startContinuousSquareWave = new MisticCommand("h",new CmdField(false,2,false,8,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand startOffPulse = new MisticCommand("g",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand startOnPulse = new MisticCommand("f",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);

// pulse period measurement (input)
public final MisticCommand read16BitPulsePeriod = new MisticCommand("q",new CmdField(false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand read32BitPulsePeriodGroup = new MisticCommand("W",new CmdField(true,4),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand read32BitPulsePeriod = new MisticCommand("q",new CmdField(false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readRestart16BitPulsePeriod = new MisticCommand("s",new CmdField(false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readRestart32BitPulsePeriod = new MisticCommand("r",new CmdField(false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readRestart32BitPulsePeriodGroup = new MisticCommand("X",new CmdField(true,4),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readPulsePeriodComplete = new MisticCommand("r",new CmdField(),new int[]{4},DRAction.DECODE_MASK);

// event/reaction
public final MisticCommand setEventCounterTimerGreater = new MisticCommand("L",new CmdField(false,2,false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setEventCounterTimerLess = new MisticCommand("}",new CmdField(false,2,false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setEventOnMOMOMatch = new MisticCommand("K",new CmdField(false,2,true,4,true,4),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_SOMSG = new MisticCommand("M",new CmdField(false,2,true,4,true,4),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_SONP = new MisticCommand("M",new CmdField(false,2,false,2,true,8),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_SOFFP = new MisticCommand("M",new CmdField(false,2,false,2,true,8),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_EDC = new MisticCommand("M",new CmdField(false,2,false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_CC = new MisticCommand("M",new CmdField(false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_RHCTV = new MisticCommand("M",new CmdField(false,2,false,2),new int[]{0},DRAction.NONE);

}///:~
