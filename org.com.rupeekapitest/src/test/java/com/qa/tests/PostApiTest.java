package com.qa.tests;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.AbstractDocument.Content;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.mime.Header;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.qa.base.TestBase;

import groovyjarjarantlr.collections.List;


public class PostApiTest extends TestBase
{
	
	TestBase testbase;
	String serviceUrl;
	String apiUrl;
	String url;
	String username;
	String password;
	String userUrl;
	String token;
	String usersUrl;
	@BeforeTest
	public void setUp() throws ClientProtocolException, IOException
	{
		 testbase= new TestBase();
		
		serviceUrl = testbase.prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		url = serviceUrl+apiUrl;
		
		userUrl= prop.getProperty("users");
	    usersUrl=serviceUrl+userUrl;
	    
		
	}	
		
  @Test(priority=1)
  public void test()
   {
	  
	  RequestSpecification request = RestAssured.given();
	  request.header("Content-Type","application/json");
	  
	JSONObject json = new  JSONObject();
	json.put("username","rupeek");
    json.put("password","password");
    
    request.body(json.toString());
    
    System.out.println(url);
    Response response = request.post(url);
  
    String res = response.getBody().asString();
    System.out.println(res);
    
     token=request.post(url).then().extract().path("token");
    System.out.println(token); 
    
   
  }
  
 
  
  @Test(priority=2)
  
   public void getUser()
   { 		  
			  
       System.out.println(usersUrl);
	 
	  RequestSpecification request = RestAssured.given();
	  request.header("Authorization", "Bearer "+ token);
	  System.out.println("dhdhdhdh"+request.toString());
	  Response response = request.get(usersUrl);//test
	  System.out.println(response.getStatusCode());
	  System.out.println(response.getBody().asString());
	  
	  ArrayList<String> al = request.get(usersUrl).then().extract().path("phone");
	  
	  String ph1= al.get(0);
	  System.out.println(ph1);
	  
	  for(String m: al)
	  {
		  System.out.println(m);
	  }
	
	  
  }
  
}
