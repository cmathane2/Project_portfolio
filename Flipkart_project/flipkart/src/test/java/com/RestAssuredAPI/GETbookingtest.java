package com.RestAssuredAPI;

import static org.testng.Assert.assertFalse;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.restfulbookerRestAPI.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETbookingtest extends BaseClass{

	
	@Test(priority=2)
	void Getbookingtest() {
		Response responseCreate = createbooking();
		responseCreate.print();
		//SPECIFY BASE URI
	    //RestAssured.baseURI="http://ip.jsontest.com/";
		//http://ip.jsontest.com/
		//http://restapi.demoqa.com/utilities/weather/city
	
		 spec.pathParam("bookingID",responseCreate.jsonPath().getInt("bookingid") );

		 // Response response = RestAssured.given(spec).auth().preemptive().basic("admin", "password123")
			//		.delete("/booking/ {bookingID}");
		// to get response from url
		
	     Response response = RestAssured.given(spec).get("/booking/{bookingID}");
	     response.print();
	     
	     // to check status code
	     Assert.assertEquals(response.getStatusCode(),200, "status code should be 200 but it is ");
	     
	   
	   SoftAssert SoftAssert = new  SoftAssert();
	   
	   
	   SoftAssert.assertEquals(response.jsonPath().getString("firstname") ,"Jim", "firstname is correct ");
	   
	   SoftAssert.assertEquals(response.jsonPath().getString("lastname") ,"Jones", "lastname is correct ");
	   
	   SoftAssert.assertEquals(response.jsonPath().getInt("totalprice") ,866 , "totalprice is correct ");
	   
	   SoftAssert.assertFalse(response.jsonPath().getBoolean("depositpaid"),"deposited is false");
	   
	   SoftAssert.assertAll();
	/*
	 *{"firstname":"Jim","lastname":"Jones","totalprice":866,"depositpaid":true,"bookingdates":{"checkin":"2019-03-15","checkout":"2022-07-25"}}
PASSED: Getbookingtest

	 **/
	}
	@Test(priority=1)
	void GetbookingtestXML() {
		
		Response responseCreate = createbooking();
		responseCreate.print();
		
		//SPECIFY BASE URI
	    //RestAssured.baseURI="http://ip.jsontest.com/";
		//http://ip.jsontest.com/
		//http://restapi.demoqa.com/utilities/weather/city
	   
		//Get Headers
		Header xml = new Header("Accept","application/xml");
		
		spec.header(xml);
		
		// spec.pathParam("bookingID",responseCreate.jsonPath().getInt("bookingid") );
	//	 spec.pathParam("bookingID",responseCreate.xmlPath().getInt("bookingid") );

		 // Response response = RestAssured.given(spec).auth().preemptive().basic("admin", "password123")
			//		.delete("/booking/ {bookingID}");
		// to get response from url
		
	     Response response = RestAssured.given(spec).get("/booking/5");
	     response.print();
	     
	     // to check status code
	     Assert.assertEquals(response.getStatusCode(),200, "status code should be 200 but it is ");
	     
	   
	   SoftAssert SoftAssert = new  SoftAssert();
	   
	   
	   SoftAssert.assertEquals(response.xmlPath().getString("booking.firstname") ,"Jim", "firstname is correct ");
	   
	   SoftAssert.assertEquals(response.xmlPath().getString("booking.lastname") ,"Jones", "lastname is correct ");
	   
	   SoftAssert.assertEquals(response.xmlPath().getInt("booking.totalprice") ,866 , "totalprice is correct ");
	   
	   SoftAssert.assertFalse(response.xmlPath().getBoolean("booking.depositpaid"),"deposited is false");
	   
	   SoftAssert.assertAll();
	/*
	<booking>
    <firstname>Mark</firstname>
    <lastname>Smith</lastname>
    <totalprice>109</totalprice>
    <depositpaid>false</depositpaid>
    <bookingdates>
        <checkin>2021-08-24</checkin>
        <checkout>2022-01-05</checkout>
    </bookingdates>
    <additionalneeds>Breakfast</additionalneeds>
</booking>

	*/
	}
	
	
}