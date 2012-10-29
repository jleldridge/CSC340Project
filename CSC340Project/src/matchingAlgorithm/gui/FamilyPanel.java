package matchingAlgorithm.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;

public class FamilyPanel extends JPanel {
	JTable allFamilies;
	JTable matchingFamilies;
	JScrollPane matchingFamiliesTable;
	String[] tableLabels = {"Name", "Address", "Date Joined", "Language", "Ethnicity", "Children", "Matched"};
	
	public FamilyPanel(ArrayList<Family> families){
		super();
		
		//the family info in allFamilies
		Object[][] allFamiliesData = new Object[families.size()][7];
		
		for(int i = 0; i < families.size(); i++){
			Family f = families.get(i);
			allFamiliesData[i][0] = f.getName();
			allFamiliesData[i][1] = f.getAddress();
			allFamiliesData[i][2] = f.getDateJoined();
			allFamiliesData[i][3] = f.getLanguage();
			allFamiliesData[i][4] = f.getEthnicity();
			
			StringBuilder data = new StringBuilder();
			for(Child c : f.getChildren()){
				data.append(c.getName() + ":");
				for(String d : c.getDisabilities()){
					data.append(" " + d);
				}
			}
			allFamiliesData[i][5] = data.toString();
			
			allFamiliesData[i][6] = f.isMatched();
		}
		
		//System.out.println("test content worked");
		
		allFamilies = new JTable(allFamiliesData, tableLabels);
		JScrollPane allFamiliesTable = new JScrollPane(allFamilies);
		this.add(allFamiliesTable, BorderLayout.LINE_START);
		
		//System.out.println("created first table");
		
		matchingFamilies = new JTable();
		matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable, BorderLayout.LINE_END);
		
		//System.out.println("created second table");
	}
	
	public JTable getAllFamilies(){
		return allFamilies;
	}
	
	public JTable getMatchingFamilies(){
		return matchingFamilies;
	}
	
	public void buildMatchTable(ArrayList<Family> matches){
		Object[][] matchingFamiliesData = new Object[matches.size()][7];
		for(int i = 0; i < matches.size(); i++){
			Family f = matches.get(i);
			matchingFamiliesData[i][0] = f.getName();
			matchingFamiliesData[i][1] = f.getAddress();
			matchingFamiliesData[i][2] = f.getDateJoined();
			matchingFamiliesData[i][3] = f.getLanguage();
			matchingFamiliesData[i][4] = f.getEthnicity();
			
			StringBuilder data = new StringBuilder();
			for(Child c : f.getChildren()){
				data.append(c.getName() + ":");
				for(String d : c.getDisabilities()){
					data.append(" " + d);
				}
			}
			matchingFamiliesData[i][5] = data.toString();
			
			matchingFamiliesData[i][6] = f.isMatched();
		}
		
		//recreate matchingFamilies table to contain matches for this family
		this.remove(matchingFamiliesTable);
		matchingFamilies = new JTable(matchingFamiliesData, tableLabels);
		matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable, BorderLayout.LINE_END);
		
		//display the new state of this JPanel
		this.revalidate();
		this.repaint();
	}
}
