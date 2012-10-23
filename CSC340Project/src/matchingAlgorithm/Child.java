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
}
