package matchingAlgorithm;

import java.sql.*;

public class DatabaseLoader {
	private String connectionURL;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public DatabaseLoader(){
		
	}
	
	public boolean connect(String connectionURL, String userName, String password){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, userName, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public void disconnect(){
		try{
			connection.close();
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}
