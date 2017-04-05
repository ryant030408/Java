import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *2016
 * @author RyanT
 */
public class PlanetaryVelocityCalc {
    public static void main(String[]args){
        
        Scanner scanner = new Scanner(System.in);//set scanner
        DecimalFormat df = new DecimalFormat("0.00");//limits decimals to two spots
        double radius, velocity, mult,radsDiv,expo;//identifies doubles for program
        
        final double mE, uniConst;
        
        mE = 5.98 * Math.pow(10, 24);
        uniConst = 6.67 * Math.pow(10, -11);
        
        System.out.println("Hello, welcome to my program, today we are going to calculate velocity!");//intro
        
        System.out.print("Please enter the radius from the center of The Earth to the satellite in meters: ");
        radius = scanner.nextDouble();//input for radius
        
        mult = uniConst * mE;
        //System.out.println(mult);
        
        radsDiv = mult / radius;
        //System.out.println(radsDiv);
        
        expo = Math.pow(radsDiv, .5);
        //System.out.println(expo);
        
        velocity = Math.pow(mult / radius, .5);
        
        System.out.println("Your velocity is " + df.format(velocity) + " m/s.");
        System.out.println("Thank you for using my program.");

    }//end of class

}//end of program
