package FrontEnd;

/**
 * @author   Roger Ferguson
 */
public class Person implements ClockListener{
	private int tickTime, flag, hasFirstTickFlag, firstTick;
	private double waitTime;
	private Eatery Destination;
	
	// max time person stays in line
	protected double boothTime;
	
	public Person(){
		this.tickTime= 0;
		this.hasFirstTickFlag = 0;
	}
	
	
	public void setWaitTime(double time){
		waitTime = time;
	}
	
	public double getBoothTime() {
		return boothTime;
	}
	
	public Eatery getDestination() {
		return Destination;
	}

	public void setDestination(Eatery destination) {
		Destination = destination;
	}
	
	public int getTickTime() {
		return tickTime;
	}

	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}

	public void setEateryTime(double time) {
		this.boothTime = time;
	}
	
	public int getFlag(){
		return flag;
	}
	
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

