package FoodCourt;

import java.awt.*;
import javax.swing.*;

import FrontEnd.CIS163Q;
import FrontEnd.Cashier;
import FrontEnd.Clock;
import FrontEnd.ClockListener;
import FrontEnd.Eatery;
import FrontEnd.EmptyQException;
import FrontEnd.Person;
import FrontEnd.PersonProducer;
import FrontEnd.Sim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FCGUI extends JFrame implements ActionListener , ClockListener{
	
	  private static final long serialVersionUID = 1L;
	  private JPanel inInfoPanel, buttonPanel, outInfoPanel;
	  private JLabel Title, blank, STNLabel, SPCLabel, TTLabel, SPELabel, SBLLAbel;
	  private JLabel NELabel, throughInfo, avgTimeInfo, numberPeopleInfo, maxQInfo;
	  private JTextArea secToNext, secPerCashier, totalTime, secPerEatery, secBeforeLeave, numEateries;
	  private JButton starter, quitter;
	  private int secToNextI, secPerCashierI, totalTimeI, secPerEateryI, secBeforeLeaveI, numEateriesI, totalQLine, maxLength, totalTickTime;
	  private ArrayList<Eatery> eateryArr = new ArrayList<>();
	  private CIS163Q<Person> line = new CIS163Q<>();
	  private static Clock clk = new Clock();
	  private Cashier cash = new Cashier();;
	 
	//This constructor instantiates the GUI elements		
	  public FCGUI(){
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		BorderLayout mainLayout = new BorderLayout();
		this.setLayout(mainLayout);
	    
	    inInfoPanel = new JPanel();
	    GridLayout layout = new GridLayout(0, 2);
	    inInfoPanel.setLayout(layout);
	    layout.setVgap(10);
	    inInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
	    this.add(inInfoPanel, BorderLayout.NORTH);
	    Font myText = new Font(Font.SERIF, Font.BOLD, 20);
	    
	//The top part of the GUI asking for input
	    Title = new JLabel("Input Information");
	    Title.setFont(myText);
	    inInfoPanel.add(Title);
	    
	    blank = new JLabel("");
	    inInfoPanel.add(blank);
	    
	    STNLabel = new JLabel("Seconds to the Next Person");
	    inInfoPanel.add(STNLabel);
	    
	    secToNext = new JTextArea("20");
	    secToNext.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secToNext);
	    
	    SPCLabel = new JLabel("Seconds per Cashier");
	    inInfoPanel.add(SPCLabel);
	    
	    secPerCashier = new JTextArea("10");
	    secPerCashier.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secPerCashier);
	    
	    TTLabel = new JLabel("Total Time");
	    inInfoPanel.add(TTLabel);
	    
	    totalTime = new JTextArea("10000");
	    totalTime.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(totalTime);
	    
	    SPELabel = new JLabel("Seconds per Eatery");
	    inInfoPanel.add(SPELabel);
	    
	    secPerEatery = new JTextArea("60");
	    secPerEatery.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secPerEatery);
	    
	    SBLLAbel = new JLabel("Seconds Before Someone Leaves");
	    inInfoPanel.add(SBLLAbel);
	    
	    secBeforeLeave = new JTextArea("900");
	    secBeforeLeave.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secBeforeLeave);
	    
	    NELabel = new JLabel("Number of Eateries");
	    inInfoPanel.add(NELabel);
	    
	    numEateries = new JTextArea("5");
	    numEateries.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(numEateries);
	    
	    buttonPanel = new JPanel();
	    this.add(buttonPanel,BorderLayout.CENTER);
	    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
	    buttonPanel.setLayout(new GridLayout(0,2));

	      //Buttons for the sim
	      starter = new JButton("Start da Sim!");
	      quitter = new JButton("Quit da Sim!");
	     
	      starter.addActionListener(this);
	      quitter.addActionListener(this);
	     Dimension d = new Dimension(40, 40);
	     starter.setPreferredSize(d);
	     quitter.setPreferredSize(d);
	     
	     buttonPanel.add(starter);
	     buttonPanel.add(quitter);
	    
	//The rest of the constructor is for the output
	    outInfoPanel = new JPanel();
	    GridLayout layout2 = new GridLayout(0, 2);
	    layout2.setVgap(10);
		outInfoPanel.setLayout(layout2);
		outInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
	    
		JLabel Title2 = new JLabel("Output Info");
		Title2.setFont(myText);
		JLabel blank2 = new JLabel("");
	    JLabel through = new JLabel("Through put");
	    JLabel avgTime = new JLabel("Average time for a person from start to finish");
	    JLabel numberPeople = new JLabel("Number of people left in line");
	    JLabel maxQ = new JLabel("Max Q length cashier line");
	    
	    throughInfo = new JLabel(" ");
	    avgTimeInfo = new JLabel(" ");
	    numberPeopleInfo = new JLabel(" ");
	    maxQInfo = new JLabel(" ");
	    
	    outInfoPanel.add(Title2);
	    outInfoPanel.add(blank2);
	    outInfoPanel.add(through);
	    outInfoPanel.add(throughInfo);
	    outInfoPanel.add(avgTime);
	    outInfoPanel.add(avgTimeInfo);
	    outInfoPanel.add(numberPeople);
	    outInfoPanel.add(numberPeopleInfo);
	    outInfoPanel.add(maxQ);
	    outInfoPanel.add(maxQInfo);
	    
	    this.add(outInfoPanel, BorderLayout.SOUTH);
	    
	    this.pack();
	}

	private Cashier Cashier() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	* @param e This will be the listener for whichever button gets pressed.
	*/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == starter){
			System.out.println("Hello here in the action listener");
			secToNextI = Integer.parseInt(secToNext.getText());
			secPerCashierI = Integer.parseInt(secPerCashier.getText());
			totalTimeI = Integer.parseInt(totalTime.getText());
			secPerEateryI = Integer.parseInt(secPerEatery.getText());
			secBeforeLeaveI = Integer.parseInt(secBeforeLeave.getText());
			numEateriesI = Integer.parseInt(numEateries.getText());
	
			runSim(secToNextI, secPerCashierI, totalTimeI, secPerEateryI, secBeforeLeaveI, numEateriesI);
		}
		if(e.getSource() == quitter){
			System.exit(1);
		}
		
	}

			/*
			*This function is where the calculations will be performed.
			* @param secToNextI The amount of time for a person to appear at the eatery
			* @param secPerCashierI The amount of time someone will spend at the cashier
			* @param totalTimeI The total time that the food court will be open
			* @param secPerEatery How long each person spends at the eateries
			* @param secBeforeLeaveI How long a person will wait before leaving prematurely
			* @param numEateriesI The amount of eateries that will spawn into the simulation
			*/
	public void runSim(int secToNextI, int secPerCashierI, int totalTimeI, int secPerEateryI, int secBeforeLeaveI, int numEateriesI){
		/*Sim s = new Sim();
		//clk.add(s);
		s.setSecToNext(secToNextI);
		s.setSecPerCashier(secPerCashierI);
		s.setTotalTime(totalTimeI);
		s.setSecPerEatery(secPerEateryI);
		s.setSecBeforeLeave(secBeforeLeaveI);
		s.setNumEateries(numEateriesI);
		s.run();
		//clk.run(totalTimeI);
		System.out.println("Here after the sim call");
		*/
		
		int through = 0, left = 0, max = 0, size = 0;;
		int val = secBeforeLeaveI;
		
		for(int i = 0; i < numEateriesI; i++){
			Eatery Ex = new Eatery();
			PersonProducer produce = new PersonProducer(Ex, secToNextI, secPerEateryI);
			clk.add(produce);
			clk.add(Ex);
			Ex.setBoothTime(val);
			eateryArr.add(Ex);
		}
		
		cash.setCashtime(secPerCashierI);
		clk.add(cash);
		clk.run(totalTimeI);
			
		through = getTotalThru();
		left = getTotalLeft();
		int avg = avgPersonTime();
		
		//System.out.println("Size of line in the GUI: " + line.size());
		throughInfo.setText("Through put is: " + through + " people.");
		avgTimeInfo.setText("  " + totalTickTime + " seconds");
		numberPeopleInfo.setText("People that are still in the Q: " + left + " people.");
		maxQInfo.setText("Max Q length: " + maxLength + " people."); 
	}
	
	public int getTotalThru(){
		int total = 0;
		for(Eatery e: eateryArr){
			total += e.getThroughPut();
		}
		return total;
	}
		
	/*
	*@returns returns the amount of people left in the eateries
	*/
	public int getTotalLeft(){
		int total = 0;
		for(Eatery e: eateryArr){
			total += e.getLeft();
		}
		return total;
	}
	
	/*
	*@returns returns the average amount of time a person was in line
	*/
	public int avgPersonTime(){
		int avgtime = 0;
		int thru = getTotalThru();
		System.out.println("thru: " + thru+ "  total tick time " + totalTickTime);
		avgtime = totalTickTime / thru;
		return avgtime;
	}
	
	public void transaction() throws EmptyQException{
		Person tempPer = new Person();
		try{
			if(cash.getFlag() == true){
				tempPer = line.deQ();
				//System.out.println("Size of line in the transactions: " + line.size());
				cash.setPerson(tempPer);
				totalTickTime = cash.getPersonTT();
				System.out.println("TotalTime: " + totalTickTime);
				/*if(cash.getFlag() == false){
					totalTickTime += tempPer.getTickTime();
					System.out.println("TotalTime: " + totalTickTime);
				}*/
			}
		}
		catch(EmptyQException e){
			//e.printStackTrace();
		}
	}
	
	public void addToLine(){
		for(Eatery e : eateryArr){
			if(e.getCurrentCompleted() != e.getThroughPut()){
				line.enQ(e.personGetter());
			}
		}
	}
	
	public static void main(String[] args){
		FCGUI f = new FCGUI();
		f.setVisible(true);
		clk.add(f);		
	}

	/* The first part may add someone to the line,
	* then it will try to perform a transaction.
	* Lastly, it will increment "next."
	* @param tick this is the amount of time that will pass
	* @throws EmptyQException this will be thrown when there is nobody in the Queue.
	*/
	public void event(int tick) {
		int next=0;
		if(tick > next){
			addToLine();
		
		try {
			transaction();
		} catch (EmptyQException e) {
			System.out.println("Main line is empty");
		}
		
		if(maxLength < line.size()){
			maxLength = line.size();
		}
		next++;
		}
	}
}
