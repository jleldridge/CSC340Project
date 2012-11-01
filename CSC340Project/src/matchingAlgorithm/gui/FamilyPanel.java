package matchingAlgorithm.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;

public class FamilyPanel extends JPanel {
	JTable allFamilies;
	JTable matchingFamilies;
	String[] tableLabels = {"Name", "Address", "Language", "Ethnicity", "Children"};
	
	public FamilyPanel(ArrayList<Family> families){
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
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
		
		allFamilies = new JTable(allFamiliesData, tableLabels);
		JScrollPane allFamiliesTable = new JScrollPane(allFamilies);
		this.add(allFamiliesTable, this);
	}
	
	public JTable getAllFamilies(){
		return allFamilies;
	}
}
