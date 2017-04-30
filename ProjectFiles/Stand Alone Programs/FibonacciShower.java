/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

/**
 *2016
 * @author RyanT
 * This program takes an integer and displays that many fibonacci numbers
 */

import java.util.*;


public class FibonacciShower {
    public static void main (String [] args){
        
        Scanner scan = new Scanner(System.in);//scanner in
        double input;//sets input double for math
        int counter = 0;//counts for loop
        
        System.out.print("Please enter the amount of Fibonacci numbers you would like to see: ");//asks for input
        input = scan.nextDouble();//take input int
 
        while(counter < input){//while loop
            
            System.out.println(counter + " - " + (int)Fibo(counter));//casts double as int
            counter++;

        }//end of while
        
        System.out.println("Thank you for using my program. Have a good day.");//end notice
    }//end of class
    public static double Fibo(double in){//static for class
        double answer;//sets answer as a double
        
        answer = (1 / Math.sqrt(5)) * (Math.pow((1 + Math.sqrt(5)) / 2, in) - Math.pow((1 - Math.sqrt(5)) / 2, in));
        
        return answer;//send back answer
    }//end of fibo
}//end of program
