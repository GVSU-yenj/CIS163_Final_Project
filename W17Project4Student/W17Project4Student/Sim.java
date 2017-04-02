/**
 * 
 */
package FrontEnd;

/**
 * @author Roger Ferguson
 *
 */
public class Sim {
	
	public static void main (String[] args) {
			
			Clock clk = new Clock();
			Eatery booth = new Eatery();
			Eatery TacoBell = new Eatery();

			// 		int numOfTicksNextPerson = 20 
			//      int averageBoothTime = 20
			
			PersonProducer produce = new PersonProducer(booth, 20, 18);	
			PersonProducer produceT = new PersonProducer(TacoBell, 10, 8); 		
			clk.add(produce);
			clk.add(booth);
			clk.add(produceT);  	//need this to send people to taco bell
			clk.add(TacoBell);		//need this to run taco bell
			
			clk.run(100000); 	// param is ending time 
			
			System.out.println("Through put is: " + booth.getThroughPut() + " people.");
			System.out.println("People that are still in the Q:" + booth.getLeft() + " people.");
			System.out.println ("Max Q length:" + booth.getMaxQlength() + " people.");
			System.out.println("Through put is: " + TacoBell.getThroughPut() + " people.");
			System.out.println("People that are still in the Q:" + TacoBell.getLeft() + " people.");
			System.out.println ("Max Q length:" + TacoBell.getMaxQlength() + " people.");
		}
	}
