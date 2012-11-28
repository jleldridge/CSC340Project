package matchingAlgorithm.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel {
	JCheckBox ethnicity, language, disability, distance, age, income;
	JTextField distanceDiff, ageDiff, incomeDiff;
	
	public ButtonPanel(ActionListener alistener, ItemListener ilistener){
		super();
		
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		ethnicity = new JCheckBox("Ethnicity");
		this.add(ethnicity, c);
		ethnicity.addItemListener(ilistener);
		
		c.gridx = 0;
		c.gridy = 1;
		language = new JCheckBox("Language");
		this.add(language, c);
		language.addItemListener(ilistener);
		
		c.gridx = 0;
		c.gridy = 2;
		disability = new JCheckBox("Disability");
		this.add(disability, c);
		disability.addItemListener(ilistener);
		
		c.gridx = 0;
		c.gridy = 3;
		distance = new JCheckBox("Distance (miles)");
		this.add(distance, c);
		distance.addItemListener(ilistener);
		
		c.gridx = 1;
		distanceDiff = new JTextField();
		distanceDiff.setPreferredSize(new Dimension(150, 20));
		this.add(distanceDiff, c);
		
		c.gridx = 0;
		c.gridy = 4;
		age = new JCheckBox("Age Difference (of children)");
		this.add(age, c);
		age.addItemListener(ilistener);
		
		c.gridx = 1;
		ageDiff = new JTextField();
		ageDiff.setPreferredSize(new Dimension(150, 20));
		this.add(ageDiff, c);
		
		c.gridx = 0;
		c.gridy = 5;
		income = new JCheckBox("Income Difference");
		this.add(income, c);
		income.addItemListener(ilistener);
		
		c.gridx = 1;
		incomeDiff = new JTextField();
		incomeDiff.setPreferredSize(new Dimension(150, 20));
		this.add(incomeDiff, c);
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
	
	public int getDistanceDiff(){
		int x = 0;
		try{
			x = Integer.parseInt(distanceDiff.getText());
		}catch(Exception e){
			x = 0;
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
