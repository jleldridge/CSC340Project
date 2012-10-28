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
		disabilities.add("Dyslexia");
		children.add(new Child("Billy", 10, disabilities, "male"));
		
		families.add(new Family("Smith", "5301 Turner Smith Road, Browns Summit, NC; 27214", children, new Date(), "English", false));
		families.add(new Family("Lars", "5303 Turner Smith Road, Browns Summit, NC; 27214", children, new Date(), "English", false));
		
		disabilities = new ArrayList<String>();
		disabilities.add("ADHD");
		children = new ArrayList<Child>();
		children.add(new Child ("Sam", 13, disabilities, "male"));
		families.add(new Family("Potter", "5301 Jasper Smith Road, Browns Summit, NC; 27214", children, new Date(), "English", false));
		families.add(new Family("Garcia", "5301 Harper Smith Road, Browns Summit, NC; 27214", children, new Date(), "Spanish", false));
		families.add(new Family("Stark", "5301 some other Road, Browns Summit, NC; 27214", children, new Date(), "Spanish", false));
		FamilyMatcher matcher = new FamilyMatcher(families);
		matcher.setDisability(true); matcher.setLanguage(true);
		
		for(Family f : families){
			System.out.println(f.getName());
		}
		
		System.out.println();
		System.out.println("Matches for Smiths");
		for(Family f : matcher.getPossibleMatches(families.get(0))){
			System.out.println(f.getName());
		}
		
		System.out.println();
		System.out.println("Matches for Garcias");
		for(Family f : matcher.getPossibleMatches(families.get(3))){
			System.out.println(f.getName());
		}
		
		System.out.println();
		System.out.println("Matches for Lars");
		for(Family f : matcher.getPossibleMatches(families.get(1))){
			System.out.println(f.getName());
		}
		
		//create gui
		new MatchingAlgorithmGui(families);
		
	}
}
