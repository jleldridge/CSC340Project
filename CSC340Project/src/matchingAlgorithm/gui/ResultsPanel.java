/**
 * ResultsPanel.java
 * Purpose: Holds the table of families that match the
 * 			selected family based on the selected criteria.
 * 
 * @author Jeffrey Eldridge
 * @version 1.0 11/28/2012
 */
package matchingAlgorithm.gui;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;

public class ResultsPanel extends JPanel{
	JTable matchingFamilies;
	ArrayList<Family> matches;
	JScrollPane matchingFamiliesTable;
	String[] tableLabels = {"Name", "Address", "Language", "Ethnicity", "Children"};
	
	public ResultsPanel(ActionListener listener){
		super();
		
		this.setLayout(new GridLayout(1, 1));
		
		matchingFamilies = new JTable();
		matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable);
	}
	
	public JTable getMatchingFamilies(){
		return matchingFamilies;
	}
	
	public ArrayList<Family> getMatches(){
		return matches;
	}
	
	public void buildMatchTable(ArrayList<Family> matches){
		this.matches = matches;
		Object[][] matchingFamiliesData = new Object[matches.size()][5];
		for(int i = 0; i < matches.size(); i++){
			Family f = matches.get(i);
			matchingFamiliesData[i][0] = f.getName();
			matchingFamiliesData[i][1] = f.getAddress();
			matchingFamiliesData[i][2] = f.getLanguage();
			matchingFamiliesData[i][3] = f.getEthnicity();
			
			StringBuilder data = new StringBuilder();
			for(Child c : f.getChildren()){
				data.append(c.getName() + ":");
				data.append(c.getDisabilities());
				data.append("  ");
			}
			matchingFamiliesData[i][4] = data.toString();
			
		}
		
		//recreate matchingFamilies table to contain matches for this family
		this.remove(matchingFamiliesTable);
		matchingFamilies = new JTable(matchingFamiliesData, tableLabels);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable, gbc);
		
		//display the new state of this JPanel
		this.revalidate();
		this.repaint();
	}

}
