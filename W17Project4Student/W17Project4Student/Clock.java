/**
 * 
 */
package FrontEnd;

/**
 * @author   Roger Ferguson
 */
public class Clock {

	private ClockListener[] myListeners; 		//holds eaterys and personProducers
	private int numListeners;
	private int MAX = 100;

	public Clock() {
		numListeners = 0;
		myListeners = new ClockListener[MAX];
	}

	/**
	 * Sends the current time of the clock to the clock listener. From the clock listener, the time is then set to any class 
	 * Implements the clock listener class so that it is able to see the current time and use it how it wants. 
	 * @param endingTime
	 */
	public void run(int endingTime) { 		
		for (int currentTime = 0; currentTime <= endingTime; currentTime++) {
			for (int j = 0; j < numListeners; j++)
				myListeners[j].event(currentTime); 		//sends current time to the clock listener class. 
		}
	}

	public void add(ClockListener cl) {
		myListeners[numListeners] = cl;
		numListeners++;
	}

	public ClockListener[] getMyListeners() {
		return myListeners;
	}

	public void setMyListeners(ClockListener[] myListeners) {
		this.myListeners = myListeners;
	}

	public int getNumListeners() {
		return numListeners;
	}

	public void setNumListeners(int numListeners) {
		this.numListeners = numListeners;
	}

	public int getMAX() {
		return MAX;
	}

}
