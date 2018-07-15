/*
 * OutOfRangeLatch.java
 *
 * Created on April 29, 2007, 5:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux.Enum;

public enum OutOfRangeLatch {
    IN_RANGE(0),
    LOW(1),
    HIGH(2),
    BOTH(3);
    
    private int pVal = -1;
    OutOfRangeLatch(int val) { pVal = val; }
    public int getValue() { return pVal; }
}///:~
