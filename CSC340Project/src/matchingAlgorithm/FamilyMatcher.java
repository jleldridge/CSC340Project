package matchingAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyMatcher {
	// when narrowing down matches, do the faster criteria checks first,
	// so that we're doing the fast operations on larger data sets and the
	// slow operations on smaller data sets
	private ArrayList<Family> families;
	//flags for checking which criteria to consider when matching
	private boolean ethnicity, language, disability, distance, age, income;
	//values to consider if matching by distance, age, or income
	private int distanceDiff=0, ageDiff=0, incomeDiff=0;
	
	public FamilyMatcher(ArrayList<Family> families) {
		this.families = families;
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
			//TODO: not implemented yet
			}
		}
		if (income) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				Family pf = iter.next();
				//if the income difference between the families is higher than
				//desired, they cannot be matched
				if(Math.abs(f.getIncome() - pf.getIncome()) > incomeDiff){
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
						for(String d : c.getDisabilities()){
							for(String pd : pc.getDisabilities()){
								if(d.equalsIgnoreCase(pd)){
									matchingChildren = true;
								}
							}
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
				//TODO: not implemented yet
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
	
	public int getIncomeDiff(){
		return incomeDiff;
	}
}
