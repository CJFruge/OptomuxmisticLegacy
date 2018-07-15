/*
 * CmdField.java
 *
 * Field Type Enumerator (value specifies field width)
 * 
 * Created on May 2, 2007, 7:11 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */


package OptoMistic;

import OptoMistic.Enum.Constants;

public class CmdField {

    private boolean[] pMask = new boolean[Constants.MAX_FIELDS.getValue()];
    private int[] pWidth = new int[Constants.MAX_FIELDS.getValue()];
    
    private void clearData() {
	int lim = Constants.MAX_FIELDS.getValue();
	for ( int j=0; j<lim; j++ ) { 
	    pMask[j] = false;
	    pWidth[j] = 0;
	}
    }

    public CmdField(boolean[] mask, int[] width) {
	clearData();
	int lim = 0;
	lim = Math.min(mask.length,width.length);
	lim = Math.min(lim,Constants.MAX_FIELDS.getValue());
	System.arraycopy(mask,0,pMask,0,lim);
	System.arraycopy(width,0,pWidth,0,lim);
    }
    
    public CmdField(boolean m0,int w0,boolean m1,int w1,boolean m2,int w2,boolean m3,int w3,boolean m4, int w4) {
	clearData();
	pMask[0] = m0;
	pWidth[0] = w0;
	pMask[1] = m1;
	pWidth[1] = w1;
	pMask[2] = m2;
	pWidth[2] = w2;
	pMask[3] = m3;
	pWidth[3] = w3;
	pMask[4] = m4;
	pWidth[4] = w4;
    }
    public CmdField(boolean m0,int w0,boolean m1,int w1,boolean m2,int w2,boolean m3,int w3) {
	clearData();
	pMask[0] = m0;
	pWidth[0] = w0;
	pMask[1] = m1;
	pWidth[1] = w1;
	pMask[2] = m2;
	pWidth[2] = w2;
	pMask[3] = m3;
	pWidth[3] = w3;
    }
    public CmdField(boolean m0,int w0,boolean m1,int w1,boolean m2,int w2) {
	clearData();
	pMask[0] = m0;
	pWidth[0] = w0;
	pMask[1] = m1;
	pWidth[1] = w1;
	pMask[2] = m2;
	pWidth[2] = w2;
    }
    public CmdField(boolean m0,int w0,boolean m1,int w1) {
	clearData();
	pMask[0] = m0;
	pWidth[0] = w0;
	pMask[1] = m1;
	pWidth[1] = w1;
    }
    public CmdField(boolean m0,int w0) {
	clearData();
	pMask[0] = m0;
	pWidth[0] = w0;
    }
    public CmdField() {
	clearData();
    }
    public final int getWidth(int f) { return pWidth[f %= Constants.MAX_FIELDS.getValue()]; }
    public final boolean getMask(int f) { return pMask[f %= Constants.MAX_FIELDS.getValue()]; }
    public final int getSize() { return Constants.MAX_FIELDS.getValue(); }
}///:~
