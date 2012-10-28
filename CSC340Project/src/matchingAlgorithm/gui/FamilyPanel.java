package matchingAlgorithm.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

import matchingAlgorithm.Family;

public class FamilyPanel extends JPanel {
	JTable allFamilies;
	JTable matchingFamilies;
	
	public FamilyPanel(ArrayList<Family> families){
		super();
		
		//the table labels for both families
		String[] tableLabels = {"Name", "Address", "Date Joined", "Language", "Children", "Matched"};
		
		//the family info in allFamilies
		Object[][] allFamiliesData = new Object[families.size()][6];
		
		for(int i = 0; i < families.size(); i++){
			Family f = families.get(i);
			allFamiliesData[i][0] = f.getName();
			allFamiliesData[i][1] = f.getAddress();
			allFamiliesData[i][2] = f.getDateJoined();
			allFamiliesData[i][3] = f.getLanguage();
			allFamiliesData[i][4] = f.getChildren();
			allFamiliesData[i][5] = f.isMatched();
			//System.out.println(i + " worked");
		}
		
		//for testing remove later
		Object[][] test2Content = {{"test2", "test2","test2","test2","test2","test2",}};
		
		//System.out.println("test content worked");
		
		allFamilies = new JTable(allFamiliesData, tableLabels);
		JScrollPane allFamiliesTable = new JScrollPane(allFamilies);
		this.add(allFamiliesTable, BorderLayout.LINE_START);
		
		//System.out.println("created first table");
		
		matchingFamilies = new JTable(test2Content, tableLabels);
		JScrollPane matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable, BorderLayout.LINE_END);
		
		//System.out.println("created second table");
	}
}
