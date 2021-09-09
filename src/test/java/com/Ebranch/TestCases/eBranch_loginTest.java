package com.Ebranch.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ebranch.PageObjects.EBranch_LoginPage;

public class eBranch_loginTest extends BaseClass{
	
	static EBranch_LoginPage loginpage;
	SoftAssert softassert=new SoftAssert();
	
	@BeforeMethod
	public void launchApplication()
	{
		loginpage=new EBranch_LoginPage();
		System.out.println("Hello");
		Setup();
		
		WebDriverWait wait = new WebDriverWait(driver, 250000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Sign in to continue ')]")));
		wait.until(ExpectedConditions.urlToBe("https://uat-ebranchnxt.pnbmetlife.com/ebranch-nxt/login"));
		
	}
	
	@Test
	public void verifyLogo()
	{
		System.out.println("within verifyLogo");
		boolean logoIsDisplayed=loginpage.verifyLogo();
		softassert.assertEquals(logoIsDisplayed, true);
		
		System.out.println("verifyLogo: ,Expected Value: true, Actual value: " + logoIsDisplayed);	
	}
	
	@Test
	public void verifySubHeading()
	{
		System.out.println("within verifySubHeading");
		boolean subheadingIsDisplayed=loginpage.verifySubheading();
		softassert.assertEquals(subheadingIsDisplayed, true);
		
		System.out.println("verifySubheading: ,Expected Value: true, Actual value: " + subheadingIsDisplayed);
	}
	
	@Test
	public void verifyUsernamePlaceholder()
	{
		System.out.println("within verifyUsernamePlaceholder");
		String unamePlaceholder=loginpage.verifyUsernamePlaceholder();
		unamePlaceholder.compareTo("User ID");
		
		System.out.println("verifyusernameplaceholder: ,Expected Value: User ID, Actual value: " + unamePlaceholder);
	}
	
	@Test
	public void verifyPswdPlaceholder()
	{
		System.out.println("within verifyPswdPlaceholder");
		String pswdPlaceholder=loginpage.verifyPasswordPlaceholder();
		pswdPlaceholder.compareTo("Password");
		
		System.out.println("verifyPswdPlaceholder: ,Expected Value: Password, Actual value: " + pswdPlaceholder);
	}
	
	@Test
	public void Login_PNBChannel() throws InterruptedException
	{
		System.out.println("within Login_PNBChannel");
		/*loginpage.verifyLogo();
		loginpage.verifySubheading();
		loginpage.verifyUsernamePlaceholder();
		loginpage.verifyPasswordPlaceholder();*/
		loginpage.SetUsername(username);
		loginpage.SetPassword(password);
		loginpage.loginToeBranch();
		
		WebDriverWait wait=new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//title[text()='EBranchNxt']")));
		
		//driver.wait(60);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
