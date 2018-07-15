/*
 * WatchDogTIME_r.java
 *
 * Created ON April 29, 2007, 1:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux.Enum;

public enum WatchDogTimer {

    DISABLED(0),
    TIME_10_SEC__ALL_OFF(1),
    TIME_1_MIN__ALL_OFF(2),
    TIME_10_MIN__ALL_OFF(3),
    TIME_1_SEC__ZERO_ON(5),
    TIME_1_MIN__ZERO_ON(6),
    TIME_10_MIN__ZERO_ON(7);

    private int pVal = -1;
    WatchDogTimer(int val) { pVal = val; }
    public int getValue() { return pVal; }

     
}///:~
 