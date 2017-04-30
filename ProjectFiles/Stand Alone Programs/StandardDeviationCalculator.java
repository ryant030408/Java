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


public class StandardDeviationCalculator {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");        
        double[] list;
        int input;
        
        System.out.println("Welcome to the average and standard deviation calculator.");
        System.out.print("Please enter how many values you would like to use: ");
        
        input = scan.nextInt();
        list = new double[input];
        
        for(int i = 0; i < input; i++){
            System.out.println("Give me value number " + (i + 1) + ":");
            double listVal = scan.nextDouble();
            list[i] = listVal;
           
        }

        System.out.println("Your average is " + df.format(Averager(list)));
        System.out.println("Variance is " + df.format(Variancer(list)));
        System.out.println("Your standard deviation is " + df.format(Standardiva(list)));

    }//end of class
    public static double Averager(double[] input){
        int len = input.length;
        double ans = 0;
        
        for(int i = 0; i < len; i++){
            ans = ans + input[i];
            if (i == len-1){
                ans = ans / len;
            }
        }
        return ans;
    }
    public static double Variancer(double[] input){
        double average = Averager(input);
        int len = input.length;
        double var = 0;
        
        for(int i = 0; i < len; i++){
            var = var + Math.pow(input[i] - average, 2);
        }
        
        return var / len;
    }
    public static double Standardiva(double[] input){
        double ans = 0;
        ans = Math.sqrt(Variancer(input));
        return ans;
    }
}//end of program
