package FrontEnd; //FIXME: Remove before submitting
import java.util.ArrayList;

import FoodCourt.FCGUI;
/**
 * @author   Roger Ferguson
 */
public class Eatery implements ClockListener {
	private ArrayList<Person> Q = new ArrayList<Person>();
	
	private int timeOfNextEvent = 0;
	private int maxQlength = 0;
	private Person person, tempPer;   // this is the person at the Eatery. 
	private int completed = 0, currentCompleted;
	private CIS163Q<Person> Que = new CIS163Q<Person>();
	private double val;
	
	
	public void add (Person person)
	{
		//System.out.println("This is the value passed into this function fro GUI: " + this.val);
		person.setWaitTime(this.val);
		Q.add(person);
		if (Q.size() > maxQlength)
			maxQlength = Q.size(); 		//size that the Q has been
	}
	
	/**
	 * getting the current clock from the clock listener class. 
	 * using the clock (tick) to remove people from the eatery
	 */
	public void event (int tick){ 
		//System.out.println("Tick in the eatery before : " + tick);
		currentCompleted = completed;
		if (tick >= timeOfNextEvent) {
//			if (person != null) { 			// Notice the delay that takes place here
//				person.getDestination().add(person);    // take this person to the next station. 
//			person = null;				// I have send the person on. 
//			}
			
			if (Q.size() >= 1) {
				person = Q.remove(0);		// do not send this person as of yet, make them wait. 
				setPerson(person);
				//Que.enQ(person);
				timeOfNextEvent = tick + (int) (person.getBoothTime() + 1);
				completed++;
				//System.out.println("Size of Eatery line: " + Que.size());
				
			}	
		}
	}
	
	/**
	 * From the GUI set the time person waits to leave. 
	 * @param boothTime
	 */
	public void setBoothTime(int boothTime){
		this.val = (double)boothTime;
	}
	
	
	
	public void getFlag(){
		if(person.getFlag() ==1){
			person = Q.remove(0);
		}
	}
	
	public int getLeft() {
		return Q.size();
	}
	
	public int getMaxQlength() {
		return maxQlength;
	}
	public int getCurrentCompleted(){
		return currentCompleted;
	}

	public int getThroughPut() {
		return completed;
	}
	public void setPerson(Person p){
		tempPer = p;
	}
	public Person personGetter(){
		return tempPer;
	}
}

