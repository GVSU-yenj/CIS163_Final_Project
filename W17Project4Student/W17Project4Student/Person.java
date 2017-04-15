package FrontEnd;

/**
 * The person class builts a person object that will be added to other classes.
 * @author Tim Irish, Jon Yen, Jake Cousino
 */
public class Person implements ClockListener{
	private int tickTime, flag, hasFirstTickFlag, firstTick;
	private double waitTime;
	private Eatery Destination;
	
	// max time person stays in line
	protected double boothTime;
	
	/**
	* The contructor for the person class sets the instance variables to 0.
	*/
	public Person(){
		this.tickTime= 0;
		this.hasFirstTickFlag = 0;
	}
	
	/**
	* Sets an input of time equal to waitTime.
	* @param time amount of time a person will wait in line.
	*/
	public void setWaitTime(double time){
		waitTime = time;
	}
	
	/**
	* returns boothTime amount of time a person will wait in line.
	* @return boothTime 
	*/
	public double getBoothTime() {
		return boothTime;
	}
	
	
	/**
	* returns the eatery in which a person will go to.
	* @return Destination
	*/
	public Eatery getDestination() {
		return Destination;
	}
	
	/**
	* Sets the eatery the person object goes to
	* @param destination the eatery. 
	*/
	public void setDestination(Eatery destination) {
		Destination = destination;
	}
	
	/**
	* returns the total amount of ticks for the person object
	* @return tickTime 
	*/
	public int getTickTime() {
		return tickTime;
	}
	
	/**
	* Sets the total amount of ticks for the person object.
	* @param tickTime
	*/
	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}

	/**
	* Sets the amount of time spent in an eatery.
	* @param time
	*/
	public void setEateryTime(double time) {
		this.boothTime = time;
	}
	
	/**
	* returns the flag that indicates someone went over
	* the wait time.
	* @return flag 
	*/
	public int getFlag(){
		return flag;
	}
	
	/**
	* Decides whether or not to add a flag due to a perso object being in line longer than the wait time.
	* @param tick the current tick of the clock 
	*/
	@Override
	public void event(int tick) {
		/*if(this.hasFirstTickFlag == 0){
			firstTick = tick;
			this.hasFirstTickFlag = 1;
		}*/
		setTickTime(tick);
		if(tick >= waitTime){
			flag = 1;
		}
		
	}
}

