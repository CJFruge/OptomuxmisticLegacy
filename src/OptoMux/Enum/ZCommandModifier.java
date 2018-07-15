/*
 * ZCommandModifier.java
 *
 * Created on April 29, 2007, 12:56 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux.Enum;

public enum ZCommandModifier {
    
    ON_PULSE('H'),
    OFF_PULSE('J'),
    ON_DELAY('I'),
    OFF_DELAY('K'),
    INITIATE_SQUARE_WAVE('L'),
    TURN_OFF_DELAY_SQUARE_WAVE('G');

    private char pVal = '\u0000';
    ZCommandModifier(char val) { pVal = val; }
    public char getValue() { return pVal; }

}///:~
