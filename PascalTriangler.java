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

import java.util.*;


public class PascalTriangler {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);//scanner
        int input;//value for rows
        String gap =  "";//gap for triangle
        
        System.out.println("How many rows of the triangle would you like for the Pascal Triangle:");//question
        input = scan.nextInt();//input accepted
        
        int[][] arr = new int [input][];   //sets array
        
        int gapper = input;//sets value to calculate gap
        
        for(int i = 0; i < input; i++){
            
            arr[i] = new int[i + 1];
            
            for(int g = gapper; g > 0; g-- ){
                gap = gap + " ";
                
            }
            System.out.print(gap);            
            gapper = gapper - 1;
            for(int j = 0; j <= i; j++){
                
                if(j == 0 || j == arr[i].length-1){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = (arr[i-1][j-1]) + (arr[i-1][j]);
                }

                if(j <= i){
                        System.out.print(arr[i][j] + " ");  
                        //System.out.println("Check 4");
                    
                }
            }
            System.out.println();
            gap = "";
    }
        System.out.println("Thanks for using my program.");

    }//end of class
}//end of program
