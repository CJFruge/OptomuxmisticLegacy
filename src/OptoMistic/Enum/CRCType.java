/*
 * CRCType.java
 *
 * Created on May 1, 2007, 8:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package OptoMistic.Enum;

/**
 *
 * @author cjf
 */
public enum CRCType {
    CRC_16(0,4),
    CRC_16R(1,4),
    CRC_CCITT(2,4),
    CRC_CCITTR(3,4),
    CKSUM_8(4,2);

    private int pVal;
    private int pWidth;
    CRCType (int newVal, int newWidth) { pVal = newVal; pWidth = newWidth; }
    public final int getValue() { return pVal; }
    public final int getWidth() { return pWidth; }
}///:~
