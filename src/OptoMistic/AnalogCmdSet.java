/*
 * AnalogCmdSet.java
 *
 * Created on May 4, 2007, 1:39 AM
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

public interface AnalogCmdSet {

// setup, configuration
public final MisticCommand setCommlinkWatchDogDelay = new MisticCommand("D",new CmdField(false,4),new int[]{0},DRAction.NONE);
public final MisticCommand setCommlinkWatchDogTimeoutData =
    new MisticCommand("H",new CmdField(
    new boolean[] {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
    new int[] {4,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8}),new int[]{0},DRAction.NONE);
public final MisticCommand calculateSetADCModuleOffset = new MisticCommand("d",new CmdField(false,2),new int[]{0},DRAction.NONE);
public final MisticCommand calculateSetADCModuleGain = new MisticCommand("e",new CmdField(false,2),new int[]{0},DRAction.DECODE_ARRAY);
public final MisticCommand setADCModuleOffset = new MisticCommand("b",new CmdField(false,2,false,4),new int[]{0},DRAction.NONE);
public final MisticCommand setADCModuleGain = new MisticCommand("c",new CmdField(false,2,false,4),new int[]{0},DRAction.NONE);
public final MisticCommand setAveragingSampleWeight = new MisticCommand("h",new CmdField(false,2,false,4),new int[]{0},DRAction.NONE);
public final MisticCommand setEngineeringUnitScaling = new MisticCommand("f",new CmdField(false,2,false,8,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setTotalizationSampleRate = new MisticCommand("g",new CmdField(false,2,false,4),new int[]{0},DRAction.NONE);
public final MisticCommand setTPOResolution = new MisticCommand("]",new CmdField(false,2,false,2),new int[]{0},DRAction.NONE);

// read/write output
public final MisticCommand rampDACOutputToEndpoint = new MisticCommand("Z",new CmdField(false,2,false,8,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand readClearIOModuleData_COUNTS = new MisticCommand("s",new CmdField(false,2,false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readClearIOModuleData_SQRTUNITS = new MisticCommand("s",new CmdField(false,2,false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readClearIOModuleDataGroup_COUNTS = new MisticCommand("S",new CmdField(true,4,false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readClearIOModuleDataGroup_SQRTUNITS = new MisticCommand("S",new CmdField(true,4,false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readIOModuleData_COUNTS = new MisticCommand("r",new CmdField(false,2,false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readIOModuleData_SQRTUNITS = new MisticCommand("r",new CmdField(false,2,false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand readIOModuleDataGroup_COUNTS = new MisticCommand("R",new CmdField(true,4,false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readIOModuleDataGroup_SQRTUNITS = new MisticCommand("R",new CmdField(true,4,false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand setDACModuleUnits = new MisticCommand("w",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setDACModuleUnitsGroup = 
    new MisticCommand("W",new CmdField(
    new boolean[] {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false },
    new int[] {4,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8}),new int[]{0},DRAction.NONE);
public final MisticCommand setDACModuleCounts = new MisticCommand("x",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setDACModuleCountsGroup = 
    new MisticCommand("X",new CmdField(
    new boolean[] {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false },
    new int[] {4,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8}),new int[]{0},DRAction.NONE);

// event/reaction
public final MisticCommand setEventOnIOGreater16 = new MisticCommand("K",new CmdField(false,2,false,2,false,2,false,4),new int[]{0},DRAction.NONE);
public final MisticCommand setEventOnIOGreater32 = new MisticCommand("K",new CmdField(false,2,false,2,false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setEventOnIOLess16 = new MisticCommand("L",new CmdField(false,2,false,2,false,2,false,4),new int[]{0},DRAction.NONE);
public final MisticCommand setEventOnIOLess32 = new MisticCommand("L",new CmdField(false,2,false,2,false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_SDMC = new MisticCommand("M",new CmdField(false,2,false,2,false,4),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_SDMU = new MisticCommand("M",new CmdField(false,2,false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_RDOTE = new MisticCommand("M",new CmdField(false,2,false,2,false,8,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_EDPL = new MisticCommand("M",new CmdField(false,2,false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_SPLS = new MisticCommand("M",new CmdField(false,2,false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_RHIOD = new MisticCommand("M",new CmdField(false,2,false,2,false,2),new int[]{0},DRAction.NONE);
public final MisticCommand setERCommand_SPLMMOL = new MisticCommand("M",new CmdField(false,2,false,2,false,8,false,8),new int[]{0},DRAction.NONE);

// pid loop
public final MisticCommand initializePID = new MisticCommand("i",new CmdField(false,2,false,2,false,2,false,2,false,4),new int[]{0},DRAction.NONE);
public final MisticCommand readAllPIDParameters = new MisticCommand("T",new CmdField(false,2),
    new int[]{4,4,2,2,2,2,8,8,8,8,8,8,8,4,4,8,8,8,8,8,8},DRAction.DECODE_ARRAY);
public final MisticCommand readPIDParameterL4 = new MisticCommand("t",new CmdField(false,2,false,2),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand readPIDParameterL8 = new MisticCommand("t",new CmdField(false,2,false,2),new int[]{8},DRAction.DECODE_ARRAY);
public final MisticCommand setPIDControlOptions = new MisticCommand("j",new CmdField(false,2,true,4,true,4),new int[]{4},DRAction.DECODE_ARRAY);
public final MisticCommand setPIDDerivateRate = new MisticCommand("n",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setPIDGain = new MisticCommand("l",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setPIDIntegralResetRate = new MisticCommand("m",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setPIDMaxRateChange = new MisticCommand("u",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setPIDMinMaxOutputLimits = new MisticCommand("p",new CmdField(false,2,false,8,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setPIDMinMaxSetpointLimits = new MisticCommand("o",new CmdField(false,2,false,8,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setPIDProcessVariable = new MisticCommand("q",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
public final MisticCommand setPIDSetpoint = new MisticCommand("k",new CmdField(false,2,false,8),new int[]{0},DRAction.NONE);
}///:~
