
package tvtrackerclient.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *  
 * @author Oskar Kowalewski
 * 
 * class handles all http requests sent by application. it modifies URL's and prepares GET requests
 */
public class RequestsHandler {
    
    
    // method sends http GET request and returns HTML document
    public static String sendGetRequest(String url)
    {
        String document = " ";
        try {
			//create URL from site address
			URL urlAddress = new URL(url);
			//open connection with given url
			HttpURLConnection con = (HttpURLConnection) urlAddress.openConnection();
			con.setRequestMethod("GET");
			//con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			
			//in will contain data from website
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			//response will contain wanted GET request
			String inputLine;
			StringBuilder response = new StringBuilder();
			//getting wanted data
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				response.append("\n");
			}
			in.close();
			
			document = response.toString();
                        return document;
			
		} catch (IOException e) {
			e.printStackTrace();
                        return document;
		}
    }
    
}
