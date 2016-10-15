/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */
package portfolio;

/**
 * 2016
 *
 * @author RyanT
 */
import java.util.*;

class PasswordGen {

    int maxLength;
    int minLength;
    Random random;
    char[] password;
    boolean upperCase;
    boolean lowerCase;
    boolean numberIn;
    boolean specialIn;

    public PasswordGen(int max, int min, boolean upper, boolean lower, boolean number, boolean special) {
        maxLength = max;
        minLength = min;
        upperCase = upper;
        lowerCase = lower;
        numberIn = number;
        specialIn = special;
    }

    public PasswordGen(int max, int min, boolean upper, boolean lower, boolean number) {
        maxLength = max;
        minLength = min;
        upperCase = upper;
        lowerCase = lower;
        numberIn = number;
    }

    public PasswordGen(int max, int min, boolean upper, boolean number) {
        maxLength = max;
        minLength = min;
        upperCase = upper;
        numberIn = number;
    }

    public void setMaxLength(int max) {

    }

    public void setMinLength(int min) {

    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public boolean getUpper() {
        return upperCase;
    }

    public boolean getLower() {
        return lowerCase;
    }

    public boolean getNumber() {
        return numberIn;
    }

    public boolean getSpecial() {
        return specialIn;
    }

    public String Generate() {
        String password = "";
        Random random = new Random();
        int length = random.nextInt(this.getMaxLength() - this.getMinLength()) + this.getMinLength();
        char[] list = this.RandomArrayList();

        for (int i = 0; i < length; i++) {
            int charAdd = random.nextInt(list.length);
            password = password + list[charAdd];
        }

        return password;
    }

    public char[] RandomArrayList() {

        int total = 0;
        boolean up = false;
        boolean low = false;
        boolean numb = false;
        boolean spec = false;

        if (this.getUpper()) {
            total = total + 26;
            up = true;
        }
        if (this.getLower()) {
            total = total + 26;
            low = true;
        }
        if (this.getNumber()) {
            total = total + 10;
            numb = true;
        }
        if (this.getSpecial()) {
            total = total + 15;
            spec = true;
        }

        char[] ans = new char[total];
        ans = LetterSetter(total, up, low, numb, spec);

        return ans;
    }

    public char[] LetterSetter(int length, boolean up, boolean low, boolean numb, boolean spec) {
        char[] ans = new char[length];
        int arrayTrack = 0;
        int charTrack = 0;
        int end = 0;

        if (up) {
            charTrack = 65;
            end = arrayTrack + 26;
            for (arrayTrack = arrayTrack; arrayTrack < end; arrayTrack++) {
                ans[arrayTrack] = (char) charTrack;
                charTrack++;
            }
        }
        if (low) {
            charTrack = 97;
            end = arrayTrack + 26;
            for (arrayTrack = arrayTrack; arrayTrack < end; arrayTrack++) {
                ans[arrayTrack] = (char) charTrack;
                charTrack++;
            }

        }
        if (numb) {
            charTrack = 48;
            end = arrayTrack + 10;
            for (arrayTrack = arrayTrack; arrayTrack < end; arrayTrack++) {
                ans[arrayTrack] = (char) charTrack;
                charTrack++;
            }

        }
        if (spec) {
            charTrack = 33;
            end = arrayTrack + 15;
            for (arrayTrack = arrayTrack; arrayTrack < end; arrayTrack++) {
                ans[arrayTrack] = (char) charTrack;
                charTrack++;
            }

        }
        return ans;
    }

}

public class PasswordMaker {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean lowC, upC, numbs, specs;
        System.out.println("////////Password Generator///////////");
        System.out.print("Max size of password: ");
        int max = scan.nextInt();
        System.out.print("Min size of password: ");
        int min = scan.nextInt();
        System.out.print("Upper case, Y or N: ");
        String up = scan.next();
        if (up.equalsIgnoreCase("Y")) {
            upC = true;
        } else {
            upC = false;
        }

        System.out.print("Lower case, Y or N: ");
        String low = scan.next();
        if (low.equalsIgnoreCase("Y")) {
            lowC = true;
        } else {
            lowC = false;
        }

        System.out.print("Numbers, Y or N: ");
        String numb = scan.next();
        if (numb.equalsIgnoreCase("Y")) {
            numbs = true;
        } else {
            numbs = false;
        }

        System.out.print("Special Chars, Y or N: ");
        String spec = scan.next();
        if (spec.equalsIgnoreCase("Y")) {
            specs = true;
        } else {
            specs = false;
        }

        PasswordGen result = new PasswordGen(max, min, upC, lowC, numbs, specs);

        System.out.println("Password: " + result.Generate());
    }//end of class
}//end of program
