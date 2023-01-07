package com.RestAssuredAPI;

import static org.testng.Assert.assertFalse;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restfulbookerRestAPI.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETbookingIDstest  extends BaseClass{

	
	@Test
	void healthcheckuptest()
	{
		
		//SPECIFY BASE URI
	   //	RestAssured.baseURI="http://ip.jsontest.com/";
		//http://ip.jsontest.com/
		//http://restapi.demoqa.com/utilities/weather/city
	
		
		// to get response from url
		
	     Response response = RestAssured.given(spec).get("/booking");
	     response.print();
	     
	     // to check status code
	     Assert.assertEquals(response.getStatusCode(),200, "status code should be 200 but it is ");
	     
	    // list of id is 
	     //use json because response is of json type file
	     
	     List<Integer> bookingIDs = response.jsonPath().getList("bookingid");
	     Assert.assertFalse(bookingIDs.isEmpty(),"booking id is not empty ");
	     
	     System.out.println(bookingIDs);
	
	 /*    //request object
		
		RequestSpecification httpRequest=RestAssured.given();
				
		//Response object
		
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response in  console window
		String responseBody =response.getBody().asString();
			
		System.out.println( "response body is " +responseBody);
	 */
	
	}
	
	@Test
	public void querparameter()
	
	{
        spec.queryParams("firstname","Jim");
		
		spec.queryParams("lastname","Brown");
		// to get response from url
		
	     Response response = RestAssured.given(spec).get("/booking");
	     response.print();
	     
	     // to check status code
	     Assert.assertEquals(response.getStatusCode(),200, "status code should be 200 but it is ");
	     
	    // list of id is 
	     //use json because response is of json type file
	     
	     List<Integer> bookingIDs = response.jsonPath().getList("bookingid");
	     Assert.assertFalse(bookingIDs.isEmpty(),"booking id is not empty ");
	     
	     System.out.println(bookingIDs);
	
	}
	
	
}