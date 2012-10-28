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
	
	public Family(String name, String address, ArrayList<Child> children, Date dateJoined, String language, boolean matched){
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
	
}
