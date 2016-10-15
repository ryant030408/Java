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

import java.text.DecimalFormat;
import java.util.*;
/*ANY CHANGES NEEDED TO PRICE OR BOX INFOR SEE VARIABLES SET AT BEGGINING OF PROGRAM.
What can be changed
-Coffee price or <cost>
-Box cost or <lar,med,sma>
-Box size or <larB, medB, smaB>
*/

public class CoffeeShopv1 {
    public static void main (String [] args){
        
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("$0.00");//lets us use dollars
        
        double lar, med, sma, cost, smaB, larC, medC, smaC, preShipCof;//doubles for cost with decimal
        int bagIn, larB, medB, sizeL, sizeM, sizeS;//int for bag values because they cannot be split
        
        cost = 5.50;//cost of coffee
        lar = 1.80;//large box cost
        med = 1.00;//med box cost
        sma = .60;//small box cost
        
        sizeL = 20;//coffee bags per box for future changes 
        sizeM = 10;
        sizeS = 5;
                

        
        System.out.println("Welcome to MyJava Coffee Outlet, where we only sell the finest coffee beans harvested exclusively in remote areas of Irian Jaya.");//Intro
        System.out.println("Each bag of coffee costs " + df.format(cost) + " plus shipping.");//Price in header
        System.out.print("How many bags would you like? Please enter amount now: ");//Ask for input
        bagIn = scanner.nextInt();//takes input and stores as bagIn
        
        preShipCof = bagIn * cost;//calculates coffee pre ship for future use
        
        System.out.println("Number of bags ordered: " + bagIn + " - " + df.format(preShipCof) + ".");//prints bags ordered
        
        larB = bagIn / sizeL;//large cost
        medB = (bagIn % sizeL) / sizeM;//med cost
        smaB = ((bagIn % sizeL)% sizeM) / 1;//small cost, used ifelseif to get desired result
        
        if(smaB > sizeS){
            smaB = 2;
        
        }else if(smaB == 0){//runs through 0 before <= 5 so zero is irradicated as an answer
            smaB = 0;
        }else if(smaB <= sizeS){
            smaB = 1;
        }

        

        //box math for shipping cost
        larC = larB * lar;
        medC = medB * med;
        smaC = (int)smaB * sma;
        
        
        System.out.println("Boxes used:");//Display cost of boxes used
        System.out.println(larB + " Large  - " + df.format(larC));
        System.out.println(medB + " Medium  - " + df.format(medC));
        System.out.println((int)smaB + " Small  - " + df.format(smaC));
        
        System.out.println("Thank you for ordering, your total today is " + df.format(preShipCof + larC + medC + smaC) + ".");// displays total
        
                
                

    }//end of class
}//end of program
