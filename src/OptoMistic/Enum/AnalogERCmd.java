/*
 * AnalogERCmd.java
 *
 * Created on May 4, 2007, 3:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package OptoMistic.Enum;

/**
 *
 * @author cjf
 */
public enum AnalogERCmd {
    NULL_REACTION(0x00),
    SET_DAC_MODULE_COUNTS(0x01),
    SET_DAC_MODULE_UNITS(0x02),
    RAMP_DAC_OUTPUT_TO_ENDPOINT(0x03),
    ENABLE_DISABLE_PID_LOOP(0x04),
    SET_PID_LOOP_SETPOINT(0x05),
    ENABLE_DISABLE_TABLE_ENTRY(0x06),
    ENABLE_DISABLE_ENTRY_GROUP(0x07),
    READ_HOLD_IO_DATA(0x08),
    SET_PID_LOOP_MINMAX_OUTPUT_LIMITS(0X09);
    
    private int pVal = -1;
    AnalogERCmd(int val) { pVal = val; }
    public int getValue() { return pVal; }
}///:~
