package FoodCourt;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class FCGUI extends JFrame implements KeyEventDispatcher, ActionListener {
	
	  private static final long serialVersionUID = 1L;
	  private JPanel inInfo;
	  private JPanel button;
	  private JPanel outInfo;
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
	  private JLabel NELabel;
	  private JTextArea numEateries;
	  
	  private Sim S = new Sim();
			
	  public FCGUI(){
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
			BorderLayout mainLayout = new BorderLayout();
			this.setLayout(mainLayout);
	    
	    inInfo = new JPanel();
	    inInfo.setLayout(new GridLayout(0,2));
	    this.add(inInfo, BorderLayout.NORTH);
	    
	    STNLabel = new JLabel();
	    inInfo.add(STNLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
