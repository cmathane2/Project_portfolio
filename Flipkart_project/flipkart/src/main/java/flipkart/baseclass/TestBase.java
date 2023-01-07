package flipkart.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import flipkart.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

//parent class
    public class TestBase {
	public static Properties prop;
	public static WebDriver driver;// initialise the webdriver 
	
	public static Logger logger;
	
	public TestBase()//create constructor , methed name same as class name
	
	{
	    // to read the properties from config.properties
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("F:\\autamation test engineer\\javaworkspace\\logintext\\src\\main\\java\\flipkart\\Config\\config.properties");
			//path of Config.properties
		prop.load(ip);
		
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch( IOException e) {
			e.printStackTrace();
		}
			
		}
	
	public static void intialization()
	{
		Logger logger = Logger.getLogger("TestBase");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("test");
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
	
		{
			 System.setProperty("webdriver.chrome.driver", "F:\\autamation test engineer\\javaworkspace\\logintext\\Drivers\\Drivers1\\chromedriver.exe");	
		  //   WebDriver driver = new ChromeDriver(); driver already initialies globaly
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		
		}
		
			else if(browserName.equals("Firefox"))
				
		{	
			System.setProperty("webdriver.gecko.driver", "F:\\autamation test engineer\\javaworkspace\\logintext\\Drivers\\geckodriver.exe");	
		     //   WebDriver driver = new ChromeDriver(); driver already initialies globaly
			 driver = new FirefoxDriver();
			
		}
			else if(browserName.equals("Explore"))
				
			{	
				System.setProperty("webdriver.IEDriverServer.driver", "F:\\autamation test engineer\\javaworkspace\\flipkart\\Drivers\\IEDriverServer.exe");	
			     //   WebDriver driver = new ChromeDriver(); driver already initialies globaly
				 driver = new IDEServerDriver();
				
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);//value give in util class we can give in configclass as well
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	} 
	
	}

