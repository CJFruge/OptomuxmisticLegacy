/*
 * Funx.java
 *
 * Created on May 2, 2007, 4:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package Utility;

import OptoMistic.*;
import OptoMistic.Enum.Constants;

public class Funx {
       
    public void decodeWord(String s,int[] dest,MisticCommand cmd) throws NumberFormatException {
        String num;
        clearArray(dest,0);
	int end = s.length();
	for ( int j=0; j<cmd.getDecodeLength(); j++ ) {
	    int width = cmd.getDecodeWidth(j);
	    int stS = end - width;
	    num = s.substring(stS,stS+width);
	    end = stS - 1;
	    try {
                if ( num.charAt(0) != '?' ) { 
                    dest[j] = Integer.parseInt(num,16); 
                }
            } catch (NumberFormatException e) { e.printStackTrace(); throw e; }
        }
    }   
    
    public void decodeMask(String s,int[] dest,int cksumWidth) throws NumberFormatException {
        long mask = 0;
        try {
            mask = Integer.parseInt(s.substring(1,s.length()-(cksumWidth+1)),16);
        } catch (NumberFormatException e) { e.printStackTrace(); throw e; }
        //mask &= ~generateBitMask(ioConfig);
        mask &= 0xffffffff;
        for ( int j=0; j<dest.length; j++ ) { dest[j] = (int)(mask & (1 << j)); }
    }

    public int getArrayDelimiter(int[] checkArray) {
        int rtn = 0;
        for ( int j : checkArray ) {
            if ( j == Constants.END_OF_ARRAY.getValue() ) { rtn = j-1; break; }
        }
        return rtn;
    }   
    
    public void clearArray(int[] intArray, int toValue) {
        for ( int j : intArray ) { j = toValue; }
    }

    public int generateBitMask(int[] intArray) {
        int mask = 0;
        for ( int j=0; j<intArray.length; j++ ) { 
            mask |= intArray[j] << j;
        }
        return mask & 0xffff;
    }
    
    public void copyArray(int[] src, int[] dst) {
        try {
            System.arraycopy(src,0,dst,0,dst.length > src.length ? src.length : dst.length);
        } catch (IndexOutOfBoundsException e) { e.printStackTrace(); }
    }
}
