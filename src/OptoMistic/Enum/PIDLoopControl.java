/*
 * PIDLoopControl.java
 *
 * Created on May 4, 2007, 4:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package OptoMistic.Enum;

/**
 *
 * @author cjf
 */
public enum PIDLoopControl {
    MAX_SETPOINT_EXCEEDED(0x10),
    MIN_SETPOINT_EXCEEDED(0x09),
    INPUT_MODULE_INACTIVE(0x08),
    ACTIVE_RESET(0x07),
    AUTO_MANUAL(0x06),
    ENABLED_DISABLED(0x05),
    OUTPUT_TRACK_MANUAL(0x04),
    SETPOINT_TRACK_MANUAL(0x03),
    PROCESS_VARIABLE_FROM_HOST(0x02),
    SETPOINT_CHANNEL_HOST(0x01),
    AVERAGE_READING(0x00);
    
    private int pVal;
    PIDLoopControl(int val) { pVal = val; }
    public final int getValue() { return pVal; }    
}///:~
