package matchingAlgorithm.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;

public class ResultsPanel extends JPanel{
	JTable matchingFamilies;
	JScrollPane matchingFamiliesTable;
	String[] tableLabels = {"Name", "Address", "Language", "Ethnicity", "Children"};
	
	public ResultsPanel(){
		super();
		
		matchingFamilies = new JTable();
		matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable);
		
	}
	
	public JTable getMatchingFamilies(){
		return matchingFamilies;
	}
	
	public void buildMatchTable(ArrayList<Family> matches){
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
				for(String d : c.getDisabilities()){
					data.append(" " + d);
				}
				data.append("  ");
			}
			matchingFamiliesData[i][4] = data.toString();
			
		}
		
		//recreate matchingFamilies table to contain matches for this family
		this.remove(matchingFamiliesTable);
		matchingFamilies = new JTable(matchingFamiliesData, tableLabels);
		
		//set the size of the columns
		matchingFamilies.getColumnModel().getColumn(0).setMinWidth(400);
		matchingFamilies.getColumnModel().getColumn(1).setMinWidth(400);
		
		matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable, BorderLayout.LINE_END);
		
		//display the new state of this JPanel
		this.revalidate();
		this.repaint();
	}

}
