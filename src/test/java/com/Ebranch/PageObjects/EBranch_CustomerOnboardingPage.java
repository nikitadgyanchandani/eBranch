package com.Ebranch.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EBranch_CustomerOnboardingPage {
	
WebDriver driver=null;
	
	public EBranch_CustomerOnboardingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//input[@placeholder='Date of Birth']")
	WebElement LeadDOB;
	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[1]")
	WebElement leadAgeInYears;
	
	@FindBy(xpath="//*[text()=' Mobile Number ']/../../../..//span[text()='+91']")
	WebElement DialingCode;
	
	@FindBy(xpath="")
	WebElement var;
	
	

}
