package matchingAlgorithm.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;

public class FamilyPanel extends JPanel {
	JTable allFamilies;
	JScrollPane allFamiliesTable;
	JButton viewInfo;
	String[] tableLabels = {"Name", "Address", "Language", "Ethnicity", "Children"};
	
	
	public FamilyPanel(ArrayList<Family> families, ActionListener listener){
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
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
		this.add(allFamiliesTable, this);
		
		//add the viewInfo button
		viewInfo = new JButton("View Selected Family Info");
		viewInfo.setActionCommand("viewInfo");
		viewInfo.addActionListener(listener);
		this.add(viewInfo, this);
	}
	
	public JTable getAllFamilies(){
		return allFamilies;
	}
}
