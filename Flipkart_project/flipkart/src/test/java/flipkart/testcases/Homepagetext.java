package flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipkart.baseclass.TestBase;
import flipkart.pages.Homepage;
import flipkart.pages.Loginpage;

public class Homepagetext extends TestBase



{
	
	Homepage homepage;
	Loginpage loginpage;
	
	//constructor
	public Homepagetext() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
	    homepage =new Homepage();
	    
		homepage.Signup(prop.getProperty("username"),prop.getProperty("password"));
	}
	
     @Test(priority=0)
	public void Verify_FlipKart_display()
	{
    	homepage.Login_Cross_Action();
		boolean flag =homepage.FlipKart_img_display();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority =1)
	public void Verify_Become_Test()
	{
	homepage.Login_Cross_Action();
		String Become_sell =homepage.Become(); 
	    Assert.assertEquals(Become_sell, "Become a Seller");
	}
	
	@Test(priority =2)
	public void VerifyTitle(){
		homepage.Login_Cross_Action();
		String title =homepage.Gettitle();
	//String title="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		
	}
	
    @Test(priority=3)
         public void UsernameClickble() {
    	
	       	boolean flag = homepage.Displayed();
	     Assert.assertTrue(flag);
	}
    
    
	@Test(priority=4)
	public void Login_Selected() 
	    {
		
		   boolean flag = homepage.LoginClick();	
		   Assert.assertTrue(flag);
	    }
	
	
	
	@Test(priority=5)
	public void UnPw() 
	{
	       loginpage =  homepage.Signup(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}