/**
 * 
 */
package flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkart.baseclass.TestBase;

/**
 * @author chetan
 *
 */
public class Loginpage extends TestBase
{
   //Page Factory -OR oject repository;
	
	 
	

	

	@FindBy(xpath="//div[contains(text(),'Top Offers')]")
	WebElement topoffers;
	
	
	
	
	public Loginpage() 
	    {
			
	    	PageFactory.initElements(driver, this );
		
		}
	
//Action
	
	public String gettitle_loginpage()
	{
		return driver.getTitle();
	}
	
	public TopOffers topoffers_click()
	{
		topoffers.click();
		return new TopOffers();
	}
	
}
