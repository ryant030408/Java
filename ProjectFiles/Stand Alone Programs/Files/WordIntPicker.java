/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

/**
 *2016
 * @author RyanT
 * This program takes a sentence and an int and gives the corresponding word
 */

import java.util.*;//for scanner


public class WordIntPicker {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);//sets scanner
        scan.useDelimiter(System.getProperty("line.separator"));//

        int input = 0;//sets variable for in input
        String sentence = "";//sets string value
        
while(!(sentence.equalsIgnoreCase("DONE"))){
        boolean valid = true;//sets boolean
        System.out.println("Hello, please enter a phrase and then you will be prompted for an integer.\nThis integer will tell you which word is referenced to the integer.\nEnter the word DONE to exit.");
        System.out.println("\nPlease enter your sentence : ");//asks for sentence
        sentence = scan.next();//gets input
        if(sentence.equalsIgnoreCase("DONE")){//if to set exit for loop
    System.out.println("Thank you for using my program, have a great day.");//end notice        
        }else{//else loop if not ending
        System.out.println("Please enter a positive integer to find which word corresponds: ");//asks for int
            while(valid){
                try{//tests for bad integers
                    input = scan.nextInt();
                
                    if(input == 0){
                        throw new Exception("No zeroes please, try again: ");                    
                    }else if(input < 0){
                        throw new Exception("No negatives, try again: ");
                    }
                  
                  valid = false;
                }catch(InputMismatchException e){
                    System.out.println("I need an integer, try again: ");
                    scan.next();                    
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }//end of catch                
            }//end of while        
        
        System.out.println("Your word is " + Finderoo(sentence, input) + ".\n");
            }//end of else
        }//end of while
    }//end of class
public static String Finderoo(String words1, int input1){
    String sentence = words1;//sets string
    String answer = "";//sets value
    int numberOf, index, count, beg, end, word;//gives ints
    word = input1;//sets word
    index = 0;
    count = 0;
    char BLANK = ' ';//gives us what we are looking for
    numberOf = sentence.length();
        while(index < numberOf){
            
            while(index < numberOf && sentence.charAt(index) == BLANK){//grabs blank space
                index++;  
            }
            while(index < numberOf && sentence.charAt(index) != BLANK){//gran=bs end
                index++;
            }
            count++;
            
        }
        if(count < word){
            word = count;//if int is bigger than amoutn of words
        }
        index = 0;
        count = 0;
        while(index < numberOf){
            
            while(index < numberOf && sentence.charAt(index) == BLANK){
                index++;
                
            }
            beg = index;
            while(index < numberOf && sentence.charAt(index) != BLANK){
                index++;
               
            }
            end = index;
            count++;
            if (count == word){
                answer = sentence.substring(beg, end);//
                
            }//end of if
            
        }//end of while
   
    return answer;//returns word
}
    
    
}//end of program
