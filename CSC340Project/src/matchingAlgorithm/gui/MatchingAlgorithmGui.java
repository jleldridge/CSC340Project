package matchingAlgorithm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import matchingAlgorithm.Family;
import matchingAlgorithm.FamilyMatcher;

public class MatchingAlgorithmGui extends JFrame implements ActionListener {
	JPanel familyTables;
	JPanel buttons;

	public MatchingAlgorithmGui(ArrayList<Family> families) {
		super("Family Matcher");

		// add the button container
		buttons = new ButtonPanel(this);
		this.add(buttons, BorderLayout.LINE_END);
		
		// add the table container
		familyTables = new FamilyPanel(families);
		this.add(familyTables, BorderLayout.LINE_START);
		
		pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
