/*
 * DigitalERCmd.java
 *
 * Created on May 2, 2007, 3:28 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMistic.Enum;

public enum DigitalERCmd {
    NULL_REACTION(0x00),
    SET_OUTPUT_MODULE_STATE_GROUP(0x01),
    START_ON_PULSE(0x02),
    START_OFF_PULSE(0x03),
    ENABLE_DISABLE_COUNTER(0x04),
    CLEAR_COUNTER(0x05),
    ENABLE_DISABLE_TABLE_ENTRY(0x06),
    ENABLE_DISABLE_ENTRY_GROUP(0x07),
    READ_HOLD_COUNTER_TIMER_VALUE(0x08);
    
    private int pVal = -1;
    DigitalERCmd(int val) { pVal = val; }
    public int getValue() { return pVal; }
}///:~
