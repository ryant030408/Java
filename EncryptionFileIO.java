/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */


package portfolio;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author ryant
 */
public class EncryptionFileIO {
    public static void main (String[]args)throws IOException{
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(System.getProperty("line.separator"));
        char[] inputs;
        
        
        System.out.println("Hello please enter a name for the file.");
        String inputFileName = scan.next();
        String realFileName = inputFileName + ".txt";
        File seEnc = new File(realFileName);
        if (seEnc.exists()){
            System.out.println("File found");
        }else{
            seEnc.createNewFile();
        }        
        
        FileOutputStream writeFileText = new FileOutputStream(seEnc);
        PrintWriter outtext = new PrintWriter(writeFileText);
        
        outtext.println("Hello, this is encryption!");
        outtext.flush();
        outtext.close();
        
        
        Scanner fromFile = new Scanner(seEnc);
        fromFile.useDelimiter(System.getProperty("line.separator"));        
        
        String words = fromFile.next();
        int length = words.length();
        inputs = new char[length];
        
        
        for (int i = 0; i < length; i++){
            inputs[i] = words.charAt(i);
        }
        
        char[] encrypted = RawEncript(inputs);
        
        File encryptedInfo = new File("outcript.txt");  
        if (encryptedInfo.exists()){
            System.out.println("File found");
        }else{
            encryptedInfo.createNewFile();
        }        
        FileOutputStream outstream2 = new FileOutputStream(encryptedInfo);//lets us send and recieve
        PrintWriter outtext2 = new PrintWriter(outstream2);//send in plain text not binary, binary is DataOutputStream   
        
        for(int i = 0; i < length; i++){
            outtext2.print(encrypted[i]);
            System.out.print(encrypted[i]);
        }
        System.out.println();
        outtext2.flush();
        outtext2.close();
        fromFile.close();
        
        System.out.println("Done");
        

    }

public static char[] RawEncript(char[] inp1){
    char[] ans = new char[inp1.length];
    
    for(int i = 0; i < inp1.length; i++){
        int chars = (int)inp1[i];
        if(chars < 65 || chars > 90 && chars < 97 || chars > 122){
            ans[i] = inp1[i];
        }else if(chars == 90){
            ans[i] = 'A';
        }else if(chars ==122){
            ans[i] = 'a';
        }else{
            ans[i] = (char)(chars + 1);
            
        }
    }
    return ans;    
}
}
