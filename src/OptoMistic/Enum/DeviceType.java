/*
 * DeviceType.java
 *
 * Created on May 1, 2007, 4:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package OptoMistic.Enum;

/**
 *
 * @author cjf
 */
public enum DeviceType {
    UNKNOWN(0x01),
    REMOTE_16_DIGITAL_MULTIFUNCTION(0x10),
    REMOTE_16_ANALOG(0x12),
    REMOTE_08_ANALOG(0x13),
    LOCAL_16_DIGITAL_MULTIFUNCTION(0x20),
    LOCAL_16_DIGITAL_NONEMULTIFUNCTION(0x21),
    LOCAL_16_ANALOG(0x22),
    LOCAL_08_ANALOG(0x23),
    B3000_DIGITAL_MULTIFUNCTION(0x48),
    B3000_ANALOG_MULTIFUNCTION(0x50);

    private int pVal = -1;
    DeviceType(int val) { pVal = val; }
    public int getValue() { return pVal; }
}///:~
