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


public class PrimeToShower {
    public static void main (String [] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int primOne, primFin, mod, div;//sets ints
        
        primFin = 0;//initializes primOne
        
        System.out.println("Welcome to my prime calculator");//intro
        System.out.println("Please enter the amount of primes you would like to know about between 2 and your chosen number.");
        System.out.println("Up to what number of primes would you like, enter it now: ");
        primOne = scanner.nextInt();
        
        for (int i = primOne; i > 1; i--){//sets i to primOne, and then exits if i isnt greater than one, i ticks down 1 on every loop
            
            
            for (int j = i; j >= 1; j--){//sets j to i to use number in loop and manipulate and exits when j is zero
            
                mod = i % j;
                div = i / j;
                if (j == 1){
                    primFin = primFin + 1;
                    System.out.println(i);
                }//end of if
                else if (mod == 0 && div > 1){
                j = 1;
                }//end of elseif
            }//end of inner for
        }//end of outer for
        
        
        System.out.println("There are " + primFin + " primes between 2 and " + primOne + ".");//displays results
        

    }//end of class
}//end of program
