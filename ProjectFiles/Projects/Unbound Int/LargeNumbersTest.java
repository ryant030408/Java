import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ryan
 * Class to test use of UnboundedInt class
 */
public class LargeNumbersTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UnboundedInt one = null;
        UnboundedInt two = null;
        UnboundedInt temp = null;
        String oneIn,twoin;
        int selection;
        boolean cont = true;

        System.out.println("Welcome to my large number tester." +
                "\nPlease enter two large positive numbers without spaces: ");
        System.out.println("Please enter the first number: ");
        oneIn = scan.next();
        System.out.println("Please enter the second number: ");
        twoin = scan.next();
        System.out.println("Thank you");
        one = new UnboundedInt(oneIn);
        two = new UnboundedInt(twoin);

        do{
            try{
                System.out.println("\nPlease select your choice below: " +
                        "\n1. Display both numbers\n" +
                        "\n2. Input two new numbers\n" +
                        "\n3. Check if numbers are equal\n" +
                        "\n4. Report the sum of the two numbers\n" +
                        "\n5. Report the multiplication of the two numbers\n" +
                        "\n6. Create and output the clone of the numbers(at least one of them)\n" +
                        "\n7. Quit ");
                selection = scan.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("First number: " + one.toString());
                        System.out.println("Second number: " + two.toString());
                        break;
                    case 2:
                        System.out.println("Please enter two large positive numbers without spaces: ");
                        System.out.println("Please enter the first number: ");
                        oneIn = scan.next();
                        System.out.println("Please enter the second number: ");
                        twoin = scan.next();
                        System.out.println("Thank you");
                        one = new UnboundedInt(oneIn);
                        two = new UnboundedInt(twoin);
                        break;
                    case 3:
                        if(one.equals(two)){
                            System.out.println("The numbers are equal");
                        }else{
                            System.out.println("The numbers are not equal");
                        }
                        break;
                    case 4:
                        temp = one.add(two);
                        System.out.println("The sum of the numbers is: " + temp.toString());
                        break;
                    case 5:
                        temp = one.multiply(two);
                        System.out.println("The product of one and two is: " + temp.toString());
                        break;
                    case 6:
                        int choice;
                        System.out.println("Would you like to clone the first number or second?" +
                                "\nEnter a 1 or 2: ");
                        choice = scan.nextInt();
                        if(choice == 1){
                            temp = one.clone();
                        }else if(choice == 2){
                            temp = two.clone();
                        }else{
                            throw new InputMismatchException("Not a choice");
                        }
                        System.out.println("Clone created, number is: " + temp.toString());
                        break;
                    case 7:
                        cont = false;
                        System.out.println("Thank you for using my program.");
                        break;
                    default:
                        break;

                }
            }catch (Exception e){
                System.out.println(e);
            }

        }while (cont);

    }
}
