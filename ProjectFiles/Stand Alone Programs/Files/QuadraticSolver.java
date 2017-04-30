/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

/**
 *2016
 * @author RyanT
 */

import java.text.DecimalFormat;
import java.util.*;

//problem 18 on page 144 in book, no single letter variables

public class QuadraticSolver {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);//sets scanner
        double firstVar, secVar, thirdVar, ansOne, ansTwo;//vars for input
        DecimalFormat df = new DecimalFormat("0.00");//limits decimals to two spots
        
        System.out.println("Hello welcome to Ryans Quadratic Equation solver!");//intro
        System.out.println("You will enter the three coefficients in order of A, B, and C.");//list whats needed
        System.out.println("These will be displayed in the form < A*x2 + B * x + C = 0 > for the variable x.");//format
        
        System.out.print("Please enter first value (A): ");//next three inputs for A,B,C
        firstVar = scan.nextDouble();

        System.out.print("Please enter second value (B): ");
        secVar = scan.nextDouble();        

        System.out.print("Please enter third value (C): ");
        thirdVar = scan.nextDouble();
        
        System.out.println("You have entered the equation " + firstVar + " *x2 + " + secVar + " * x + " + thirdVar + " = 0");//outputs in proper form
        
        //Parenthesis Exponent Multiplication Division Addition Subtraction
        
        ansOne = ((secVar + (Math.pow((Math.pow(secVar, 2)) - (4 * firstVar * thirdVar), .5))) / (2 * firstVar));
        ansTwo = ((-secVar + (Math.pow((Math.pow(secVar, 2)) - (4 * firstVar * thirdVar), .5))) / (2 * firstVar));

        
        System.out.println("X = " + df.format(ansOne));
        System.out.println("X = " + df.format(ansTwo));
        System.out.println("Thank you for using my program, have a great day!");
    }//end of class
}//end of program
