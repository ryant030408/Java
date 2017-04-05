import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
/**
 *
 * @author RyanT
 * Feb 2016
 */
public class InterestCalc {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);//set scanner
        double dollars, percent, years, answer, divi, diviP, diviPM;//set variables
        DecimalFormat df = new DecimalFormat("0.00");//limits decimals to two spots
        
        System.out.println("Hello, welcome to my program, today we are going to calculate interest!");//intro
        
        System.out.print("Please enter the amount you would like to invest:");
        dollars = scanner.nextDouble();//input for dollar needed to invest
        
        System.out.print("Thank you, please enter amount of percent:");
        percent = scanner.nextDouble();//input for percent
        
        System.out.print("Thank you, now please let me know how many years:");
        years = scanner.nextDouble();//how many years
        
        divi = percent/100;//do three things
        diviP = divi + 1;
        diviPM = Math.pow(diviP, years);
        System.out.println("The amount of principle after interest is $" + df.format(dollars * diviPM) + ".");//final math
        
        
        
        
        
                
        
        
        
    }//end of class
}//end of program
