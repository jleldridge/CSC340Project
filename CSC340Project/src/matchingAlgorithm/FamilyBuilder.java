package matchingAlgorithm;

import java.util.ArrayList;
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
   
    public FamilyBuilder() throws SQLException{
    	// Database information to connect, and query
    	// query pulls all information from the database.
    	String query = "Select * From NAME_OF_DATABASE_";
        String url = "//localhost:3306/NAME_OF_DATABASE";
        String  username ="root";
        String password = "user0613";
        
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
        	// starting column is 5
        	String name = results.getString(5);
        	// Create address string
        	String address;
        	StringBuilder sb = new StringBuilder();
        	sb.append(results.getString(7) + " ");
        	sb.append(results.getString(8) + " ");
        	sb.append(results.getString(9) + " ");
        	sb.append(results.getString(10) + " ");
        	//sb.append(results.getString(39) + " ");
        	address = sb.toString();
        	
        	// Create a list of children
        	ArrayList<Child> Children = new ArrayList();
        	//Family class uses an arraylist -- creates a new list to cooperate with the Family class
        	ArrayList<String> disa1 = new ArrayList();
        	ArrayList<String> disa2 = new ArrayList();
        	// build first child object
        	disa1.add(results.getString(22));
         	Child child1 = new Child(results.getString(18), 
        			results.getInt(19), 
        			disa1, 
        			results.getString(20));
        	
         	// build second child object
         	/*
         	disa2.add(results.getString(54));
         	Child child2 = new Child(results.getString(51), 
        			results.getInt(52), 
        			disa2, 
        			results.getString(55));
         	// build children list
         	 */
         	Children.add(child1); 
         	//Children.add(child2);
        	
         	// needs to be put in database
        	String language = results.getString(6);
        	boolean matched = false;
        	
        	
        	//add family to the list
        	Family obj = new Family(name, address, Children, language, matched);
        	families.add(obj);
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
}
    

