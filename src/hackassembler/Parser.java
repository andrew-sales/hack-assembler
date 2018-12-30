/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Andy
 */
public class Parser {
    
    String fileName;
    List<String> list;
    Code code;
    
    public Parser (String fileName) {
        
     this.fileName = fileName;
     code = new Code();
       
    }
    
    public void openFile () throws FileNotFoundException {
        
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        
        list = new ArrayList<>();

        while (input.hasNextLine()) {
        list.add(input.nextLine());
}    
        
    }
    
    public void removeWhiteSpace () {
        
        for (int j = list.size()-1; j >= 0; j--) 
        {
    
            if (list.get(j).equals(""))
            {
                list.remove(j);
            }
            else {
                
                String newString = list.get(j).trim();
                list.remove(j);
                list.add(j, newString);
            }
            
    }
}
       
    public void removeComments () {
        
            for (int j = list.size()-1; j >= 0; j--) 
        {
    
            if (list.get(j).startsWith("//"))
            {
                list.remove(j);
            } 
            
            else if (list.get(j).contains("//")) {
                
                int spaceIndex = (list.get(j).indexOf("/"));

                String text = list.get(j).substring(0, spaceIndex);
                list.remove(j);
                list.add(j, text);
                
            }
            
                       
            else {
            }
        }
    }
    
  
    
    public void removeLabels () {
        
             for (int j = 0; j < list.size()-1; j++) 
        {
            if (list.get(j).startsWith("("))
            {
                        
                String s=list.get(j);
                String requiredString = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
                         
                code.addMissingLabels(requiredString, j);
 
                list.remove(j);
                j = 0;        
                
            } else {
            }
        }
        
    }
    
public void replaceSymbols () {

     for (int j = 0; j < list.size()-1; j++) 
        {
    
            if (list.get(j).startsWith("@"))
            {
                                                       
               if (code.getStringType(list.get(j))==2) {
                String requiredString=list.get(j).substring(1, list.get(j).length());  
                code.addMissingSymbols(requiredString);
                
               }              
            } 
            
            else {
            }
        }                
}
    
    
    public int getFileLength () {
        
        return list.size();
    }
    
    
    public List<String> getArrayList (){
        
        return list;
    }
    
    public void writeOutput (List <String> lineOutput) throws FileNotFoundException, IOException {
        
       File outputFile = new File("U://Andrew//Personal Develpment//Coursera//nand2tetris//projects//06//max//max.hack");
       FileOutputStream fos = new FileOutputStream(outputFile);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos)); 
        
        
        for (String s: lineOutput) {
            
            String writeString = code.translate(s);         
            bw.write(writeString);
            bw.newLine();
            
        }  
        bw.close();      
    }
   
}