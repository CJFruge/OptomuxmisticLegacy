/*
 * PIDLoopParameters.java
 *
 * Created on May 4, 2007, 4:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package OptoMistic.Enum;

/**
 *
 * @author cjf
 */
public enum PIDLoopParameters {

    CONTROL(0x00,4),
    SCAN_RATE(0x01,4),
    OUTPUT_COUNTS_WORD(0x02,4),
    INPUT_SETPOINT_OUTPUT_CHANNELS(0x03,8),
    INPUT_VALUE_PROCESS(0x04,8),
    SETPOINT_VALUE(0x05,8),
    OUTPUT_VALUE(0x06,8),
    GAIN_TERM(0x07,8),
    INTEGRAL_TERM_RPM(0x08,8),
    DERIVATIVE_TERM(0x09,8),
    SETPOINT_MAXIMUM_LIMIT(0x0A,8),
    SETPOINT_MINIMUM_LIMIT(0x0B,8),
    OUTPUT_MAXIMUM_LIMIT(0x0C,8),
    OUTPUT_MINIMUM_LIMIT(0x0D,8),
    OUTPUT_MAXIMUM_CHANGE_PER_SCAN(0x0E,8),
    OUTPUT_COUNTS_LONG(0x0F,8),
    INPUT_FULL_SCALE_UNITS(0x10,8),
    INPUT_ZERO_SCALE_UNITS(0x11,8);
     
    private int pVal, pLen;
    PIDLoopParameters(int val,int len) { pVal = val; pLen = len; }
    public final int getValue() { return pVal; }
    public final int getLength() { return pLen; }
}///:~
