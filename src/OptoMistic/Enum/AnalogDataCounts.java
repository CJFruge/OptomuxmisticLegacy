/*
 * AnalogDataCounts.java
 *
 * Created on May 4, 2007, 11:22 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package OptoMistic.Enum;

/**
 *
 * @author cjf
 */
public enum AnalogDataCounts {
    
    CURRENT_COUNTS(0x00),
    AVERAGE_COUNTS(0x01),
    PEAK_COUNTS(0x02),
    LOWEST_COUNTS(0x03),
    TOTALIZED_COUNTS(0x04);

    private int pVal = 0;
    AnalogDataCounts(int val) { pVal = val; } 
    public final int AnalogDataCounts() { return pVal; }  
}///:~
