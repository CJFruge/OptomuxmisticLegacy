/*
 * TurnAroundDELAY_.java
 *
 * Created on April 29, 2007, 12:45 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux.Enum;

public enum TurnAroundDelay {

    DELAY_0_MS(0),
    DELAY_10_MS(1),
    DELAY_100_MS(2),
    DELAY_500_MS(3);
     
    private int pVal = -1;
    TurnAroundDelay(int val) { pVal = val; }
    public int getValue() { return pVal; }
     
     
}///:~
