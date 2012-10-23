package matchingAlgorithm;

import java.util.ArrayList;

public class FamilyMatcher {
	//	when narrowing down matches, do the faster criteria checks first,
	//	so that we're doing the fast operations on larger data sets and the
	//	slow operations on smaller data sets\
	
	private ArrayList<Family> families;
	
	public FamilyMatcher(ArrayList<Family> families){
		this.families = families;
	}
	
	
	public ArrayList<Family> getPossibleMatches(Family f){
		//add all families to the possible matches to start
		ArrayList<Family> possibleMatches = new ArrayList<>(families);
		//remove the family we are finding matches for
		possibleMatches.remove(f);
		
		
		return possibleMatches;
	}
}
