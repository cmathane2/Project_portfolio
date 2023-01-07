package flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipkart.baseclass.TestBase;
import flipkart.pages.Homepage;
import flipkart.pages.Loginpage;
import flipkart.pages.TopOffers;

public class Loginpage_text extends TestBase {
          	
	Homepage homepage;
	Loginpage loginpage;
	TopOffers topoffers;
	public Loginpage_text() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
	     homepage = new Homepage();
	     loginpage = new Loginpage();
	     topoffers = new TopOffers();
       	 loginpage=  homepage.Signup(prop.getProperty("username"),prop.getProperty("password"));
	//loginpage = homepage.LoginClick();
	  
	}
	
	@Test(priority=1)
	public void Verify_Login_title()
	{
		String Verify_text =loginpage.gettitle_loginpage();
	    Assert.assertEquals(Verify_text,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	
	@Test(priority=2)
	public void Verify_TopOffers_click()
	{
		topoffers = loginpage.topoffers_click();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
