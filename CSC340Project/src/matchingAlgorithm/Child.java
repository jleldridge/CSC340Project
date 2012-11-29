/**
 * Child.java
 * Purpose: To hold data representing each Child in a Family class
 * 
 * @author Jeffrey Eldridge
 * @version 1.0 11/28/2012
 */
package matchingAlgorithm;

import java.util.ArrayList;

public class Child {
	private String name;
	private int age;
	private ArrayList<String> disabilities;
	private String gender;
	
	public Child(String name, int age, ArrayList<String> disabilities, String gender){
		this.name = name;
		this.age = age;
		this.disabilities = disabilities;
		this.gender = gender;
	}
	
	public void addDisability(String d){
		disabilities.add(d);
	}
	
	public void removeDisability(String d){
		disabilities.remove(d);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getDisabilities() {
		return disabilities;
	}

	public void setDisabilities(ArrayList<String> disabilities) {
		this.disabilities = disabilities;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: " + name + "\n");
		sb.append("Age: " + age + "\n");
		sb.append("Gender: " + gender + "\n");
		sb.append("Disabilities: ");
		for(int i = 0; i < disabilities.size()-1; i++){
			sb.append(disabilities.get(i) + ", ");
		}
		sb.append(disabilities.get(disabilities.size()-1));
		
		return sb.toString();
	}
}
