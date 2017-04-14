/**
 * 
 */
package FrontEnd;

import java.util.ArrayList;

/**
 * @author Roger Ferguson
 *
 */
public class Sim implements ClockListener{
	
	private int secToNext, secPerCashier, totalTime, secPerEatery, secBeforeLeave, numEateries;
	private int totalThrough, totalLeft, avgTime, maxLength;
	private Clock clk = new Clock();
	private CIS163Q line = new CIS163Q();
	private ArrayList<Eatery> eateryArr = new ArrayList<>();
	
	
	
	public Sim(){
		this.secToNext = 0;
		this.secPerCashier = 0;
		this.totalTime = 0;
		this.secPerEatery = 0;
		this.secBeforeLeave = 0;
		this.numEateries = 0;
	}
	
	public void run(){
		for(int i = 0; i< this.numEateries; i++){
			Eatery Ex = new Eatery();
			PersonProducer produce = new PersonProducer(Ex, secToNext, secPerEatery);
			clk.add(produce);
			clk.add(Ex);
			Ex.setBoothTime(secBeforeLeave);
			eateryArr.add(Ex);
		}
		
		addToLine();
		
		
	}
	
	
	
	/*public Sim(int secToNextI, int secPerCashierI, int totalTimeI, int secPerEateryI, int secBeforeLeaveI, int numEateriesI){
	 setSecToNext(secToNextI);
	 	
	}*/
	
	public void setSecToNext(int secToNext){
		this.secToNext = secToNext;
	}
	public void setSecPerCashier(int secPerCashier){
		this.secPerCashier = secPerCashier;
	}
	public void setTotalTime(int totalTime){
		this.totalTime = totalTime;
	}
	public void setSecPerEatery(int secPerEatery){
		this.secPerEatery = secPerEatery;
	}
	public void setSecBeforeLeave(int secBeforeLeave){
		this.secBeforeLeave = secBeforeLeave;
	}
	public void setNumEateries(int numEateries){
		this.numEateries = numEateries;
	}
	
	public int getTotalThrough(){
		return totalThrough;
	}
	public int getPeopleLeft(){
		return totalLeft;
	}
	public int getAvgTime(){
		return avgTime;
	}
	public int getMaxLength(){
		return maxLength;
	}
	
	
	public void addToLine(){
		System.out.println("In Eatery Call");
		for(Eatery e : eateryArr){
			if(e.getCurrentCompleted() != e.getThroughPut()){
				line.enQ(e.personGetter());
				System.out.println("Number of people in the line: " + line.size());
			}
		}
	}
	
	
	
	
	
	public static void main (String[] args) {
			
			
			//Eatery booth = new Eatery();
			

			// 		int numOfTicksNextPerson = 20 
			//      int averageBoothTime = 20
			
			//PersonProducer produce = new PersonProducer(booth, 20, 18);	
					
			//clk.add(produce);
			//clk.add(booth);
			
			//clk.run(100000); 	// param is ending time 
			
			//System.out.println("Through put is: " + booth.getThroughPut() + " people.");
			//System.out.println("People that are still in the Q:" + booth.getLeft() + " people.");
			//System.out.println ("Max Q length:" + booth.getMaxQlength() + " people.");
		
		}

	@Override
	public void event(int tick) {
		int next = 0;
		if(tick > next){
			addToLine();
		}
		
	}
	}
