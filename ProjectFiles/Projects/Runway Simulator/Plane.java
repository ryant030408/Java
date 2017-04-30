/**
 * Created by Ryan T and Derek H on 3/30/17.
 * This class is to build a plane object. It is meant to be implemented in conjunction with Runway.java to simulate
 * an airport.
 */
public class Plane {
    static private int planeCount = 0; // How many planes have been created
    private int time; // The time the plane arrived in queue
    private char operation;  // The kind of operation the plane is doing 'L" is  for landing 'T' is for taking off
    private int planeNo;   // Plane number, the plane number arrived to the queue, should be in incrementing order

    /**
     * Constructor
     * Create a plane object
     * @param aTime An int for time the plane arrived in the queue
     * @param landingOrTakeOff A char for wheather the place is 'L' landing or 'T' taking off
     * @precondition aTime must be a positive integer and landingOrTakeOff must be either 'L' or 'T'
     * @exception IllegalArgumentException On aTime less than 1 or landingOrTakeOff not being 'L' or 'T'
     *
     */
    public Plane( int aTime, char landingOrTakeOff){
        if(aTime < 1){
            throw new IllegalArgumentException("Time cannot be less than 1 minute");
        }
        if(!isRightChar(landingOrTakeOff)){
            throw new IllegalArgumentException("Landing or takeoff must be represented by 'L' or 'T'");
        }
        time = aTime;
        operation =  landingOrTakeOff;
        planeNo = ++planeCount;
    }

    /**
     * Getter
     * @return An int that represents the time the plane arrived in the queue
     */
    public int getTime()  {
        return time;
    }

    /**
     * Getter
     * @return An int that represents the planes place in queue
     */
    public int getPlaneNo () {
        return planeNo;
    }

    /**
     * Getter
     * @return A char that will be 'L' for landing queue or 'T' for takeoff queue
     */
    public char getOperation () {
        return operation;
    }

    /**
     * Getter
     * @return An int that represents how mnay plane objects were created
     */
    private static int getPlaneCount()
    {
        return planeCount;
    }

    /**
     * Checks if a char is 'L' or 'T' regardless of capitalization
     * @param input A char passed in by Plane constructor
     * @return Boolean value of true if the value is 'L' or 'T' or false if not
     * @see Plane
     */
    private boolean isRightChar(char input){
        boolean valid = false;
        if(input == 'L' || input == 'l'){
            valid = true;
        }else if(input == 'T' || input == 't'){
            valid = true;
        }
        return valid;
    }

}// end Plane
