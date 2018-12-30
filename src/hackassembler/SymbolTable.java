/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import java.util.HashMap;

/**
 *
 * @author Andy
 */
public class SymbolTable {
    
HashMap<String, String> symbolMap = new HashMap<>();
HashMap<String, String> compMap = new HashMap<>();
HashMap<String, String> destMap = new HashMap<>();
HashMap<String, String> jumpMap = new HashMap<>();

public SymbolTable ()
{
        symbolMap.put("R0", "0"); 
        symbolMap.put("R1", "1"); 
        symbolMap.put("R2", "2");
        symbolMap.put("R3", "3"); 
        symbolMap.put("R4", "4"); 
        symbolMap.put("R5", "5");
        symbolMap.put("R6", "6"); 
        symbolMap.put("R7", "7"); 
        symbolMap.put("R8", "8");
        symbolMap.put("R9", "9"); 
        symbolMap.put("R10", "10"); 
        symbolMap.put("R11", "11"); 
        symbolMap.put("R12", "12"); 
        symbolMap.put("R13", "13");
        symbolMap.put("R14", "14"); 
        symbolMap.put("R15", "15"); 
        symbolMap.put("SCREEN", "16384");
        symbolMap.put("KBD", "24576");
        symbolMap.put("SP", "0");
        symbolMap.put("LCL", "1");
        symbolMap.put("ARG", "2");
        symbolMap.put("THIS", "3");
        symbolMap.put("THAT", "4");
        
        compMap.put("0", "0101010");
        compMap.put("1", "0111111");
        compMap.put("-1", "0111010");
        compMap.put("D", "0001100");
        compMap.put("A", "0110000");
        compMap.put("!D", "0001101");
        compMap.put("!A", "0110001");
        compMap.put("-D", "0001111");
        compMap.put("-A", "0110011");
        compMap.put("D+1", "0011111");
        compMap.put("A+1", "0110111");
        compMap.put("D-1", "0001110");
        compMap.put("A-1", "0110010");
        compMap.put("D+A", "0000010");
        compMap.put("D-A", "0010011");
        compMap.put("A-D", "0000111");
        compMap.put("D&A", "0000000");
        compMap.put("D|A", "0010101");
        compMap.put("M", "1110000");
        compMap.put("!M", "1110001");
        compMap.put("-M", "1110011");
        compMap.put("M+1", "1110111");
        compMap.put("M-1", "1110010");
        compMap.put("D+M", "1000010");
        compMap.put("D-M", "1010011");
        compMap.put("M-D", "1000111");
        compMap.put("D&M", "1000000");
        compMap.put("D|M", "1010101");
        
        destMap.put("null", "000");
        destMap.put("M", "001");
        destMap.put("D", "010");
        destMap.put("MD", "011");
        destMap.put("A", "100");
        destMap.put("AM", "101");
        destMap.put("AD", "110");
        destMap.put("AMD", "111");
        
        jumpMap.put("null", "000");
        jumpMap.put("JGT", "001");
        jumpMap.put("JEQ", "010");
        jumpMap.put("JGE", "011");
        jumpMap.put("JLT", "100");
        jumpMap.put("JNE", "101");
        jumpMap.put("JLE", "110");
        jumpMap.put("JMP", "111");
              
}

    public String getCompMapString (String inputString) {
        
        return compMap.get(inputString);
        
    }
    
       public String getDestMapString (String inputString) {
        
        return destMap.get(inputString);
        
    }
       
          public String getJumpMapString (String inputString) {
        
        return jumpMap.get(inputString);
        
    }
          
        public String getSymbolMapString (String inputString) {
        
        return symbolMap.get(inputString);
        
    }
        
          public void addSymbolMapString (String keyString, String valueString) {
        
        symbolMap.put(keyString,valueString); 
        
    }
}
