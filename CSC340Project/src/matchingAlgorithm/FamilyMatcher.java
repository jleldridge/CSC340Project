/**
 * FamilyMatcher.java
 * Purpose: Maintains lists of Families and matched Families,
 * 			filters possible matches for families, and creates
 * 			and destroys matches between Families.
 * 
 * @author Jeffrey Eldridge
 * @version 1.0 11/28/2012
 */
package matchingAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyMatcher {
	// when narrowing down matches, do the faster criteria checks first,
	// so that we're doing the fast operations on larger data sets and the
	// slow operations on smaller data sets
	
	//collection to hold all families
	private ArrayList<Family> families;
	//collection to hold all current matches between families
	private ArrayList<ArrayList<Family>> matches;
	//flags for checking which criteria to consider when matching
	private boolean ethnicity, language, disability, distance, age, income;
	//values to consider if matching by distance, age, or income
	private int ageDiff=0, incomeDiff=0;
	private double distanceDiff=0;
	
	public FamilyMatcher(ArrayList<Family> families, ArrayList<ArrayList<Family>> matches) {
		this.families = families;
		this.matches = matches;
	}
	
	public boolean createMatch(Family f1, Family f2){
		//make sure the families aren't already matched
		for(ArrayList<Family> arr : matches){
			if(arr.contains(f1) || arr.contains(f2)){
				return false;
			}
		}
		ArrayList<Family> match = new ArrayList<Family>();
		match.add(f1);
		match.add(f2);
		matches.add(match);
		
		return true;
	}
	
	public boolean breakMatch(Family f){
		
		Iterator<ArrayList<Family>> iter = matches.iterator();
		while(iter.hasNext()){
			ArrayList<Family> arr = iter.next();
			if(arr.contains(f)){
				iter.remove();
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Family> getPossibleMatches(Family f) {
		// add all families to the possible matches to start
		ArrayList<Family> possibleMatches = new ArrayList<>(families);
		// remove the family we are finding matches for
		possibleMatches.remove(f);

		// check which criteria to base match narrowing on
		// then for each criteria we care about, if the criteria is not
		// met by the family, remove it from the list of possible matches
		if (ethnicity) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				Family pf = iter.next();
				if(!pf.getEthnicity().equalsIgnoreCase(f.getEthnicity())){
					iter.remove();
				}
			}
		}
		if (language) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				Family pf = iter.next();
				if(!pf.getLanguage().equalsIgnoreCase(f.getLanguage())){
					iter.remove();
				}
			}
		}
		if (age) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				//flag telling if this is a possible matching family
				boolean possibleMatch = false;
				
				Family pf = iter.next();
				Iterator<Child> fciter = f.getChildren().iterator();
				
				while(fciter.hasNext()){
					Child fc = fciter.next();
					Iterator<Child> pfciter = pf.getChildren().iterator();
					while(pfciter.hasNext()){
						Child pfc = pfciter.next();
						if(Math.abs(pfc.getAge() - fc.getAge()) <= ageDiff){
							//set flag to true
							possibleMatch = true;
						}
					}
				}
				
				if(!possibleMatch){
					iter.remove();
				}
			}
		}
		if (income) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				Family pf = iter.next();
				//if the income difference between the families is higher than
				//desired, they cannot be matched
				if(!(f.getIncome().equals(pf.getIncome()))){
					iter.remove();
				}
			}
		}
		if (disability) {
			//keep track of the number of children between the families that have
			//the same disabilities
			boolean matchingChildren = false;
			Iterator<Family> iter = possibleMatches.iterator();
			
			while(iter.hasNext()){
				Family pf = iter.next();
				for(Child c : f.getChildren()){
					for(Child pc : pf.getChildren()){
						if(c.getDisabilities().equals(pc.getDisabilities())){
							matchingChildren = true;
						}
					}
				}
				if(!matchingChildren){
					iter.remove();
				}
			matchingChildren = false;
			}
		}
		if (distance) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				Family pf = iter.next();
				double distance;
				String origin = f.getAddress().replace(' ', '+');
				String destination = pf.getAddress().replace(' ', '+');
				String distanceStr;
				try{
					distanceStr = Distance.getDistance(origin, destination);
				}catch(Exception e){
					distanceStr = "0";
				}
				//remove the unit characters from the string so that only
				//the numbers remain
				distanceStr = distanceStr.replaceAll("[^\\d.]", "");
				
				distance = Double.parseDouble(distanceStr);
				if(distance > distanceDiff){
					iter.remove();
				}
			}
		}

		return possibleMatches;
	}
	

	public boolean isEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(boolean ethnicity) {
		this.ethnicity = ethnicity;
	}

	public boolean isLanguage() {
		return language;
	}

	public void setLanguage(boolean language) {
		this.language = language;
	}

	public boolean isDisability() {
		return disability;
	}

	public void setDisability(boolean disability) {
		this.disability = disability;
	}

	public boolean isDistance() {
		return distance;
	}

	public void setDistance(boolean distance) {
		this.distance = distance;
	}

	public boolean isAge() {
		return age;
	}

	public void setAge(boolean age) {
		this.age = age;
	}

	public boolean isIncome() {
		return income;
	}

	public void setIncome(boolean income) {
		this.income = income;
	}
	
	public ArrayList<Family> getFamilies(){
		return families;
	}
	
	public void setIncomeDiff(int incomeDiff){
		this.incomeDiff = incomeDiff;
	}
	
	public ArrayList<ArrayList<Family>> getMatches() {
		return matches;
	}

	public int getIncomeDiff(){
		return incomeDiff;
	}

	public double getDistanceDiff() {
		return distanceDiff;
	}

	public void setDistanceDiff(double distanceDiff) {
		this.distanceDiff = distanceDiff;
	}

	public int getAgeDiff() {
		return ageDiff;
	}

	public void setAgeDiff(int ageDiff) {
		this.ageDiff = ageDiff;
	}
}
