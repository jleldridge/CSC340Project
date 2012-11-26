package matchingAlgorithm.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import matchingAlgorithm.Family;
import matchingAlgorithm.FamilyMatcher;

public class MatchingAlgorithmGui extends JFrame implements ActionListener,
		ItemListener {
	// plain java objects
	FamilyMatcher matcher;

	// the currently selected family
	Family selectedFamily;
	// index of the currently selected family in the table
	int selectedRow;

	// variable to hold the current screen state to determine what the
	// "Next" and "Previous" buttons do
	int currentScreen;

	// gui components with their own JPanel implementations
	FamilyPanel familyTable;
	ButtonPanel criteria;
	ResultsPanel resultTable;

	// gui components added directly to the JFrame
	JLabel instructions;
	JButton next;
	JButton previous;
	
	public MatchingAlgorithmGui(ArrayList<Family> families) {
		super("Family Matcher");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set currentScreen to 0 and build the first screen
		currentScreen = 0;

		// initialize the JLabel that holds instruction text
		instructions = new JLabel(
				"Pick a family to match and click the \"Next\" button.");
		this.add(instructions, BorderLayout.NORTH);

		// add the table container
		familyTable = new FamilyPanel(families);
		this.add(familyTable, BorderLayout.CENTER);

		// initialize the next and previous buttons
		next = new JButton("Next");
		next.setActionCommand("next");
		next.addActionListener(this);
		previous = new JButton("Previous");
		previous.setActionCommand("previous");
		previous.addActionListener(this);

		// add the next button to the window
		this.add(previous, BorderLayout.LINE_START);
		this.add(next, BorderLayout.LINE_END);

		// add the button container
		criteria = new ButtonPanel(this, this);
		// this.add(criteria, BorderLayout.EAST);

		// initialize the FamilyMatcher
		matcher = new FamilyMatcher(families);

		// initialize the result table
		resultTable = new ResultsPanel();
		setSize(800, 600);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if the "Next" button is pushed
		if (e.getActionCommand().equals("next")) {
			if (currentScreen < 2) {
				currentScreen++;
			}

			switch (currentScreen) {
			// advancing from picking family to showing criteria
			case 1:
				selectedRow = familyTable.getAllFamilies().getSelectedRow();
				// if a family has been selected then proceed to next screen
				if (selectedRow >= 0) {
					selectedFamily = matcher.getFamilies().get(selectedRow);

					// switch to next panel
					this.remove(familyTable);
					this.add(criteria, BorderLayout.CENTER);

					// change instructions
					instructions.setText("Select the criteria" +
							" by which this family will be matched with other families.");

					// repaint the JFrame
					this.validate();
					this.repaint();
				} else {
					// if no family was selected reset currentScreen to 0
					// maybe also add an alert pop-up box here
					currentScreen = 0;
				}
				break;

			// advancing from showing criteria to showing matches
			case 2:
				if(matcher.isAge()){
					matcher.setAgeDiff(criteria.getAgeDiff());
				}
				if(matcher.isDistance()){
					matcher.setDistanceDiff(criteria.getDistanceDiff());
				}
				if(matcher.isIncome()){
					matcher.setIncomeDiff(criteria.getDistanceDiff());
				}
				
				resultTable.buildMatchTable(matcher
						.getPossibleMatches(selectedFamily));

				// switch to next panel
				this.remove(criteria);
				this.add(resultTable, BorderLayout.CENTER);
				
				//change the instructions
				instructions.setText("Pick a family to match with the "
						+ selectedFamily.getName() + " family.");

				// repaint the JFrame
				this.validate();
				this.repaint();

				break;
			}
		}

		// if the previous button is pressed
		if (e.getActionCommand().equals("previous")) {
			if (currentScreen > 0) {
				currentScreen--;
			}

			switch (currentScreen) {
			// transition from results back to criteria
			case 1:
				// switch to previous panel
				this.remove(resultTable);
				this.add(criteria, BorderLayout.CENTER);
				
				// change instructions
				instructions.setText("Select the criteria" +
						" by which this family will be matched with other families.");
				
				// repaint the JFrame
				this.validate();
				this.repaint();

				break;
			// transition from criteria back to family select
			case 0:
				// switch to previous panel
				this.remove(criteria);
				this.add(familyTable, BorderLayout.CENTER);
				
				//change the instructions
				instructions.setText("Pick a family to match and click the \"Next\" button.");

				// repaint the JFrame
				this.validate();
				this.repaint();

				break;
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();

		// change state of matcher criteria based on state of checkboxes in GUI
		if (source == criteria.getEthnicity()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				matcher.setEthnicity(true);
			} else {
				matcher.setEthnicity(false);
			}
		} else if (source == criteria.getLanguage()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				matcher.setLanguage(true);
			} else {
				matcher.setLanguage(false);
			}
		} else if (source == criteria.getDisability()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				matcher.setDisability(true);
			} else {
				matcher.setDisability(false);
			}
		} else if (source == criteria.getDistance()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				matcher.setDistance(true);
			} else {
				matcher.setDistance(false);
			}
		} else if (source == criteria.getAge()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				matcher.setAge(true);
			} else {
				matcher.setAge(false);
			}
		} else if (source == criteria.getIncome()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				matcher.setIncome(true);
			} else {
				matcher.setIncome(false);
			}
		}
	}

}
