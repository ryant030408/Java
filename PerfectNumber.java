/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

package portfolio;

/**
 *2016
 * @author RyanT
 */

import java.util.*;


public class PerfectNumber {
    public static void main (String [] args){
        
        Scanner scanner = new Scanner(System.in);//sets our scanner
        int inPut, mod, tally;//setting variables for our problem

    do{//starting the do loop        
        
        System.out.print("Welcome to my program, please enter a number to find out if it is a perfect number, or all divisors besides itself equal the original number.\nEnter the number 0 to exit: ");//intro
        inPut = scanner.nextInt();//gets input
        tally = 0;//sets tally inside loop
        for (int i = inPut - 1; i >= 1; i--){//sets i equal to inPut the takes away each run until hits 0
            
            mod = inPut % i;//math to get remainder
            
            if (mod == 0){//if value is a divisor sends to to tally and adds previous
                tally = tally + i;//adds all real divisors and adds them together for input
                System.out.println(i);//prints divisor
            }//end of if
        }//end of for

        if(inPut == 0){//exit note
            System.out.println("Thank you for using my program.");
            
        }else if(tally == inPut){//gives yes answer, uses tally calculated earlier
            System.out.println("All divisors added together equals " + inPut + ".");
            System.out.println("This is a perfect divisor");     
            
        }else{//gives no answer
            System.out.println("Total of divisors added is " + tally + ". This is not a perfect divisor.");
        }//end of if list
        

        }while(inPut != 0);//exits on 0
    }//end of class
}//end of program
