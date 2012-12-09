/**
 * Child.java
 * Purpose: To hold data representing each Child in a Family class
 * 
 * @author Jeffrey Eldridge
 * @version 1.0 11/28/2012
 */
package matchingAlgorithm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Child {
	private String name;
	private String dateOfBirth;
	private String disability;
	private String gender;
	
	public Child(String name, String dateOfBirth, String disability, String gender){
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.disability = disability;
		this.gender = gender;
	}
	
	/**
	 * @param d
	 */
	public void setDisability(String d){
		this.disability = d;
	}

	/**
	 * @return
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param age
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return
	 */
	public String getDisabilities() {
		return disability;
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
	
	public int getAge(){
		Calendar calendar1 = Calendar.getInstance(); //now
	    Calendar calendar2 = Calendar.getInstance(); //date in past
	    
	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	    Date birth;
	    
	    try{
	    	birth = df.parse(dateOfBirth);
	    }catch(Exception e){
	    	return 0;
	    }
	    
	    calendar2.setTime(birth); //set date in past
	    // just add one year at a time to the earlier date until it becomes later then the other one
	    int years = 0;
	    while(true)
	    {
	        calendar2.add(Calendar.YEAR, 1);

	        //”if” statement checks if it needs to add one more year for current year
	        // (whether or not day of old date falls before or after day this year)
	        if(calendar2.getTimeInMillis() < calendar1.getTimeInMillis())
	            years++;
	        else

	            return years;  //returns years as a string because it needs to be in a string to populate the label we use
	    }	
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: " + name + "\n");
		sb.append("Date of Birth: " + dateOfBirth + "\n");
		sb.append("Gender: " + gender + "\n");
		sb.append("Disabilities: ");
		sb.append(disability);
		
		return sb.toString();
	}
}
