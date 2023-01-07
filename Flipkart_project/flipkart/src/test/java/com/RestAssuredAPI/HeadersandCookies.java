package com.RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.restfulbookerRestAPI.BaseClass;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;



	
	public class HeadersandCookies extends BaseClass{
		@Test
		public void HeaderandCookies() {
		
		Response response=createbooking();
	    response.print();
		
	// post used in baseclass
	    
	    // header and cookies
	    Headers headers = response.getHeaders();
	    System.out.println("Headers"+ headers);
	    
	    Cookies cookie = response.getDetailedCookies();
	    System.out.println("Cookies"+ cookie);
	    
	// verification
		   Assert.assertEquals(response.getStatusCode(),200, "status code should be 200 but it is ");
		     
		   
		   SoftAssert SoftAssert = new  SoftAssert();
		   
		   
		   SoftAssert.assertEquals(response.jsonPath().getString("booking.firstname") ,"Jim", "firstname is correct ");
		   
		   SoftAssert.assertEquals(response.jsonPath().getString("booking.lastname") ,"Brown", "lastname is correct ");
		   
		   SoftAssert.assertEquals(response.jsonPath().getInt("booking.totalprice") ,111 , "totalprice is correct ");
		   
		   SoftAssert.assertTrue(response.jsonPath().getBoolean("booking.depositpaid"),"deposited is true");
		   
		   SoftAssert.assertAll();
	}
	/*curl -X POST \
	  https://restful-booker.herokuapp.com/booking \
	  -H 'Content-Type: application/json' \
	  -d '{
	    "firstname" : "Jim",
	    "lastname" : "Brown",
	    "totalprice" : 111,
	    "depositpaid" : true,
	    "bookingdates" : {
	        "checkin" : "2018-01-01",
	        "checkout" : "2019-01-01"
	    },
	    "additionalneeds" : "Breakfast"
	}'
	*/
}
