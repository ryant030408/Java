
import java.util.InputMismatchException;

/**
 * Created by Ryan
 * UnboundedInt class for creating large numbers using IntNodes
 */

public class UnboundedInt implements Cloneable{

    int howMany; //Keeps track of nodes
    IntNode head = null;
    IntNode tail = null;
    IntNode cursor = null;
    private int carry = 0;
    private int currentSum=0;



    /**
     * Constructor method creates UnboundedInt from string.
     * @param bigNum
     * @precondition - Input must be a string of numbers
     * @postcondition - An UnboundedInt is created from the input
     * @exception -
     *  InputMismatchExeption: Indicates a non number was inputted
     */
    public UnboundedInt(String bigNum){
        if(!(bigNum.matches("\\d*"))){
            throw new InputMismatchException("This is not a number");
        }
        int nums;
        while(bigNum!=""){
            nums = intPuller(bigNum);
            bigNum = strShortener(bigNum);
            start();
            addEnd(nums);
        }
    }

    /**
     *Adds two UnboundedInt numbers
     * @param - input
     * @return - A new UnboundedInt with sum of two UnboundedInts involved
     *
     */
    public UnboundedInt add(UnboundedInt input){
        IntNode one = IntNode.listCopy(head);
        IntNode two = IntNode.listCopy(input.head);
        UnboundedInt answer;
        StringBuilder sb = new StringBuilder();

        while(one!= null && two!=null){
            currentSum = carry + (one.getData()+two.getData());
            carry = 0;
            sumChecker();
            one = one.getLink();
            two = two.getLink();
            sb.insert(0, currentSum);
            sb = stringAppender(sb);
            currentSum=0;
        }
        while(one!= null && two==null){
            currentSum = carry + (one.getData());
            carry = 0;
            sumChecker();
            one = one.getLink();
            sb.insert(0, currentSum);
            sb = stringAppender(sb);
            currentSum=0;
        }
        while(one== null && two!=null){
            currentSum = carry + (two.getData());
            carry = 0;
            sumChecker();
            two = two.getLink();
            sb.insert(0, currentSum);
            sb = stringAppender(sb);
            currentSum=0;
        }
        if(one == null && two == null && carry != 0){
            currentSum = carry;
            carry = 0;
            sb.insert(0, currentSum);
            currentSum = 0;
        }
        answer = new UnboundedInt(sb.toString());
        return answer;
    }

    /**
     *Multiplies two UnboundedInts and returns a new UnboundedInt with the product
     * @param - input
     * @return - A new UnboundedInt containing the product of the UnboundedInts
     */
    public UnboundedInt multiply(UnboundedInt input){
        IntNode one = IntNode.listCopy(head);
        int zeroPowerOne = 0;
        int zeroPowerTwo = 0;
        UnboundedInt answer = new UnboundedInt("0");
        UnboundedInt temp;
        int tempAnswer;

        while(one!= null){
            IntNode two = IntNode.listCopy(input.head);
            while(two!=null){
                StringBuilder sb = new StringBuilder();
                tempAnswer = one.getData()*two.getData();
                sb.insert(0, tempAnswer);
                sb = multZeroAppender(sb, zeroPowerOne,zeroPowerTwo);
                temp = new UnboundedInt(sb.toString());
                answer = answer.add(temp);
                temp = null;
                two = two.getLink();
                zeroPowerTwo++;
            }
            zeroPowerTwo=0;
            zeroPowerOne++;
            one = one.getLink();
        }
        return answer;
    }

    /**
     * Sets the cursor to the beggining of the list
     * @param - none
     * @postcondition - The cursor is now set to the head element of this list.
     *
     */
    public void start(){
        cursor = head;
    }

    /**
     * Move forward so that the current element is the next element in this list.
     * @param - none
     * @precondition - cursor must not link to a null node.
     * @postcondition - If the cursor was not the last in the list it is moved ahead one link.
     * @exception -
     * IllegalStateException: Indicates there is no next node to move to.
     */
    public void advance(){
        if(cursor.getLink() == null){
            throw new IllegalStateException("No current element to advance");
        }
        cursor = cursor.getLink();
    }

    /**
     *Accessor method that returns value of current cursor
     * @param - none
     * @return - Data contained within curent cursor.
     * @exception -
     *  IllegalStateException: Indicates that cursor is null.
     */
    public int getNodeValue(){
        if(cursor == null){
            throw new IllegalStateException("No current element to retrieve");
        }
        return cursor.getData();
    }

    /**
     *Adds an integer to the end of a list
     * @param - input
     */
    public void addEnd(int input){
        if (head == null){
            head = new IntNode(input, null);
            howMany++;
            tail = head.getLink();
        }else {
            start();
            while (cursor.getLink() != null){
                advance();
            }
            cursor.setLink(new IntNode(input, null));
            howMany++;
            tail = cursor.getLink();
        }

    }

    /**
     *Clones current UnboundedInt and returns a duplicate
     *
     * @return - A new UNboundedInt with the same information from the reference. Changes
     *  to this UnboundedInt will not affect the original and vice versa.
     * @exception -
     *  OutOfMemoryError: Indicates insufficient memory for creating a clone.
     */
    public UnboundedInt clone( ){
        UnboundedInt answer;

        try{
            answer = (UnboundedInt) super.clone();
        }
        catch ( CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable");
        }

        //answer.head = IntNode.listCopy(head);

        return answer;
    }

    /**
     *Checks if the UnboundedInts are equal
     * @param - input
     * @return A true or false value indicating equality
     */
    public boolean equals(Object input){
        start();
        if (input instanceof UnboundedInt)
        {
            UnboundedInt candidate = (UnboundedInt) input;
            candidate.start();
            while (candidate.cursor!=null){
                if(cursor == null){
                    return false;
                }
                if(candidate.cursor.getData() != cursor.getData()){
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (IntNode cursor = head; cursor != null; cursor = cursor.getLink()){
            if(cursor.getData() < 10 && cursor.getLink()!=null){
                sb.insert(0, cursor.getData());
                sb.insert(0,"00");
            }else if(cursor.getData() < 100 && cursor.getData() > 10&& cursor.getLink()!=null){
                sb.insert(0, cursor.getData());
                sb.insert(0,0);
            }else{
                sb.insert(0, cursor.getData());
            }
        }
        return sb.toString();
    }
    private void sumChecker(){
        if(currentSum > 999){
            carry = currentSum/1000;
            currentSum = currentSum%1000;

        }
    }
    private void multChecker(){
        if(currentSum > 999){
            carry = currentSum/1000;
            currentSum = currentSum%1000;
            //carry = carry*1000;
            //currentSum = currentSum-carry;

        }else if(currentSum == 0){
            carry = 1000;
        }

    }
    private String strShortener(String input){
        String answer = input;
        if (answer.length()>3) {
            answer = answer.substring(0, answer.length()-3);
        }else{
            answer = "";
        }


        return answer;
    }
    private int intPuller(String input){
        int answer;
        if(input.length() > 3){
            answer = Integer.parseInt(input.substring(input.length()-3));
        }else{
            answer = Integer.parseInt(input.substring(input.length()-input.length()));
        }

        return answer;
    }
    private StringBuilder stringAppender(StringBuilder insb){
        StringBuilder temp = insb;
        if(currentSum == 0){
            temp.insert(0,"00");
        }else if(currentSum < 10 && currentSum > 0){
            temp.insert(0,"00");
        }else if(currentSum < 100 && currentSum > 10){
            temp.insert(0,0);
        }
        return temp;
    }
    private StringBuilder multZeroAppender(StringBuilder input, int zeroesOne, int zeroesTwo) {
        StringBuilder answer = input;
        for(int i = 0; i < (zeroesOne+zeroesTwo)*3; i++){
            answer.insert(answer.length(), "0");
        }

        return answer;

    }

}
