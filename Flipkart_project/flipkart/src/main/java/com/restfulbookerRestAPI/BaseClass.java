package com.restfulbookerRestAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	protected RequestSpecification spec ;
	
	// request specification used for future point of view 
	//here main URL  is define 
	// define in base class extend in other class
	
	@BeforeMethod
	public void setUp()
	{
		spec = new RequestSpecBuilder()
				.setBaseUri("https://restful-booker.herokuapp.com")
				.build();
		
	}
	
protected Response createbooking()
	{
	
	
	// json body  
			// created object and added all key value 
			//we can create separeate base class for the json body
			JSONObject body = new JSONObject();
			body.put("firstname", "Jim");
			body.put("lastname", "Brown");
			body.put("totalprice", 111);
			body.put("depositpaid" , true);
		
			JSONObject bookingdates = new JSONObject();
			bookingdates.put("checkin" ,"2018-01-01") ;
			bookingdates.put("checkout" ,"2018-01-01");
			body.put("bookingdates", bookingdates);
			body.put("additionalneeds" , "Breakfast");
			
			
			//get response 
			Response response = RestAssured.given(spec).contentType(ContentType.JSON)
					.body(body.toString()).post("booking");
			response.print();
			return response;
	}
}
