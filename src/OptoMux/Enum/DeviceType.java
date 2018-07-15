/*
 * DeviceType.java
 *
 * Created on April 29, 2007, 12:42 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux.Enum;

public enum DeviceType {
    UNKNOWN(10),
    DIGITAL(0),
    ANALOG(1);

    private int pVal = -1;
    DeviceType(int val) { pVal = val; }
    public int getValue() { return pVal; }
}///:~
