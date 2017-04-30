import java.util.Scanner;     //need Scanner class
/**
 * Created by Ryan T and Derek H on 3/30/17.
 * This program is used to test the application of Runway.java and Plane.java. It uses th eRunway class to run a
 * minute by minute simulation of a one runway airport and tracks planes waiting to land, take off and planes that have
 * crashed. The parameters for the test are given through the console from the user.
 */
public class RunwaySimulation {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Welcome to the Runway Simulator Program. You will need to input 6 integer values:");
        System.out.println("The length (in minutes) of the simulation: ");
        final int SIMTIME =keyboard.nextInt();
        System.out.println("Total time needed for a single takeoff (in minutes): ");
        final int TAKEOFFTIME =keyboard.nextInt();
        System.out.println("Total time needed for a single landing (in minutes): ");
        final int LANDINGTIME =keyboard.nextInt();
        System.out.println("Average number of minutes between planes arriving for landing : ");
        final int AVERAGEBETWEENTAKEOFFS =keyboard.nextInt();
        System.out.println("Average number of minutes between planes arriving for takeoff: ");
        final int AVERAGEBETWEENLANDINGS =keyboard.nextInt();
        System.out.println("Maximum number of minutes before landing planes will run out of fuel and crash. : ");
        final int MAXBEFORECRASH =keyboard.nextInt();



        RunwaySimulator(SIMTIME,TAKEOFFTIME,LANDINGTIME,AVERAGEBETWEENTAKEOFFS,AVERAGEBETWEENLANDINGS,MAXBEFORECRASH);

    }
    public static void RunwaySimulator(int simTime, int takeOffTime, int landingTime, int averageBetweenTakeoffs, int averageBetweenLandings, int maxBeforeCrash){
        LinkedQueue<Plane> waitingToTakeOff = new LinkedQueue<Plane>();
        LinkedQueue<Plane> waitingToLand = new LinkedQueue<Plane>();
        Plane next;
        BooleanSource takeOffArrival = new BooleanSource(1.0/(double)averageBetweenTakeoffs);
        BooleanSource landingArrival = new BooleanSource(1.0/(double)averageBetweenLandings);
        Averager takeOffTimeAverage = new Averager();
        Averager landingTimeAverage = new Averager();
        LinkedStack<Plane> crashed = new LinkedStack<Plane>();
        Runway runway = new Runway(takeOffTime, landingTime);
        int currentMinute, takeOffs, landings, crashes, takeOffAttempts, landingAttempts, takeOffQN, landQN;
        boolean crashLoop = true;
        takeOffs=0;
        takeOffAttempts = 0;
        landingAttempts = 0;
        landings=0;
        crashes = 0;
        takeOffQN=0;
        landQN=0;
        int takingOffLndPN = 0;


        for(currentMinute = 1; currentMinute<=simTime; currentMinute++){
            System.out.println("During minute " +currentMinute+":");

            if(takeOffArrival.query()){
                takeOffAttempts++;
                Plane takeOffQ=new Plane(currentMinute,'T');
                waitingToTakeOff.add(takeOffQ);
                takeOffQN=takeOffQ.getPlaneNo();
                System.out.println("   Arrived for Takeoff: Plane #"+takeOffQN);
            }
            if(landingArrival.query()){
                landingAttempts++;
                Plane landQ=new Plane(currentMinute, 'L');
                waitingToLand.add(landQ);
                landQN=landQ.getPlaneNo();
                System.out.println("   Arrived for Landing: Plane #"+landQ.getPlaneNo());
            }
            if((!runway.isBusy()) && (!waitingToLand.isEmpty())){
                while (crashLoop){
                    next = waitingToLand.remove();
                    takingOffLndPN = next.getPlaneNo();
                    if((currentMinute-next.getTime())>maxBeforeCrash){
                        crashed.push(next);
                        System.out.println("   Crashed: Plane #"+next.getPlaneNo());
                        crashes++;
                        if(waitingToLand.isEmpty()){
                            crashLoop = false;
                        }
                    }else{
                        landingTimeAverage.addNumber((double)currentMinute-(double)next.getTime());
                        runway.startUsingRunway(next.getOperation());
                        landings++;
                        crashLoop = false;
                    }
                }
                crashLoop = true;

            }
            
            if((!runway.isBusy()) && (!waitingToTakeOff.isEmpty())){
                next = waitingToTakeOff.remove();
                takingOffLndPN = next.getPlaneNo();
                runway.startUsingRunway(next.getOperation());
                takeOffs++;
            }
            if(runway.isBusy()) {
               if (runway.kindOfOperation() == 'L') 
                  System.out.println("   Runway: Plane #"+takingOffLndPN+" is landing");

               else if (runway.kindOfOperation() == 'T') 
                  System.out.println("   Runway: Plane #"+takingOffLndPN+" is taking off");

            }else 
                  System.out.println("   Runway: Idle");


            runway.reduceRemainingTime();


        }
        while(!crashed.isEmpty()){
            Plane temp = crashed.pop();
            System.out.println("Plane " + temp.getPlaneNo() + " crashed at " + (temp.getTime()+5) + " minutes.");
        }

        System.out.println("Planes that queued for takeoff: "  + takeOffAttempts);
        System.out.println("Planes that queued for landing: "  + landingAttempts);
        System.out.println("Planes that took off: "  + takeOffs);
        System.out.println("Planes that landed: "  + landings);
        if(takeOffTimeAverage.average() > 0){
            System.out.println("Average wait time for take off: "  + takeOffTimeAverage.average() + " minutes");
        }else{
            System.out.println("Average wait time for take off: 0 minutes");
        }
        if(landingTimeAverage.average() > 0){
            System.out.println("Average wait time for landing: "  + landingTimeAverage.average() + " minutes");
        }else{
            System.out.println("Average wait time for landing: 0 minutes");
        }

        System.out.println("Crashed planes: " + crashes);

    }
}
