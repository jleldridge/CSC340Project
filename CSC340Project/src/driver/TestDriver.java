package driver;
import java.util.ArrayList;
import java.util.Date;

import matchingAlgorithm.Child;
import matchingAlgorithm.Family;
import matchingAlgorithm.FamilyMatcher;
import matchingAlgorithm.gui.*;
public class TestDriver {
	public static void main(String[] args){
		ArrayList<Family> families = new ArrayList<Family>();
		ArrayList<Child> children = new ArrayList<Child>();
		ArrayList<String> disabilities = new ArrayList<String>();
		disabilities.add("MS");
		children.add(new Child("Billy", 10, disabilities, "male"));
		
		families.add(new Family("Smith", "5301 Turner Smith Road, Browns Summit, NC; 27214", children, new Date(), "English", false));
		families.get(0).setEthnicity("Black");
		
		families.add(new Family("Lars", "5303 Turner Smith Road, Browns Summit, NC; 27214", children, new Date(), "English", false));
		families.get(1).setEthnicity("White");
		
		disabilities = new ArrayList<String>();
		disabilities.add("ADHD");
		children = new ArrayList<Child>();
		children.add(new Child ("Sam", 13, disabilities, "male"));
		
		families.add(new Family("Potter", "5301 Jasper Smith Road, Browns Summit, NC; 27214", children, new Date(), "English", false));
		families.get(2).setEthnicity("Hispanic");
		
		children = new ArrayList<Child>();
		disabilities = new ArrayList<String>();
		disabilities.add("MS");
		children.add(new Child("Tom", 10, disabilities, "male"));
		disabilities = new ArrayList<String>();
		disabilities.add("ADHD");
		children.add(new Child ("Jane", 13, disabilities, "female"));
		families.add(new Family("Garcia", "5301 Harper Smith Road, Browns Summit, NC; 27214", children, new Date(), "Spanish", false));
		families.get(3).setEthnicity("Hispanic");
		
		families.add(new Family("Stark", "5301 some other Road, Browns Summit, NC; 27214", children, new Date(), "Spanish", false));
		families.get(4).setEthnicity("Asian");
		
		
		
		
		
		
		
		
		//create gui
		new MatchingAlgorithmGui(families);
	}
}
