/**
 * 
 */
package FrontEnd;

/**
 * @author   Roger Ferguson
 */
public class Person implements ClockListener{
	private int tickTime, flag;
	private double waitTime;
	private Eatery Destination;
	
	// max time person stays in line
	protected double boothTime;
	
	
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
		//System.out.println("This is the value in the person: " + time);
		this.boothTime = time;
	}
	
	public int getFlag(){
		return flag;
	}
	
	@Override
	public void event(int tick) {
		if(tick == waitTime){
			flag = 1;
		}
		
	}
}

