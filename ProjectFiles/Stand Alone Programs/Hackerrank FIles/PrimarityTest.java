/**
 * Created by RyanT on 11/12/16.
 */
import java.math.BigInteger;
import java.util.*;

/**
A prime number is a natural number greater than  whose only positive divisors are  and itself. For example, the first six prime numbers are , , , , , and .

        Given a large integer, , use the Java BigInteger class' isProbablePrime method to determine and print whether it's prime or not prime.

        Input Format

        A single line containing an integer,  (the number to be checked).

        Constraints

        contains at most  digits.
        Output Format

        If  is a prime number, print prime; otherwise, print not prime.
**/
public class PrimarityTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();
        // Write your code here.
        if(n.isProbablePrime(1)){
            System.out.print("prime");
        }else{
            System.out.println("not prime");
        }
    }


}
