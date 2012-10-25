package matchingAlgorithm.gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import matchingAlgorithm.Family;
import matchingAlgorithm.FamilyMatcher;

public class MatchingAlgorithmGui extends JFrame{
	FamilyMatcher matcher;
	
	public MatchingAlgorithmGui(ArrayList<Family> families){
		super("Family Matcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		
		matcher = new FamilyMatcher(families);
	}
}
