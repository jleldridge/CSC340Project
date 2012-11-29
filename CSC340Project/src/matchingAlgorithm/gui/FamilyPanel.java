/**
 * FamilyPanel.java
 * Purpose: Holds the table of families to choose matches
 * 			for.
 * 
 * @author Jeffrey Eldridge
 * @version 1.0 11/28/2012
 */
package matchingAlgorithm.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;

public class FamilyPanel extends JPanel {
	JTable allFamilies;
	JScrollPane allFamiliesTable;
	String[] tableLabels = {"Name", "Address", "Language", "Ethnicity", "Children"};
	
	
	public FamilyPanel(ArrayList<Family> families, ActionListener listener){
		super();
		
		this.setLayout(new GridLayout(1, 1));
		
		//the family info in allFamilies
		Object[][] allFamiliesData = new Object[families.size()][5];
		
		for(int i = 0; i < families.size(); i++){
			Family f = families.get(i);
			allFamiliesData[i][0] = f.getName();
			allFamiliesData[i][1] = f.getAddress();
			allFamiliesData[i][2] = f.getLanguage();
			allFamiliesData[i][3] = f.getEthnicity();
			
			StringBuilder data = new StringBuilder();
			for(Child c : f.getChildren()){
				data.append(c.getName() + ":");
				for(String d : c.getDisabilities()){
					data.append(" " + d);
				}
				data.append("  ");
			}
			allFamiliesData[i][4] = data.toString();
		}
		
		//System.out.println("test content worked");
		
		//add the table
		allFamilies = new JTable(allFamiliesData, tableLabels);
		allFamiliesTable = new JScrollPane(allFamilies);
		this.add(allFamiliesTable);
	}
	
	public JTable getAllFamilies(){
		return allFamilies;
	}
}
