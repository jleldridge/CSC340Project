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
	
	/**
	 * @param d
	 */
	public void addDisability(String d){
		disabilities.add(d);
	}
	
	/**
	 * @param d
	 */
	public void removeDisability(String d){
		disabilities.remove(d);
	}

	/**
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return
	 */
	public ArrayList<String> getDisabilities() {
		return disabilities;
	}

	/**
	 * @param disabilities
	 */
	public void setDisabilities(ArrayList<String> disabilities) {
		this.disabilities = disabilities;
	}

	/**
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
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
