package matchingAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyMatcher {
	// when narrowing down matches, do the faster criteria checks first,
	// so that we're doing the fast operations on larger data sets and the
	// slow operations on smaller data sets
	private ArrayList<Family> families;
	private boolean ethnicity, language, disability, distance, age, income;

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
				
			}
		}
		if (language) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				
			}
		}
		if (age) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				
			}
		}
		if (income) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				
			}
		}
		if (disability) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				
			}
		}
		if (distance) {
			Iterator<Family> iter = possibleMatches.iterator();
			while(iter.hasNext()){
				
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
}
