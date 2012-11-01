package matchingAlgorithm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import matchingAlgorithm.Family;
import matchingAlgorithm.FamilyMatcher;
import matchingAlgorithm.ResultsPanel;

public class MatchingAlgorithmGui extends JFrame implements ActionListener, ItemListener{
	//plain java objects
	FamilyMatcher matcher;
	
	//gui components with their own JPanel implementations
	FamilyPanel familyTable;
	ButtonPanel criteria;
	ResultsPanel resultTable;
	
	//gui components added directly to the JFrame
	JLabel instructions;
	
	
	public MatchingAlgorithmGui(ArrayList<Family> families) {
		super("Family Matcher");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialize the JLabel that holds instruction text
		instructions = new JLabel("Pick a family to match.");
		this.add(instructions, BorderLayout.PAGE_START);
		
		// add the button container
		criteria = new ButtonPanel(this, this);
		this.add(criteria, BorderLayout.LINE_END);
		
		// add the table container
		familyTable = new FamilyPanel(families);
		this.add(familyTable, BorderLayout.LINE_START);
		
		//initialize the FamilyMatcher
		matcher = new FamilyMatcher(families);
		
		//initialize the result table
		resultTable = new ResultsPanel();
		
		setSize(800, 600);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if the "find matches" button is clicked, build the matches
		//table and display that panel.
		int row = familyTable.getAllFamilies().getSelectedRow();
		if(e.getActionCommand().equals("find matches") && row >= 0){
			Family f = matcher.getFamilies().get(row);
			resultTable.buildMatchTable(matcher.getPossibleMatches(f));
			
			//remove the family table panel from the JFrame
			this.remove(familyTable);
			
			//add the results table panel to the JFrame
			this.add(resultTable, BorderLayout.LINE_START);
			
			//repaint the JFrame
			this.validate();
			this.repaint();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		
		if(source == criteria.getEthnicity()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setEthnicity(true);
			}
			else{
				matcher.setEthnicity(false);
			}
		}
		else if(source == criteria.getLanguage()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setLanguage(true);
			}
			else{
				matcher.setLanguage(false);
			}
		}
		else if(source == criteria.getDisability()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setDisability(true);
			}
			else{
				matcher.setDisability(false);
			}
		}
		else if(source == criteria.getDistance()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setDistance(true);
			}
			else{
				matcher.setDistance(false);
			}
		}
		else if(source == criteria.getAge()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setAge(true);
			}
			else{
				matcher.setAge(false);
			}
		}
		else if(source == criteria.getIncome()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setIncome(true);
			}
			else{
				matcher.setIncome(false);
			}
		}
	}

}
