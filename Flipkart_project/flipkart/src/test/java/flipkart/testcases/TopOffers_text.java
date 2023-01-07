package flipkart.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipkart.baseclass.TestBase;
import flipkart.pages.Homepage;
import flipkart.pages.Loginpage;
import flipkart.pages.TopOffers;

public class TopOffers_text extends TestBase{
	
	Homepage homepage;
	Loginpage loginpage;
	TopOffers topoffers;
	//loginpage=  homepage.Signup(prop.getProperty("username"),prop.getProperty("password"));
	// loginpage = homepage.LoginClick();

	
	
	public TopOffers_text() {
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
	// loginpage = homepage.LoginClick();
	  
	}
	@Test(priority=1)
	public void Verify_TopOffers_title()
	{
		
	Assert.assertEquals(topoffers.title_page(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
			//assertEquals(topoffers.title_page(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
}
