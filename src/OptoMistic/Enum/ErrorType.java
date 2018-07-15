/*
 * ErrorType.java
 *
 * Created on May 2, 2007, 6:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMistic.Enum;
import java.util.*;
public enum ErrorType {
    
    UNDEFINED_COMMAND(0x01,"UNDEFINED"),
    CKSUM_CRC(0x02,"CHECKSUM CRC ERROR"),
    BUFFER_OVERRUN(0x03,"BUFFER OVERRUN"),
    POWER_UP_CLEAR(0x04,"POWER UP CLEAR"),
    DATA_FIELD(0x05,"DATA FIELD ERROR"),
    WATCHDOG_TIMEOUT(0x06,"WATCHDOG TIMEOUT"),
    DATA_INVALID(0x07,"DATA VALUE ERROR"),
    BUSY(0x08,"BUSY ERROR"),
    INVALID_MODULE_TYPE(0x09,"INVALID MODULE TYPE"),
    INVALID_EVENT(0x10,"INVALID EVENT"),
    HIGH_RES_DELAY_LIMIT(0x11,"HIGH RESOLUTION DELAY LIMIT");
    
    private int pVal = -1;
    private String pString;
    ErrorType(int val, String string) { 
	pVal = val; 
	pString = new String(string);
    }
    public final int getValue() { return pVal; }
    public final String getErrorString() { return pString; }
}///:~
