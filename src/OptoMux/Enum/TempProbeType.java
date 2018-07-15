/*
 * TempProbeType.java
 *
 * Created on April 29, 2007, 4:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package OptoMux.Enum;

/**
 *
 * @author cjf
 */
public enum TempProbeType {
    NO_PROBE(0),
    ICTD(1),
    OHM_10_RTD(2),
    OHM_100_RTD(3),
    J_THERMOCOUPLE(4),
    K_THERMOCOUPLE(5),
    R_THERMOCOUPLE(6),
    S_THERMOCOUPLE(7),
    T_THERMOCOUPLE(8),
    E_THERMOCOUPLE(9);  

    private int pVal = -1;
    TempProbeType(int val) { pVal = val; }
    public int getValue() { return pVal; }

}///:~
