//package FoodCourt;
package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FCGUI extends JFrame{
	
	public FCGUI(){
	
	
	
	JPanel outInfoPanel = new JPanel();	
	outInfoPanel.setLayout(new GridLayout(0,2));
    
    JLabel through = new JLabel("Through put");
    JLabel avgTime = new JLabel("Average time for a person from start to finish");
    JLabel numberPeople = new JLabel("Number of people left in line");
    JLabel maxQ = new JLabel("Max Q length cashier line");
    
    JLabel throughInfo = new JLabel(" ");
    JLabel avgTimeInfo = new JLabel(" ");
    JLabel numberPeopleInfo = new JLabel(" ");
    JLabel maxQInfo = new JLabel(" ");
    
    outInfoPanel.add(through);
    outInfoPanel.add(throughInfo);
    outInfoPanel.add(avgTime);
    outInfoPanel.add(avgTimeInfo);
    outInfoPanel.add(numberPeople);
    outInfoPanel.add(numberPeopleInfo);
    outInfoPanel.add(maxQ);
    outInfoPanel.add(maxQInfo);
    
    mainLayout.add(outInfoPanel, BorderLayout.SOUTH);
	}

}
