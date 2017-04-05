/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */


/**
 *
 * @author ryant
 */

import java.util.*;

public class NumberGuessingGame {
    public static void main (String[]args){
        int randomNum, initialInput, guessHigher,guessLower, tryC, testC;//sets int for all numbers ingame
        randomNum= 0;
        guessLower = 10;
        guessHigher = 0;
        tryC = 0;
        testC = 1;
        String higherOrLower = "";
        boolean valid = true;
        
        Scanner scan = new Scanner(System.in);
        Random random = new Random();//gets random number
        randomNum = random.nextInt(11);//number random      
        
        System.out.println("Welcome to the guessing game. Please guess a number and see if you are correct.");
    while(valid){    
            initialInput = scan.nextInt();//gets input
            
        try{//try for bad answers
            if(initialInput > guessLower && tryC > 0){
                
                throw new Exception("That isnt lower, try again.");//checks against lower being lower

            }else if(initialInput < guessHigher && tryC > 0){

                throw new Exception("That isnt higher, try again");//checks agains higher actually being higher

            }else if(initialInput > 10){
             
                tryC = -1;
                throw new Exception("Thats more than 10, try again");//gets over ten

            }else if (initialInput < 1){
        
                tryC = -1;
                throw new Exception("Thats less that 1, try again");//gets less than 1
            }
            
            
            if(initialInput == randomNum){//checks for higher or lower
                System.out.println("You got it! Congratulations!! Number of tries : " + testC);
                valid = false;
            }else if(randomNum < initialInput){
                    higherOrLower = "lower";
                    guessLower = initialInput; 
            }else if(randomNum > initialInput){
                    higherOrLower = "higher";
                    guessHigher = initialInput;        
                }
            
            if (valid == false){//this doesnt print try again run if solved
                
            }else{    
                System.out.println("Sorry try again, but " + higherOrLower + " next time.");
                System.out.println("Enter a number between 1 and 10: ");
                //scan.next();
            }            
        }catch(InputMismatchException e){//sets exceptions
            System.out.println("I need an integer please try again.");
            scan.next();
            
        }catch(Exception e){//custom exceptions for throw
            System.out.println(e.getMessage());
        }
            testC++;//sets value for guesses
            tryC++;
        }//end of while
    }//end of class
}//end of program
