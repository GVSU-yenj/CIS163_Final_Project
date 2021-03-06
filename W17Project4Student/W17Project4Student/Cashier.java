package FrontEnd;

public class Cashier implements ClockListener{
	private int nextCashTime, currentTime=0, personTotalTime = 0;
	private Person personAtCashier;
	private boolean emptyCashierFlag;
	
	
	@Override
	public void event(int tick) {
		if(personAtCashier == null){
			emptyCashierFlag = true;
		}
		else{
			emptyCashierFlag = false;
		
			if( tick > currentTime){
				personTotalTime = personAtCashier.getTickTime();
				
				personAtCashier = null;
				currentTime += this.nextCashTime;
			}
		}
			
		
	}
	
	public boolean getFlag(){
		return emptyCashierFlag;
	}
	
	/**
	 * set person from the gui;
	 * @param per
	 */
	public void setPerson(Person per){
		this.personAtCashier = per;
		//emptyCashierFlag = true;  			//just incase clock doesnt work. 
	}
	
	public void setCashtime(int cashTime){
		this.nextCashTime = cashTime;
	}
	public int getPersonTT(){
		return personTotalTime;
	}

}