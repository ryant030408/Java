/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

/**
 *2016
 * @author RyanT
 */

import java.util.*;


public class CaseReverser {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);//bring input
        scan.useDelimiter(System.getProperty("line.separator"));//ignores spaces        
        String testIn;//value for test
        boolean valid = true;
        do{
        System.out.println("Enter a sentence to have the case reversed, or type 0 to exit:");//asks
        testIn = scan.next();//
        if (testIn.charAt(0) == '0'){
            valid = false;
            
        }else
        System.out.println("Your new sentence is:\n" + CaseRev(testIn));
        
        
        
        }while(valid);
        
    }//end of class
    
    public static StringBuilder CaseRev(String input){
        StringBuilder testCase = new StringBuilder(input);
        int len = input.length();
        
        for (int i = 0; i < len; i++){
            
            
            if(input.substring(i, i+1).equals(input.substring(i, i+1).toUpperCase())){
                String changer = input.substring(i, i+1).toLowerCase();
                char low = changer.charAt(0);
                testCase.setCharAt(i,low);
                
            }else if (input.substring(i, i+1).equals(input.substring(i, i+1).toLowerCase())){
                String changer = input.substring(i, i+1).toUpperCase();          
                char high = changer.charAt(0);
                testCase.setCharAt(i,high);                
            }//end of else        
        }//end of for
    return testCase;
    }//end of problem class
        
        
}//end of program
