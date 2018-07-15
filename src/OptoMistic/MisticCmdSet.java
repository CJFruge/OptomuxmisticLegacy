/*
 * MisticCmdSet.java
 *
 * Created on May 1, 2007, 4:04 PM
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

public interface MisticCmdSet {
    
// general configuration    
public final MisticCommand identifyType = new MisticCommand("F",new CmdField(),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand powerUpClear = new MisticCommand("A",new CmdField(),new int[]{0},DRAction.NONE);
public final MisticCommand repeatLastResponse = new MisticCommand("^",new CmdField(),new int[]{0},DRAction.GET_STRING);
public final MisticCommand reset = new MisticCommand("B",new CmdField(),new int[]{0},DRAction.NONE);
public final MisticCommand setResponseDelay = new MisticCommand("~",new CmdField(false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setSystemOptions = new MisticCommand("C",new CmdField(true,2,true,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readModuleConfiguration = new MisticCommand("Y",new CmdField(),new int[]{2},DRAction.DECODE_ARRAY);
public final MisticCommand setChannelConfiguration = new MisticCommand("a",new CmdField(false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand storeSystemConfiguration = new MisticCommand("E",new CmdField(),new int[]{0},DRAction.NONE);
public final MisticCommand setIOConfigurationGroup = new MisticCommand("G",new CmdField(
    new boolean[] {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
    new int[] {4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}),new int[]{0},DRAction.NONE);

// event reaction
public final MisticCommand clearEventReactionTable = new MisticCommand("_",new CmdField(),new int[]{0},DRAction.NONE);
public final MisticCommand clearEventReactionTableEntry = new MisticCommand("\\",new CmdField(false,2),new int[]{0},DRAction.NONE);
public final MisticCommand clearInterrupt = new MisticCommand("zB",new CmdField(false,2),new int[]{0},DRAction.NONE);
public final MisticCommand enableDisableEventEntryGroup = new MisticCommand("{",new CmdField(true,2,true,4,true,4),new int[]{0},DRAction.NONE);
public final MisticCommand enableDisableEventEntry = new MisticCommand("N",new CmdField(false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand readClearEventLatches = new MisticCommand("Q",new CmdField(true,2),new int[]{4},DRAction.DECODE_ARRAY_MASKS);
public final MisticCommand readEventDataBuffer = new MisticCommand("|",new CmdField(false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readEventEntryStatus = new MisticCommand("v",new CmdField(true,2),new int[]{4},DRAction.DECODE_ARRAY_MASKS);
public final MisticCommand readEventLatches = new MisticCommand("P",new CmdField(true,2),new int[]{4},DRAction.DECODE_ARRAY_MASKS);
public final MisticCommand readClearEventLatch = new MisticCommand("zA",new CmdField(false,2,false,2),new int[]{2},DRAction.DECODE_MASK);
public final MisticCommand readEventTableEntry = new MisticCommand("O",new CmdField(false,2),new int[]{2,2,2,2,2,2,8,8},DRAction.DECODE_ARRAY_MASKS);
public final MisticCommand setEventInterruptStatus = new MisticCommand("I",new CmdField(false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setEventOnWatchdogTimeout = new MisticCommand("y",new CmdField(false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_NR = new MisticCommand("M",new CmdField(false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_EDETE = new MisticCommand("M",new CmdField(false,2,false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_EDEEG = new MisticCommand("M",new CmdField(false,2,false,2,true,4,true,4),new int[]{0},DRAction.NONE);
   
}///:~
