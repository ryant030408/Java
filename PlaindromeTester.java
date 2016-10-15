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


public class PlaindromeTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        String S = "He is a very very good boy, isn't he?";
        String[] lists = new String[S.length()];
        String ans = "";
        for(int i = 0; i < S.length(); i++){

            for(int j = 0; j != -1; j++){
                if(Character.isLetter(S.charAt(j))){
                    ans = ans + S.charAt(j);
                    System.out.println(ans);
                }else{
                    System.out.println(ans + " " + j + i);
                    j = -1;
                }
            }
            lists[i] = ans;
            ans = "";
        }
    for(int h = 0; h < lists.length; h++){    
    System.out.println(lists[h]); 
    }
    }
        
    }//end of program
