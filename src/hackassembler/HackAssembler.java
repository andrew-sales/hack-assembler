/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Andy
 */
public class HackAssembler {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        
        
        Parser parser;
        parser = new Parser ("U:/Andrew/Personal Develpment/Coursera/nand2tetris/projects/06/max/max.asm");
        
        parser.openFile();

        parser.removeComments();
       
        parser.removeWhiteSpace();

        parser.removeLabels();
        
        parser.replaceSymbols();
        
        parser.writeOutput(parser.getArrayList());

    }
    
}
