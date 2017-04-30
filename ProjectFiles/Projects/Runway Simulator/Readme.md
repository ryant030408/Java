# Runway Simulator
Your simulation will start with 6 input values (which the user will need to input).  These six inputs are:   
*	Total length (in minutes) of simulation
*	Total time needed for a single takeoff (in minutes)
*	Total time needed for a single landing (in minutes)
*	Average number of minutes between planes arriving for landing (this means that the percentage of probability that a plane arrives at any given minute is one divided this number)
*	Average number of minutes between planes arriving for takeoff
*	Maximum number of minutes before landing planes will run out of fuel and crash. 

Your simulation should report output of status for each minute of simulation (see example output).  At the end of the simulation you should report the following:
*	Number of planes that tookoff
*	Number of planes that landed
*	Number of planes that crashed
*	Average waiting time for takeoff
*	Average waiting time for landing

You are to make use of the following classes that we have discussed for the last two classes without any changes.  These classes are stored in the project folder.
*	LinkedQueue
*	LinkedStack
*	Node – used by the first two
*	BooleanSource
*	Averager

You will create these classes to finish the project:
* Runway (see below)
*	Plane (mostly complete - see below)
*	RunwaySimulation- main driver of program.
