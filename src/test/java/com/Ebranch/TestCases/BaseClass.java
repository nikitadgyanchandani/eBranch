package com.Ebranch.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.apache.log4j.BasicConfigurator;
/*import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;*/
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Ebranch.Utiliies.ReadConfig;

//import com.Ebranch.Utilities.ReadConfig;

public class BaseClass {
	
ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public String browserName=readconfig.getBrowserName();
	
	public static WebDriver driver;
	
	//public static Logger logger;
	
	//@Parameters("browser")
	@BeforeClass //Intializing the drivers
	public void Setup()
	{
		
		/*logger=Logger.getLogger("Guru99_Autmation");
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");*/
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1500, TimeUnit.SECONDS);
			
	}
	
	/*public ExpectedCondition<Boolean> waitForElementToHaveText(final WebElement element, final String expectedText) {
	    return new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            try {
	                return element.getText().equals(expectedText);
	            } catch (Exception e) {
	                return false; // catchall fail case
	            }
	        }

	        public String toString() {
	            return "an element to have specific text";
	        }
	    };
	}*/
		
		/*public static void takeSnapShot(String fileName) throws Exception
		{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
				try {
						FileUtils.copyFile((File) srcFile , new File("./Screenshots"+fileName+".jpg"));
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
		}*/
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		System.out.println("xyz");
	}


}
