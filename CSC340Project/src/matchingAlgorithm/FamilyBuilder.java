package matchingAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author Christian Ore
 * FamilyBuilder class connects with the parent to parent database and extracts information.
 * Builds the corresponding objects and places them into a family object, and then a family 
 * arraylist to be used in the family matcher class.
 */
public class FamilyBuilder {
	//Holds the list of families to be matched
    private ArrayList<Family> families;
    //Holds the results from the database
    private ResultSet results;
    private ArrayList<ArrayList<Family>> currMatches;
    
    public FamilyBuilder() throws SQLException{
    	currMatches = new ArrayList<ArrayList<Family>>();
    	// Database information to connect, and query
    	// query pulls all information from the database.
    	String query = "Select * From NAME_OF_DATABASE_";
    	String url = "jdbc:mysql://instance26220.db.xeround.com:17200/familiesdb";
        String  username ="judge";
        String password = "csc471";
        
        // establish connection with database
        Connection c = DriverManager.getConnection(url,username, password);
        // Create a statement to interact with the database
        Statement myStmt = c.createStatement();
        //retrieve all information from the database
        results = myStmt.executeQuery(query);
        //set pointer to beginning of resultset
        results.beforeFirst();
        //format data into a family object
        	
        //while there is another row in the database, build a family object from the data
        while(results.next()){
        	//get name
        	String name = results.getString(5);
        	
        	//get language
        	String language = results.getString(6);
        	
        	String street = results.getString(7);
        	String city = results.getString(8);
        	String zip = results.getString(9);
        	String county = results.getString(10);
        	
        	// Create address string
        	String address = street + " " + city + " " + zip + " " + county;
        	
        	// Create a list of children
        	ArrayList<Child> Children = new ArrayList();
         	Child child1 = new Child(results.getString(18), 
        			results.getString(20), 
        			results.getString(21), 
        			results.getString(19));
        	
         	// build second child object
         	Child child2 = new Child(results.getString(23), 
        			results.getString(26), 
        			results.getString(27), 
        			results.getString(25));
         	Children.add(child1); 
         	
         	//if the second child exists, add it
         	if(!child2.getName().equals("")){
         		Children.add(child2);
         	}
        	//add family to the list
        	Family family = new Family(name, address, Children, language);
        	family.setStreet(street);
        	family.setCity(city);
        	family.setZip(zip);
        	family.setCounty(county);
        	
        	String match = results.getString(47);
        	family.setMatch(match);
        	
        	families.add(family);
        }
        
        for(Family f : families){
        	String match = f.getMatch();
        	if(match.equals("")){
        		continue;
        	}
        	Scanner strScan = new Scanner(match);
        	String matchName = strScan.next();
        	String matchAddress = strScan.nextLine();
        	
        	for(Family m : families){
        		if(m.getName().equals(matchName) && m.getAddress().equals(matchAddress)){
        			ArrayList<Family> currMatch = new ArrayList<Family>();
        			currMatch.add(f);
        			currMatch.add(m);
        			currMatches.add(currMatch);
        			break;
        		}
        	}
        }
        c.close();        
    }
    
    
    public void updateMatches(ArrayList<ArrayList<Family>> matches) throws SQLException{
    	String url = "jdbc:mysql://instance26220.db.xeround.com:17200/familiesdb";
        String  username ="judge";
        String password = "csc471";
        
    	 // establish connection with database
        Connection c = DriverManager.getConnection(url,username, password);
        
        for(ArrayList<Family> match : matches){		
        	//put database query here searching for f in the database
        	//based on their last name and address
        	Family firstFamily = match.get(0);
        	Family secondFamily = match.get(1);
        	//change first family
        	String query = "update familyContact set matchedFamily = '" +
        					secondFamily.getName() + " " + secondFamily.getAddress() + "' " +
        					"where conLastName = '" + firstFamily.getName() + "' and street = '" +
        					firstFamily.getStreet() + "' and city = '" + firstFamily.getCity() +
        					"' and zip = '" + firstFamily.getZip() + "' and county = '" +
        					firstFamily.getCounty() + "'";
        	Statement statement = c.createStatement();
        	statement.executeQuery(query);
        	
        	
        	//change second family
        	query = "update familyContact set matchedFamily = '" +
					firstFamily.getName() + " " + firstFamily.getAddress() + "' " +
					"where conLastName = '" + secondFamily.getName() + "' and street = '" +
					secondFamily.getStreet() + "' and city = '" + secondFamily.getCity() +
					"' and zip = '" + secondFamily.getZip() + "' and county = '" +
					secondFamily.getCounty() + "'";
        	statement.executeQuery(query);
        }
        c.close();
    }
    
    /**
     * 
     * @return families - list of families in database
     */
    public ArrayList<Family> getFamilies(){
        return families;
    }
    
    public ArrayList<ArrayList<Family>> getCurrMatches(){
    	return currMatches;
    }
}
    

