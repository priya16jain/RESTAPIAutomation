package com.client;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	 
	
	/**
	 * This method will hit the Api using .execute method it will give response object .
	 * response object we get status code, Json String and All Headers.
	 * 
	 *
	 *  
	 */
	//1. GET Method without Headers:get response in json format
	public void get(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();// client connection & client object
		HttpGet httpget = new HttpGet(url); //http get request //get connection paticular url
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
		//interface
		//getting status code
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is:"+ statusCode);
		
		// Json String
		String responsestring = EntityUtils.toString(closebaleHttpResponse.getEntity(),"UTF-8"); // RETURN PURE STRING

		JSONObject responsejson = new JSONObject(responsestring);
		System.out.println("response json from api "+responsejson);	
		
		//All Headers
		Header [] headersArray = closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		
		//
		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
			
		}
		
		System.out.println("Headers Array"+ allHeaders);
		
	}

}
