package com.Ebranch.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ebranch.PageObjects.EBranch_HomePage;


public class eBranch_homePageTest extends BaseClass {
	
	static EBranch_HomePage homepage;
	SoftAssert softassert=new SoftAssert();
	
	@BeforeClass(alwaysRun=true)
	public void launchApplication()
	{
		homepage=new EBranch_HomePage();
		
		/*WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//title[text()='EBranchNxt']")));*/
	}
	
	@Test
	public void verifyPNBMetLifeLogo()
	{
		boolean logoIsPresent=homepage.verifyLogo();
		softassert.assertEquals(logoIsPresent, true);
		System.out.println("verifyPNBMetLifeLogo: ,Expected Value: true, Actual value: " + logoIsPresent);
	}
	
	@Test
	public void verifyHamburgerMenu()
	{
		boolean homePageIsPresent=homepage.verifyHamburgerMenuExistence();
		softassert.assertEquals(homePageIsPresent, true);
		System.out.println("verifyHamburgerMenu: ,Expected Value: true, Actual value: " + homePageIsPresent);
		driver.findElement(By.xpath("//img[contains(@class,'hamburger_close')]")).click();
	}
	
	@Test
	public void verifyDashboardTitle()
	{
		String dashboardTitle=homepage.getTitle();
		dashboardTitle.compareTo("EBranchNxt");
		System.out.println("Dashboard Title is: " +dashboardTitle);
	}
	
	@Test
	public void verifyGreetingMessage() 
	{
		String GreetingMessage=homepage.verifygreetingMessage();
		GreetingMessage.compareTo("Good Afternoon, Nitin");
		System.out.println("Greeting Message on dashboard is: "+GreetingMessage);
	}
	
	@Test
	public void verifyCreateQuoteButton()
	{
		boolean createQuoteButtonIsPresent=homepage.verifyCreateQuoteButtonVisiblity();
		softassert.assertEquals(createQuoteButtonIsPresent, true);
		System.out.println("verifyCreateQuoteButton: ,Expected Value: true, Actual value: " + createQuoteButtonIsPresent);
		
		driver.findElement(By.xpath("//div[contains(@class,'create_quote_btn')]//text()")).click();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
