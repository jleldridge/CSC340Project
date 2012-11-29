/**
 * Distance.java
 * Purpose: Computes the distance between two addresses.
 * 
 * @author Kyle Lecher
 * @version 1.0 11/28/2012
 */

package matchingAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


final public class Distance {
	
	private Distance(){}
	//static method, takes 2 arguments, currently assumes the formats are correct
	public static String getDistance(String origin, String destination)
	{
		String stringUrl = "";
		//origin = "5634,west+market+st,greensboro,nc"; //string address 1.  cannot contain spaces, order is street,city,state.  this is very flexible, it will take just city, for example.  google is good like that
		//destination = "3505+parkwood+dr,greensboro,nc"; //string address 2.  these 2 strings must be created from the input
		stringUrl += "http://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "&sensor=false"; //you can try this url in a browser to see input
		StringBuffer sb = new StringBuffer();
		String jsonOutput;
	    String duration = "";
		
		try{
		  URL url = new URL(stringUrl);
	      HttpURLConnection httpconn = (HttpURLConnection)url.openConnection();
	      if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK)
	      {
	          BufferedReader input = new BufferedReader(new InputStreamReader(httpconn.getInputStream()),8192);
	          String strLine = null;
	          while ((strLine = input.readLine()) != null)
	          {
	              sb.append(strLine);
	          }
	          input.close();
	      }
	      jsonOutput = sb.toString();
		
	      JSONObject jsonObject = new JSONObject(jsonOutput);

	   // routesArray contains ALL routes
	   JSONArray routesArray = jsonObject.getJSONArray("routes");
	   // Grab the first route
	   JSONObject route = routesArray.getJSONObject(0);
	   // Take all legs from the route
	   JSONArray legs = route.getJSONArray("legs");
	   // Grab first leg
	   JSONObject leg = legs.getJSONObject(0);

	   JSONObject distanceObject = leg.getJSONObject("distance");
	   duration = distanceObject.getString("text");
		}
		catch(IOException e)
		{
			System.out.println("error");
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return duration;
	}

}
