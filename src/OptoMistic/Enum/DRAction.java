/*
 * DRAction.java
 * (D)evice (R)esponse Action
 * Created on April 29, 2007, 4:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMistic.Enum;

public enum DRAction {
    NONE(0),
    DECODE_MASK(1),
    DECODE_ARRAY(2),
    DECODE_ARRAY_MASKS(3),
    GET_STRING(4);

    private int pVal = -1;
    DRAction(int val) { pVal = val; }
    public int getValue() { return pVal; }
}///:~
