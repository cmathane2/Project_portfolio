package flipkart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkart.baseclass.TestBase;

public class Homepage extends TestBase

{
	
	
	
	//Page Factory -OR oject repository;
	
	
	@FindBy(linkText="Login")
	//@Cachelookup 
	// Cachelookup used for storying element in memmory do not required to find on time on web page
	//Fire Event extent report used for to get detail tracking purpose.
	
	WebElement LoginButton;
	//username
	@FindBy(xpath="//div//form[@autocomplete=\"on\"]//input[@type='text' ]")
	WebElement username;
	//password
	
	@FindBy(xpath="//div//input[@type='password']")
	WebElement password;
	//div//form[@autocomplete="on"]//input[@type='text' ]
	
	
	@FindBy(xpath="//div//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement loginclick;
	
	//div//button[@class='_2KpZ6l _2HKlqd _3AWRsL']
	//Initilizing the Page Objects
	
	
	@FindBy(xpath="//a//img[@title='Flipkart']")
	WebElement FlipLart_img;
	
	
    @FindBy(xpath="//div//a//span[@xpath='1']")
	WebElement Become_Seller;
    
    
     // WebElement Login_cross = driver.findElement(By.className("_2doB4z"));
    
      
    @FindBy(className="_2doB4z")
    WebElement Login_Cross;
      
    public Homepage() 
    {
		
    	PageFactory.initElements(driver, this );
	
	}
	//Actions
	public boolean LoginClick() 
	{
		LoginButton.click();
		boolean flag = LoginButton.isSelected();
		return flag;
	    
	}
	public void Login_Cross_Action()
	{
		
		Login_Cross.click();
				
		
	}
	
	public String Gettitle()
	{
		return driver.getTitle();
	}
	
	public boolean FlipKart_img_display()
	{
		boolean flag = FlipLart_img.isDisplayed();
		return flag;
	}
	
	
	
	public String Become() 
	{
	 	String A= Become_Seller.getText();
	    return A;
	}
	
	
	public Loginpage Signup(String un ,String pw)
	{
		//LoginButton.click();
		username.sendKeys(un);
	
		password.sendKeys(pw);
		loginclick.click();
		
		return new Loginpage();
	}
	
	public boolean Displayed() 
	{
		boolean flag=	username.isDisplayed();
		return flag;
	}
}
