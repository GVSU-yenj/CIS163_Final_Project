/**
 * 
 */
package FrontEnd;

/**
 * @author   Roger Ferguson
 */
public class Person implements clockListener {
	private int tickTime;
	private int flag
	private Eatery Destination;
	
	// max time person stays in line
	protected double boothTime;
	
	public void event(int tick){
		if (boothTime == 300){
			flag = 1;
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
}
