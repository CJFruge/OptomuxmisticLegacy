/*
 * OMUXProtocol.java
 *
 * Created on April 29, 2007, 12:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux.Enum;

public enum OMUXProtocol { 
    PASS_2(0),
    PASS_4(1);

    private int pVal = -1;
    OMUXProtocol(int val) { pVal = val; }
    public int getValue() { return pVal; }
}///:~
