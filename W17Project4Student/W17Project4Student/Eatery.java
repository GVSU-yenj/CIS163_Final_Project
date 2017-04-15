package FrontEnd; //FIXME: Remove before submitting
import java.util.ArrayList;

import FoodCourt.FCGUI;
/**
 * @author Tim Irish, Jon Yen, Jake Cousino
 */
public class Eatery implements ClockListener {
	private ArrayList<Person> Q = new ArrayList<Person>();
	
	private int timeOfNextEvent = 0;
	private int maxQlength = 0;
	private Person person, tempPer;   // this is the person at the Eatery. 
	private int completed = 0, currentCompleted;
	private CIS163Q<Person> Que = new CIS163Q<Person>();
	private double val;
	
	/**
	* adds a person to the eatery line and then sets the max line length
	* @param person a new person object 
	*/
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
	
	
	/**
	* If the number of flags is equal to one a person is removed
	*/
	public void getFlag(){
		if(person.getFlag() ==1){
			person = Q.remove(0);
		}
	}
	
	/**
	* returns the amount of people left in the eatery line
	* @return   size of the Q 
	*/
	public int getLeft() {
		return Q.size();
	}
	
	/**
	* returns the max amount of people that were 
	* on the eatery line.
	* @return  max length of the Q. 
	*/
	public int getMaxQlength() {
		return maxQlength;
	}
	
	/**
	* return the amount of people that got through the eatery line
	* @return currentCompleted  
	*/
	public int getCurrentCompleted(){
		return currentCompleted;
	}
	
	/**
	* return the amount of people that got through the eatery line minus 1
	* @return completed 
	*/
	public int getThroughPut() {
		return completed;
	}
	
	/**
	* sets a person object to temPer
	*/
	public void setPerson(Person p){
		tempPer = p;
	}
	
	/**
	* returns temPer
	* @return temPer
	*/
	public Person personGetter(){
		return tempPer;
	}
}

