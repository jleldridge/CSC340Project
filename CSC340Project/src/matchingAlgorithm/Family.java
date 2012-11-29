/**
 * Family.java
 * Purpose: Holds information pertaining to a Family and
 * 			the children in that family.
 * 
 * @author Jeffrey Eldridge
 * @version 1.0 11/28/2012
 */

package matchingAlgorithm;

import java.util.ArrayList;
import java.util.Date;

public class Family {
	//this class probably needs a toString method
	
	private String name;
	private String address;
	private ArrayList<Child> children;
	private Date dateJoined;
	private String language;
	private String ethnicity;
	private int income;
	//to check if the family is already matched
	private boolean matched;
	
	public Family(String name, String address, ArrayList<Child> children, String language, boolean matched){
		this.name = name;
		this.address = address;
		this.children = children;
		this.dateJoined = dateJoined;
		this.language = language;
		this.matched = matched;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Child> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	}
	
	public void addChild(Child c){
		children.add(c);
	}
	
	public void removeChild(Child c){
		children.remove(c);
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
	
	public void setMatched(boolean matched){
		this.matched = matched;
	}
	
	public boolean isMatched(){
		return matched;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: " + name + "\n");
		sb.append("Address: " + address + "\n");
		sb.append("Date Joined: " + dateJoined + "\n");
		sb.append("Language: " + language + "\n");
		sb.append("Ethnicity: " + ethnicity + "\n");
		sb.append("Income: " + income + "\n");
		sb.append("Children: " + "\n");
		for(Child c : children){
			sb.append("     Name: " + c.getName() + "\n");
			sb.append("     Age: " + c.getAge() + "\n");
			sb.append("     Gender: " + c.getGender() + "\n");
			sb.append("     Disabilities: ");
			for(int i = 0; i < c.getDisabilities().size()-1; i++){
				sb.append(c.getDisabilities().get(i) + ", ");
			}
			sb.append(c.getDisabilities().get(c.getDisabilities().size()-1) + "\n\n");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		
		//the families are the same if they have the same name and address
		Family f = (Family)o;
		if(name.equals(f.getName()) && address.equals(f.getAddress())){
			equals = true;
		}
		
		return equals;
	}
	
}
