package matchingAlgorithm.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	JButton findMatches;
	
	public ButtonPanel(ActionListener listener){
		super();
		
		findMatches = new JButton("Find Matches");
		findMatches.setActionCommand("find matches");
		
		this.add(findMatches, BorderLayout.LINE_START);
	}
}
