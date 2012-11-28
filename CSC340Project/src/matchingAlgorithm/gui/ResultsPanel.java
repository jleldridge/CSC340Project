package matchingAlgorithm.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;

public class ResultsPanel extends JPanel{
	JTable matchingFamilies;
	JButton viewInfo;
	ArrayList<Family> matches;
	JScrollPane matchingFamiliesTable;
	String[] tableLabels = {"Name", "Address", "Language", "Ethnicity", "Children"};
	
	public ResultsPanel(ActionListener listener){
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		matchingFamilies = new JTable();
		matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable, this);
		
		viewInfo = new JButton("View Selected Family Info");
		viewInfo.setActionCommand("viewInfo");
		viewInfo.addActionListener(listener);
		this.add(viewInfo, this);
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
		
		matchingFamiliesTable = new JScrollPane(matchingFamilies);
		this.add(matchingFamiliesTable, this);
		
		//display the new state of this JPanel
		this.revalidate();
		this.repaint();
	}

}
