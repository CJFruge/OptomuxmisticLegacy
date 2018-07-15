/*
 * OutputWaveform.java
 *
 * Created on April 29, 2007, 7:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux.Enum;

public enum OutputWaveform {
    
    DISABLE(0),
    MIN_2_18(1),
    MIN_3_28(2),
    MIN_4_37(3),
    MIN_5_46(4),
    MIN_6_56(5),
    MIN_7_65(6),
    MIN_8_74(7),
    MIN_1_09(8),
    SEC_32_8(9),
    SEC_21_8(10),
    SEC_16_4(11),
    SEC_13_1(12),
    SEC_10_9(13),
    SEC_9_4(14),
    SEC_8_2(15); 

    private int pVal = -1;
    OutputWaveform(int val) { pVal = val; }
    public int getValue() { return pVal; }
     
}///:~
