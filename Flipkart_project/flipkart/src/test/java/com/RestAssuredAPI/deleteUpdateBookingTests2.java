package com.RestAssuredAPI;


import org.json.simple.JSONObject;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.restfulbookerRestAPI.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class deleteUpdateBookingTests2 extends BaseClass {

	@Test
	public void deleteBookingTest() {
		// Create booking
		Response responseCreate = createbooking();
		responseCreate.print();

		//without using pathparameter
		
		// Get bookingId of new booking
	/*
		int bookingid = responseCreate.jsonPath().getInt("bookingid");
		Response responsedelete = RestAssured.given(spec).auth().preemptive().basic("admin", "password123")
				.delete("/booking/" + bookingid);
	*/	
		 
		//by using path parameter
		
      // set path parameter path (key ,value)
		
	   spec.pathParam("bookingID",responseCreate.jsonPath().getInt("bookingid") );
	    
	      Response responsedelete = RestAssured.given(spec).auth().preemptive().basic("admin", "password123")
				.delete("/booking/ {bookingID}");
	    
	
		// PartialUpdate booking
		
		
		responsedelete.print();
		
		// Verifications
		// Verify response 200
		Assert.assertEquals(responsedelete.getStatusCode(), 201, "Status code should be 200, but it's not.");

		// Verify All fields
		// with path parameter
		 Response responseGet =   RestAssured.given(spec).get("/booking/ {bookingID}");
		 
		 //without setpath para
      // Response responseGet =   RestAssured.get("https://restful-booker.herokuapp.com/booking/" + bookingid);
		
       responseGet.print();
       
       Assert.assertEquals(responseGet.getBody().asString(),"Not Found","Body should be 'Not found' ");
	}


}