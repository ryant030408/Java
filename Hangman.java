package portfolio;

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

public class Hangman {
    public static void main (String[]args){
        String phrase;//sets phrase for later
        int tries;//sets int for amount of guesses
        StringBuilder nPhrase;//sets string builder to edit later
        boolean hit = false;//gives us tracker for hits
        
        Scanner scan = new Scanner(System.in);//scan in
        scan.useDelimiter(System.getProperty("line.separator"));//sets spaces to not end input
        
        System.out.println("Hello, Welcome to Hangman. Please enter a secret phrase when promted and then enter how mny tries the other player should have");
        System.out.print("Please enter your secret phrase:");
        phrase = scan.next();//grabs phrase
        
        nPhrase = Converterizer(phrase);//converts to string builder with dashes
        
        System.out.println("Please enter how many tries are allowed.");
        tries = scan.nextInt();//gets amount of tries
        
        for(int i = 0; i < tries; i++){//outer for loop keeps track of tries
            String inP = new String();
            System.out.println(nPhrase);//prints phrase
            System.out.println("You have " + (tries-i) + " tries left, please enter a letter for a guess:");
            inP = scan.next();//gets guess
            
            for(int j = 0; j < nPhrase.length(); j++){

                if(inP.substring(0,1).equals(phrase.substring(j, j+1).toLowerCase()) || inP.substring(0,1).equals(phrase.substring(j, j+1).toUpperCase())){//checks if input matches any letters
                    nPhrase.setCharAt(j, phrase.charAt(j));
                    hit = true;
                }else{
                }
                
            
            }
            if(nPhrase.toString().equals(phrase)){//checks whole phrase against original
                System.out.println("You win! Congratulations!");
                System.out.println("The phrase is " + phrase);
                i = tries + 1;//gets out of loop
            }else if(hit){//hit with a letetr            
                System.out.println("Congratulations you got it!");                
                i--;//sets i back so tries dont increase
                
            }else if(i == tries-1){
                System.out.println("Sorry you lose.");
            }else{//answer for no match
                System.out.println("Sorry no match.");
                    }
                hit = false;//resets hit tracker            
            
        }//end of outer for
        System.out.println("Thank you for playing!");


}//end of class
    
private static StringBuilder Converterizer(String input){//created to turn input into dashes
    StringBuilder ans = new StringBuilder(input); 
    int len = input.length();
    
    for (int i = 0; i < len; i++){
        if(isLetter(input.charAt(i))){
            ans.setCharAt(i, '-');
        }else{
            ans.setCharAt(i, input.charAt(i));
        }

    }
    
    
    return ans;
    }//end of class to turn into dashes
private static boolean isLetter(char input){//created to check if letter
    boolean valid = false;
    char test = input;
    
    if(test >= 'A' && test <= 'z'){//uses accii table for letter values.
        valid = true;
    }    
    return valid;
    }//end of class

}//end of program
