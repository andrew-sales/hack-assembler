/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

/**
 *
 * @author Andy
 */
public class Code {
    
    String forTranslation;
    String translated;
    int stringType; //0=a, 1=c //2=user defined symbol
    SymbolTable symbolTable;
    int newSymbolNumber;
    
    public Code ()
    {
        
        symbolTable = new  SymbolTable();
        newSymbolNumber=16;
        
    }
    
    public String translate (String inputString) {
        
        stringType = getStringType(inputString);
        
        switch (stringType) {
            case 0:
                translated = translateAType(inputString);          
                break;
            case 2:
                translated = translateUserDefinedType(inputString);
                break;
            default:
                translated = translateCType(inputString);
                break;
        }
        return translated;
    }
    
    
    public int getStringType (String inputString) {
        
       if  (inputString.matches("@\\d+")) {
            
            stringType = 0;
            return stringType;          
        }
       
       else if  (inputString.startsWith("@")) {
            
            stringType = 2;
            return stringType;          
        }
       
        else {
            stringType = 1;
            return stringType;       
        }
    }

public String translateAType (String inputString) {
    
    
    String tempString;
    tempString = inputString.replaceFirst("@", "");
    
    int decimalInt;
    decimalInt = Integer.parseInt(tempString);
    
    String binaryString;
    binaryString = Integer.toBinaryString(decimalInt);
   
    tempString = "0000000000000000" + binaryString;
   
    String returnString = tempString.substring(tempString.length()-16, tempString.length());

    return returnString;
}

public String translateUserDefinedType (String inputString) {
    
    String tempString;
    tempString = inputString.replaceFirst("@", "");
    
    String symbolString;
    
    symbolString = symbolTable.getSymbolMapString(tempString);

    int decimalInt;
    decimalInt = Integer.parseInt(symbolString);
    
    
    String binaryString;
    binaryString = Integer.toBinaryString(decimalInt);
   
    tempString = "0000000000000000" + binaryString;
   
    String returnString = tempString.substring(tempString.length()-16, tempString.length());
    
    return returnString;
    
}


public String translateCType (String inputString) {
    
   String dest;
   String comp;
   String jump;
   String tempString;
   
   String[] parts  = inputString.split("=");
   
      if (parts.length==1) {
       
          dest = "null";
          tempString = parts[0];
   }
   else {
          dest = parts[0];
          tempString = parts[1];
   }
   
  
   String[] parts2  = tempString.split(";");
   
   if (parts2.length==1) {
       
          comp = parts2[0];         
          jump = "null";
   }
   else {
          comp = parts2[0];
          jump = parts2[1];      
   }
   
    
    String returnString;
    
    returnString = "111" + symbolTable.getCompMapString(comp)+symbolTable.getDestMapString(dest) +
               symbolTable.getJumpMapString(jump);
      
    return returnString;
}


public void addMissingLabels (String labelString, int intValue) {
     
    if (symbolTable.getSymbolMapString(labelString)==null) {
        
        
            symbolTable.addSymbolMapString(labelString, Integer.toString(intValue));     
    }
    else
    {       
    }
}

public void addMissingSymbols (String labelString) {
    
    if (symbolTable.getSymbolMapString(labelString)==null) {
       
            symbolTable.addSymbolMapString(labelString, Integer.toString(newSymbolNumber));   
            
            newSymbolNumber++;
    
    }
    else
    {       
    }     
}
  
}
