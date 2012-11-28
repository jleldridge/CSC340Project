package matchingAlgorithm.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel {
	JCheckBox ethnicity, language, disability, distance, age, income;
	JTextField distanceDiff, ageDiff, incomeDiff;
	
	public ButtonPanel(ActionListener alistener, ItemListener ilistener){
		super();
		
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.setLayout(new GridBagLayout());
		this.setLayout(new GridLayout(6, 1));
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		ethnicity = new JCheckBox("Ethnicity");
		this.add(ethnicity);
		ethnicity.addItemListener(ilistener);
		
		c.gridx = 0;
		c.gridy = 1;
		language = new JCheckBox("Language");
		this.add(language);
		language.addItemListener(ilistener);
		
		c.gridx = 0;
		c.gridy = 2;
		disability = new JCheckBox("Disability");
		this.add(disability);
		disability.addItemListener(ilistener);
		
		c.gridx = 0;
		c.gridy = 3;
		JPanel distancePanel = new JPanel();
		distance = new JCheckBox("Distance (miles)");
		distancePanel.add(distance);
		distance.addItemListener(ilistener);
		c.gridx = 1;
		distanceDiff = new JTextField();
		distanceDiff.setPreferredSize(new Dimension(150, 20));
		distancePanel.add(distanceDiff);
		this.add(distancePanel);
		
		c.gridx = 0;
		c.gridy = 4;
		JPanel agePanel = new JPanel();
		age = new JCheckBox("Age Difference (of children)");
		agePanel.add(age);
		age.addItemListener(ilistener);
		c.gridx = 1;
		ageDiff = new JTextField();
		ageDiff.setPreferredSize(new Dimension(150, 20));
		agePanel.add(ageDiff);
		this.add(agePanel);
		
		JPanel incomePanel = new JPanel();
		c.gridx = 0;
		c.gridy = 5;
		income = new JCheckBox("Income Difference");
		incomePanel.add(income);
		income.addItemListener(ilistener);
		c.gridx = 1;
		incomeDiff = new JTextField();
		incomeDiff.setPreferredSize(new Dimension(150, 20));
		incomePanel.add(incomeDiff);
		this.add(incomePanel);
	}

	public JCheckBox getEthnicity() {
		return ethnicity;
	}

	public JCheckBox getLanguage() {
		return language;
	}

	public JCheckBox getDisability() {
		return disability;
	}

	public JCheckBox getDistance() {
		return distance;
	}

	public JCheckBox getAge() {
		return age;
	}

	public JCheckBox getIncome() {
		return income;
	}
	
	public double getDistanceDiff(){
		double x = 0.0;
		try{
			x = Double.parseDouble(distanceDiff.getText());
		}catch(Exception e){
			x = 0.0;
		}
		return x;
	}
	
	public int getIncomeDiff(){
		int x = 0;
		try{
			x = Integer.parseInt(incomeDiff.getText());
		}catch(Exception e){
			x = 0;
		}
		return x;
	}
	
	public int getAgeDiff(){
		int x = 0;
		try{
			x = Integer.parseInt(ageDiff.getText());
		}catch(Exception e){
			x = 0;
		}
		return x;
	}
}
