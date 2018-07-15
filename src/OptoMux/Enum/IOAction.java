/*
 * IOAction.java
 *
 * Created on April 29, 2007, 4:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux.Enum;

public enum IOAction {
    NONE(0),
    DECODE_MASK(1),
    DECODE_ARRAY(2),
    DECODE_ARRAY_MASKS(3),
    GET_STRING(4);

    private int pVal = -1;
    IOAction(int val) { pVal = val; }
    public int getValue() { return pVal; }
}///:~
