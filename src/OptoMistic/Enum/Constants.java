/*
 * Constants.java
 *
 * Created on May 2, 2007, 5:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMistic.Enum;

public enum Constants {
    END_OF_ARRAY(-1),
    MAX_CHANNELS(16),
    MAX_LATCHES(256),
    MAX_FIELDS(18),
    MISTIC_CRC_INIT(0x00);

    private int pVal = -1000;
    Constants(int val) { pVal = val; }
    public int getValue() { return pVal; }
}
