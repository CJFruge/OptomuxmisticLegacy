/*
 * DigitalIOConfig.java
 *
 * Created on May 1, 2007, 6:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMistic.Enum;

public enum DigitalIOConfig {

    COUNTER(0x00),
    POSITIVE_PULSE_MEASURE(0x01),
    NEGATIVE_PULSE_MEASURE(0x02),
    PERIOD_PULSE_MEASURE(0x03),
    FREQUENCY_MEASURE(0x04),
    QUADRATURE_COUNTER(0x05),
    ON_TIME_TOTALIZER(0x06),
    OFF_TIME_TOTALIZER(0x07),
    STANDARD_OUTPUT(0x80);
    
    private int pVal = -1;
    DigitalIOConfig(int val) { pVal = val; }
    public int getValue() { return pVal; }
    
}///:~
