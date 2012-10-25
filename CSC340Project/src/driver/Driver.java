package driver;
import java.util.ArrayList;
import java.util.Date;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;
import matchingAlgorithm.gui.*;
public class Driver {
	public static void main(String[] args){
		ArrayList<Family> families = new ArrayList<Family>();
		ArrayList<Child> children = new ArrayList<Child>();
		ArrayList<String> disabilities = new ArrayList<String>();
		disabilities.add("Dyslexia");
		children.add(new Child("Billy", 10, disabilities, "male"));
		
		families.add(new Family("Smith", "5301 Turner Smith Road, Browns Summit, NC; 27214", children, new Date(), "English", false));
		new MatchingAlgorithmGui(families);
	}
}
