/**
 * 
 */
package FrontEnd;


/**
 * @author   Roger Ferguson
 */
public class Person implements ClockListener{
	private int tickTime, flag;
	private Eatery Destination;
	
	// max time person stays in line
	protected int boothTime;
	
	
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
		this.boothTime = (int) time;
	}
	
	public int getFlag(){
		return flag;
	}
	
	@Override
	public void event(int tick) {
		if(tick == boothTime){
			flag = 1;
		}
		
	}
}

