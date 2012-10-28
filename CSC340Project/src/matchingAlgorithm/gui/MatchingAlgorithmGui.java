package matchingAlgorithm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import matchingAlgorithm.Family;
import matchingAlgorithm.FamilyMatcher;

public class MatchingAlgorithmGui extends JFrame implements ActionListener{
	FamilyMatcher matcher;
	JTable familyTable;
	JButton findMatches;
	
	public MatchingAlgorithmGui(ArrayList<Family> families){
		super("Family Matcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		
		matcher = new FamilyMatcher(families);
		String[] columnNames = {"Name", "Address", "Date Joined", "Language", "Ethnicity", "Income", "Children"};
		//create an array to hold the table data
		Object[][] data = new Object[matcher.getFamilies().size()][7];
		//populate the array with family data
		for(int i = 0; i < data.length; i++){
			Family f = matcher.getFamilies().get(i);
			data[i][0] = f.getName();
			data[i][1] = f.getAddress();
			data[i][2] = f.getDateJoined();
			data[i][3] = f.getLanguage();
			data[i][4] = f.getEthnicity();
			data[i][5] =f.getIncome();
			data[i][6] = f.getChildren();
		}
		
		//create a table of families and display it
		familyTable = new JTable(data, columnNames);
		setLayout(new GridBagLayout());
		//add(familyTable.getTableHeader());
		add(familyTable);
		
		findMatches = new JButton("Find Matches");
		findMatches.setActionCommand("find matches");
		add(findMatches);
	}
	
	private void rebuildTable(ArrayList<Family> families){
		String[] columnNames = {"Name", "Address", "Date Joined", "Language", "Ethnicity", "Income", "Children"};
		//create an array to hold the table data
		Object[][] data = new Object[families.size()][7];
		//populate the array with family data
		for(int i = 0; i < data.length; i++){
			Family f = families.get(i);
			data[i][0] = f.getName();
			data[i][1] = f.getAddress();
			data[i][2] = f.getDateJoined();
			data[i][3] = f.getLanguage();
			data[i][4] = f.getEthnicity();
			data[i][5] =f.getIncome();
			data[i][6] = f.getChildren();
		}
		
		//create a table of families and display it
		familyTable = new JTable(data, columnNames);
		//add(familyTable.getTableHeader());
		add(familyTable);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(findMatches.getActionCommand())){
			//find matches for selected family
			ArrayList<Family> matches = matcher.getPossibleMatches(matcher.getFamilies().get(familyTable.getSelectedRow()));
		}
	}
	
	
}
