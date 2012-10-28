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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import matchingAlgorithm.Family;
import matchingAlgorithm.FamilyMatcher;

public class MatchingAlgorithmGui extends JFrame implements ActionListener, ItemListener{
	FamilyPanel familyTables;
	ButtonPanel buttons;
	FamilyMatcher matcher;
	
	public MatchingAlgorithmGui(ArrayList<Family> families) {
		super("Family Matcher");
		
		// add the button container
		buttons = new ButtonPanel(this, this);
		this.add(buttons, BorderLayout.LINE_END);
		
		// add the table container
		familyTables = new FamilyPanel(families);
		this.add(familyTables, BorderLayout.LINE_START);
		
		//initialize the FamilyMatcher
		matcher = new FamilyMatcher(families);
		
		pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("find matches")){
			Family f = matcher.getFamilies().get(familyTables.getAllFamilies().getSelectedRow());
			familyTables.buildMatchTable(matcher.getPossibleMatches(f));
			this.repaint();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		
		if(source == buttons.getEthnicity()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setEthnicity(true);
			}
			else{
				matcher.setEthnicity(false);
			}
		}
		else if(source == buttons.getLanguage()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setLanguage(true);
			}
			else{
				matcher.setLanguage(false);
			}
		}
		else if(source == buttons.getDisability()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setDisability(true);
			}
			else{
				matcher.setDisability(false);
			}
		}
		else if(source == buttons.getDistance()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setDistance(true);
			}
			else{
				matcher.setDistance(false);
			}
		}
		else if(source == buttons.getAge()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setAge(true);
			}
			else{
				matcher.setAge(false);
			}
		}
		else if(source == buttons.getIncome()){
			if(e.getStateChange() == ItemEvent.SELECTED){
				matcher.setIncome(true);
			}
			else{
				matcher.setIncome(false);
			}
		}
	}

}
