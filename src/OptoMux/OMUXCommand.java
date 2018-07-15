/*
 * OMUXCommand.java
 *
 * Created on April 28, 2007, 11:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author cjf
 */

package OptoMux;

import OptoMux.Enum.*;

public class OMUXCommand {
  
    char cmdChar;
    String posFormat;
    String modFormat;
    String dataFormat;
    int decodeWordWidth;
    IOAction ioAction;

    OMUXCommand
        (char newCmdChar, 
        String newPosFormat,
        String newModFormat,
        String newDataFormat,
        int newDecodeWordWidth,
        IOAction newIOAction) {

        cmdChar = newCmdChar;
        posFormat = new String(newPosFormat);
        modFormat = new String(newModFormat);
        dataFormat = new String(newDataFormat);
        decodeWordWidth = newDecodeWordWidth;
        ioAction = newIOAction;
    }
}///:~

