/*
 * AnalogDataSRootUnits.java
 *
 * Created on May 4, 2007, 11:30 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package OptoMistic.Enum;

/**
 *
 * @author cjf
 */
public enum AnalogDataSRootUnits {

CURRENT_UNITS(0x10),
AVERAGE_UNITS(0x11),
PEAK_UNITS(0x12),
LOWEST_UNITS(0x13),
TOTALIZED_UNITS(0x14),
SQ_ROOT_CURRENT_COUNTS(0x20),
SQ_ROOT_AVERAGE_COUNTS(0x21),
SQ_ROOT_PEAK_COUNTS(0x22),
SQ_ROOT_LOWEST_COUNTS(0x23),
SQ_ROOT_TOTALIZED_COUNTS(0x24),
SQ_ROOT_CURRENT_UNITS(0x30),
SQ_ROOT_AVERAGE_UNITS(0x31),
SQ_ROOT_PEAK_UNITS(0x32),
SQ_ROOT_LOWEST_UNITS(0x33),
SQ_ROOT_TOTALIZED_UNITS(0x34);
 
    private int pVal = 0;
    AnalogDataSRootUnits(int val) { pVal = val; }
    public final int getValue() { return pVal; }    
}///:~
