package FoodCourt;

import java.awt.*;

import javax.swing.*;

import FrontEnd.Clock;
import FrontEnd.Eatery;
import FrontEnd.PersonProducer;
import FrontEnd.Sim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*@author JMONEY, Jake Cousino, Tim Irish
*/

public class FCGUI extends JFrame implements ActionListener {
	
	  private static final long serialVersionUID = 1L;
	  private JPanel inInfoPanel;
	  private JPanel buttonPanel;
	  private JPanel outInfoPanel;
	  private JLabel Title;
	  private JLabel blank;
	  private JLabel STNLabel;
	  private JTextArea secToNext;
	  private JLabel SPCLabel;
	  private JTextArea secPerCashier;
	  private JLabel TTLabel;
	  private JTextArea totalTime;
	  private JLabel SPELabel;
	  private JTextArea secPerEatery;
	  private JLabel SBLLAbel;
	  private JTextArea secBeforeLeave;
	  private JLabel NELabel, throughInfo, avgTimeInfo, numberPeopleInfo, maxQInfo;
	  private JTextArea numEateries;
	  private JButton starter;
	  private JButton quitter;
	  public int secToNextI, secPerCashierI, totalTimeI, secPerEateryI, secBeforeLeaveI, numEateriesI;
	  
	  private Sim S = new Sim();
			
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
	    
	    Title = new JLabel("Input Information");
	    Title.setFont(myText);
	    inInfoPanel.add(Title);
	    
	    blank = new JLabel("");
	    inInfoPanel.add(blank);
	    
	    STNLabel = new JLabel("Seconds to the Next Person");
	    inInfoPanel.add(STNLabel);
	    
	    secToNext = new JTextArea();
	    secToNext.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secToNext);
	    
	    SPCLabel = new JLabel("Seconds per Cashier");
	    inInfoPanel.add(SPCLabel);
	    
	    secPerCashier = new JTextArea();
	    secPerCashier.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secPerCashier);
	    
	    TTLabel = new JLabel("Total Time");
	    inInfoPanel.add(TTLabel);
	    
	    totalTime = new JTextArea();
	    totalTime.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(totalTime);
	    
	    SPELabel = new JLabel("Seconds per Eatery");
	    inInfoPanel.add(SPELabel);
	    
	    secPerEatery = new JTextArea();
	    secPerEatery.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secPerEatery);
	    
	    SBLLAbel = new JLabel("Seconds Before Someone Leaves");
	    inInfoPanel.add(SBLLAbel);
	    
	    secBeforeLeave = new JTextArea();
	    secBeforeLeave.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secBeforeLeave);
	    
	    NELabel = new JLabel("Number of Eateries");
	    inInfoPanel.add(NELabel);
	    
	    numEateries = new JTextArea();
	    numEateries.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(numEateries);
	    
	    buttonPanel = new JPanel();
	    this.add(buttonPanel,BorderLayout.CENTER);
	    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
	    buttonPanel.setLayout(new GridLayout(0,2));

	      //Jmoney: might have to add actionListeners for my buttons.
	      starter = new JButton("Start da Sim!");
	      quitter = new JButton("Quit da Sim!");
	     
	      starter.addActionListener(this);
	      quitter.addActionListener(this);
	     Dimension d = new Dimension(40, 40);
	     starter.setPreferredSize(d);
	     quitter.setPreferredSize(d);
	     
	     buttonPanel.add(starter);
	     buttonPanel.add(quitter);
	     
	    
	    
	    
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		
	}

	
	public void runSim(int secToNextI, int secPerCashierI, int totalTimeI, int secPerEateryI, int secBeforeLeaveI, int numEateriesI){
		
		
		Clock clk = new Clock();
		clk.run(100000);
		int through;
		/*Eatery booth = new Eatery();
		
		PersonProducer produce = new PersonProducer(booth, 20, 18);	
		
		clk.add(produce);
		clk.add(booth);
		
		clk.run(100000);
		
		throughInfo.setText("Through put is: " + booth.getThroughPut() + " people.");
		
		//System.out.println("Through put is: " + booth.getThroughPut() + " people.");
		System.out.println("People that are still in the Q:" + booth.getLeft() + " people.");
		System.out.println ("Max Q length:" + booth.getMaxQlength() + " people.");
		*/
		
		for(int i = 0; i < numEateriesI; i++){
			Eatery Ex = new Eatery();
			PersonProducer produce = new PersonProducer(Ex, secToNextI, secPerEateryI);
			clk.add(produce);
			clk.add(Ex);
			
			//through += Ex.getThroughPut();
		}
		
		clk.run(totalTimeI);
			
		
	}
	
	public static void main(String[] args){
		FCGUI f = new FCGUI();
		f.setVisible(true);
	}
}

=======
package FoodCourt;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FCGUI extends JFrame implements ActionListener {
	
	  private static final long serialVersionUID = 1L;
	  private JPanel inInfoPanel, buttonPanel, outInfoPanel;
	  private JLabel Title, blank, STNLabel, SPCLabel, TTLabel; 
	  private JLabel SPELabel, SBLLAbel, NELabel;
	  private JTextArea secToNext, secPerCashier, totalTime, secPerEatery;
	  private JTextArea secBeforeLeave, numEateries;
	  private JButton starter;
	  private JButton quitter;
	  public int secToNextI, secPerCashierI, totalTimeI;
	  public int secPerEateryI, secBeforeLeaveI, numEateriesI;
	   
			
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
	    
	    Title = new JLabel("Input Information");
	    Title.setFont(myText);
	    inInfoPanel.add(Title);
	    
	    blank = new JLabel("");
	    inInfoPanel.add(blank);
	    
	    STNLabel = new JLabel("Seconds to the Next Person");
	    inInfoPanel.add(STNLabel);
	    
	    secToNext = new JTextArea();
	    secToNext.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secToNext);
	    
	    SPCLabel = new JLabel("Seconds per Cashier");
	    inInfoPanel.add(SPCLabel);
	    
	    secPerCashier = new JTextArea();
	    secPerCashier.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secPerCashier);
	    
	    TTLabel = new JLabel("Total Time");
	    inInfoPanel.add(TTLabel);
	    
	    totalTime = new JTextArea();
	    totalTime.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(totalTime);
	    
	    SPELabel = new JLabel("Seconds per Eatery");
	    inInfoPanel.add(SPELabel);
	    
	    secPerEatery = new JTextArea();
	    secPerEatery.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secPerEatery);
	    
	    SBLLAbel = new JLabel("Seconds Before Someone Leaves");
	    inInfoPanel.add(SBLLAbel);
	    
	    secBeforeLeave = new JTextArea();
	    secBeforeLeave.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(secBeforeLeave);
	    
	    NELabel = new JLabel("Number of Eateries");
	    inInfoPanel.add(NELabel);
	    
	    numEateries = new JTextArea();
	    numEateries.setBorder(BorderFactory.createLineBorder(Color.black));
	    inInfoPanel.add(numEateries);
	    
	    buttonPanel = new JPanel();
	    this.add(buttonPanel,BorderLayout.CENTER);
	    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
	    buttonPanel.setLayout(new GridLayout(0,2));

	      //Jmoney: might have to add actionListeners for my buttons.
	      starter = new JButton("Start da Sim!");
	      quitter = new JButton("Quit da Sim!");
	      starter.addActionListener(this);
	      quitter.addActionListener(this);
		
	     
	     Dimension d = new Dimension(40, 40);
	     starter.setPreferredSize(d);
	     quitter.setPreferredSize(d);
	     
	     buttonPanel.add(starter);
	     buttonPanel.add(quitter);
	    
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
	    
	    JLabel throughInfo = new JLabel(" ");
	    JLabel avgTimeInfo = new JLabel(" ");
	    JLabel numberPeopleInfo = new JLabel(" ");
	    JLabel maxQInfo = new JLabel(" ");
	    
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == starter)
		secToNextI = Integer.parseInt(secToNext.getText());
		secPerCashierI = Integer.parseInt(secPerCashier.getText());
		totalTimeI = Integer.parseInt(totalTime.getText());
		secPerEateryI = Integer.parseInt(secPerEatery.getText());
		secBeforeLeaveI = Integer.parseInt(secBeforeLeave.getText());
		numEateriesI = Integer.parseInt(numEateries.getText());
		
		runSim(secToNextI, secPerCashierI, totalTimeI, secPerEateryI, 
		secBeforeLeaveI, numEateriesI);
		
	public void runSim(int secToNextI, int secPerCashierI, int totalTimeI, int secPerEateryI, int secBeforeLeaveI, int numEateriesI){
  		Clock clk = new Clock();
  		Eatery booth = new Eatery();

  		PersonProducer produce = new PersonProducer(booth, 20, 18);	

  		clk.add(produce);
  		clk.add(booth);

  		clk.run(100000);

  		System.out.println("Through put is: " + booth.getThroughPut() + " people.");
  		System.out.println("People that are still in the Q:" + booth.getLeft() + " people.");
  		System.out.println ("Max Q length:" + booth.getMaxQlength() + " people.");
}
		
		
	}
	
	public static void main(String[] args){
		FCGUI f = new FCGUI();
		f.setVisible(true);
	}

	
}

>>>>>>> master
