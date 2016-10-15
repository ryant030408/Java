/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

package portfolio;

/**
 *2016
 * @author RyanT
 * Cash Register
 */

import java.text.DecimalFormat;
import java.util.*;


public class CashRegisterBasic {
    public static void main (String [] args){
        
        double purch, tend, change;//set variables for all needed parts of program
        int dollars, quart, nick, dime, pen;
        DecimalFormat df = new DecimalFormat("$0.00");//limits decimals to two spots
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hello welcome to my cash register.");//intro
        System.out.println("You will enter purchase price and then enter amount tendered.");
        
        System.out.print("Please enter purchase price:");//ask for and take double for purchase price
        purch = scanner.nextDouble();
        
        System.out.print("Please enter purchase amount tendered:");//enter amount tendered
        tend = scanner.nextDouble();
        
        System.out.println("Thank you.");//thanking
        
        //Math section Below
        change = tend - purch;// does math for purchase
                
       
        
        System.out.println("Your change is: " + df.format(change));//gives change
        
        change = change * 100;//converts answer to easy to use int
        
        dollars = (int)change / 100;//dollar change
        quart = ((int)change % 100) / 25;//quarter change
        dime = (((int)change % 100) % 25) / 10;//dime change
        nick = ((((int)change % 100) % 25) % 10) / 5;//nickel change
        pen = (((((int)change % 100) % 25) % 10) % 5) / 1;//pennies
        
        
        //gives output of amount of change per denomination
        System.out.println(dollars + " Dollar(s)");
        System.out.println(quart + (" Quarter(s)"));
        System.out.println(dime + " Dime(s)");
        System.out.println(nick + (" Nickel(s)"));
        System.out.println(pen + (" Penny(ies)"));
        
        System.out.println("Thank you for using my program have great day.");
    }//end of class
}//end of program
