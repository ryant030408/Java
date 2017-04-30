/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

/**
 *2016
 * @author RyanT
 */

import java.util.*;
import java.io.*;


public class FileIONumberAverages {
    public static void main (String args[]) throws IOException{
        Scanner scan = new Scanner(System.in);
        Random random = new Random();//gets random number
        int randomNum;
        int counter = 0;
        int[] digits;
        
        System.out.println("Hello please enter a filename for our ints: ");
        String inFileName = scan.next();
        
        String intFile = inFileName + ".txt";
        

        File intStore = new File(intFile); 
        
        int len = inFileName.length();
        
        //digits = new int[len + 1];
        
        if (intStore.exists()){
            System.out.println("File found");
        }else{
            intStore.createNewFile();
        }
        
        FileOutputStream outstream = new FileOutputStream(intStore);//lets us send and recieve
        PrintWriter outtext = new PrintWriter(outstream);//send in plain text not binary, binary is DataOutputStream
        
        for( int i = 0; i < (len * Calendar.getInstance().get(Calendar.SECOND)); i++){
            randomNum = random.nextInt(999);          
            outtext.print(randomNum + " ");
        }
        outtext.flush();
        outstream.close();        
        
        System.out.println("Now please enter a file name for the results: ");
        String outFileName = scan.next();
        
        File outStore = new File(outFileName + ".txt");        
        
        if (outStore.exists()){
            System.out.println("File found");
        }else{
            outStore.createNewFile();
        }        
        
        FileOutputStream outstream2 = new FileOutputStream(outStore);//lets us send and recieve
        FileInputStream instream1 = new FileInputStream(intStore);
        PrintWriter outtext2 = new PrintWriter(outstream2);//send in plain text not binary, binary is DataOutputStream        
       
        Scanner fromFile = new Scanner(intStore);

        
        
        do{
            System.out.print(fromFile.nextInt());            
                counter++;
                //fromFile.next();
                System.out.println(" " + counter);
         }while(fromFile.hasNextInt());//end of while
        fromFile.close();           
        
            digits = new int [counter];

        Scanner fromFile2 = new Scanner(intStore);  
        
        for (int k = 0; k < counter; k++){
            digits[k] = fromFile2.nextInt();
            System.out.println(digits[k]);

        }//end of for
        fromFile2.close();
     

        
        System.out.println("Read from file: " + counter + " values");
            outtext2.println("Read from file: " + counter + " values");        
        System.out.println("Maximum value " + Maximizer(digits));
            outtext2.println("Maximum value " + Maximizer(digits));
        System.out.println("Minimum value " + Minimizer(digits));
            outtext2.println("Minimum value " + Minimizer(digits));
        System.out.println("Average value " + Averager(digits));  
            outtext2.println("Average value " + Averager(digits));
        System.out.println("Standard deviation value " + Standardiva(digits));    
            outtext2.println("Standard deviation value " + Standardiva(digits));
            
        outtext2.flush();
        outtext2.close();
        
       
    }//end of class

    private static double Averager(int[] input){
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
    private static double Variancer(int[] input){
        double average = Averager(input);
        int len = input.length;
        double var = 0;
        
        for(int i = 0; i < len; i++){
            var = var + Math.pow(input[i] - average, 2);
        }
        
        return var / len;
    }
    private static double Standardiva(int[] input){
        double ans = 0;
        ans = Math.sqrt(Variancer(input));
        return ans;
    }    
    private static double Minimizer(int[] input){
        int lowest = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] <= lowest){
                lowest = input[i];
            }
        }
            return lowest;        
    }
    private static double Maximizer(int[] input){
        int biggest = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] >= biggest){
                biggest = input[i];
            }
        }
            return biggest;        
    }    
}//end of program
