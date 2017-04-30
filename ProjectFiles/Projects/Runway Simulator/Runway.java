/**
 * Created by Ryan T and Derek H on 3/30/17.
 * This class represents the runway in an airport simulation.
 */
public class Runway{
    private  int timeForLanding; //How long to land in minutes
    private  int timeForTakeoff; //How long to takeoff in minutes
    private int runwayTimeLeft; //How long until runway is free in minutes
    private char operation; //Operation can be: I – Idle, L-Landing, T-takeoff

    /**
     * Constructor
     * @param time_takeoff int for how long to takeoff in minutes
     * @param time_landing Int for how long to land in minutes
     * @exception IllegalArgumentException Must pass in ints greater than 0
     */
    public Runway ( int time_takeoff, int time_landing){
        if(time_takeoff < 1 || time_landing < 1){
            throw new IllegalArgumentException("Time must be greater than 0");
        }
        timeForLanding=time_landing;
        timeForTakeoff=time_takeoff;
    }

    /**
     * Getter
     * Tells if runway is currently busy
     * @return True if busy and false if available
     */
    public boolean isBusy() {
        if(runwayTimeLeft>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Setter
     * Reduces remaining time for runway operation each call.
     * @postcondition If operation time is greater than zero then decrement, else change runway operation to 'I' for idle
     */
    public void reduceRemainingTime(){
        if(runwayTimeLeft>0){
            runwayTimeLeft--;
        }else{
            operation='I';
        }

    }

    /**
     * Setter
     * Activates runway for a particular operation.
     * @param typeOfUse A char that represents the three states of the runway.
     * @postcondition Plane operation is set to 'I' for Idle, 'L' for Landing, 'T' for Takeoff
     * @exception IllegalArgumentException Input must be 'L', 'T' or 'I'
     */
    public void startUsingRunway(char typeOfUse){
        if(!isRightChar(typeOfUse)){
            throw new IllegalArgumentException("Use must be 'L' or 'T'");
        }
        if(runwayTimeLeft>0){
            throw new IllegalStateException("Runway is in use");
        }
        if(typeOfUse == 'T'){
            runwayTimeLeft = timeForTakeoff;
            operation='T';
        }else if(typeOfUse == 'L'){
            runwayTimeLeft = timeForLanding;
            operation='L';
        }else if(typeOfUse == 'I'){
            runwayTimeLeft = 0;
        }
    }

    /**
     * Getter
     * @return A char representing current operation of the runway
     */
    public char kindOfOperation() {
        return operation;
    }

    /**
     * Checks if a char is 'L' or 'T' or 'I' regardless of capitalization
     * @param input A char passed in by Plane constructor
     * @return Boolean value of true if the value is 'L' or 'T' or 'I' or false if not
     * @see startUsingRunway
     */
    private boolean isRightChar(char input){
        boolean valid = false;
        if(input == 'L' || input == 'l'){
            valid = true;
        }else if(input == 'T' || input == 't'){
            valid = true;
        }else if(input == 'I' || input == 'i'){
            valid = true;
        }
        return valid;
    }

        }//end Runway