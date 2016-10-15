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

import java.util.*;//Scanner class input


public class PerfectDigitCube {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);//sets our scanner
        int inPut1, inPut2, noFind;//setting variables for our problem
        noFind = 0;//use this as a true false if any solutions were found
    do{//starting the do loop        
        
        System.out.println("Welcome to my program, please enter a number range starting from the lower number to the higher to find out if it its digits equal its self.\nEnter the number 0 for both fields to exit.\n");//intro
        System.out.print("Please enter the low digit: ");//asks for first digit
        inPut1 = scanner.nextInt();//gets input1
        System.out.print("Please enter the high digit: ");//asks for second digit
        inPut2 = scanner.nextInt();//gets inPut2
        System.out.println(" ");
        for (int i = inPut1; i <= inPut2; i++){//for loop, sets i to input and tics up every iteration until it is is greater than second input and exits
            int tally = 0;//sets tally back to zero for every iteration
            
            if(i == inPut2 && noFind == 0){//tells user that no solutions were found.
                System.out.println("There doesnt seem to be any perfect digit cube adders in your range. Please try again.\n");
        }
            
        

            for(int j = i; j > 0;){//sets j to i so we can manipulate then exits when j is 0, no need for thrid argument due to it being in the loop
                int mod = j % 10;//isolates last digit
                tally = tally + (int)Math.pow(mod, 3);//sends cube to tally and ads previous
                j = j / 10;//removes last digit and resets j to equal our new number
                if(j == 0){//checks if j is at zero, this means tally is finished
                    if(tally == i){// grabs tally and compares
                        System.out.println(i + "'s digits cubed equal each other.\n");//prints confirmation
                        noFind = 1;
                    }//end of inner if
                }//end of outer if                
    
            }//end of for 2
        }//end of for1



    }while(! (inPut1 == 0 && inPut2 == 0));//exits on 0s
        System.out.println("Thank you for using my program. Have a good day.");
    }//end of class
}//end of program
