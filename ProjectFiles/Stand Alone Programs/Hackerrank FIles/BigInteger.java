/**
 * Created by RyanT on 10/31/16.
 * In this problem, you have to add and multiply huge numbers!
 * These numbers are so big that you can't contain them in any ordinary data types like a long integer.

 Use the power of Java's BigInteger class and solve this problem.

 Input Format

 There will be two lines containing two numbers,  and .

 Constraints

 and  are non-negative integers and can have maximum  digits.

 Output Format

 Output two lines. The first line should contain , and the second line should contain . Don't print any leading zeros.
 */
import java.util.Scanner;

public class BigInteger {

    public static void main(String[] args) {
        String one,two;
        java.math.BigInteger in1, in2;

        Scanner scan = new Scanner(System.in);
        one = scan.next();
        two = scan.next();
        in1 = new java.math.BigInteger(one);
        in2 = new java.math.BigInteger(two);
        System.out.println(in1.add(in2));
        System.out.println(in1.multiply(in2));
    }
}