package com.Ebranch.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ebranch.TestCases.BaseClass;

public class EBranch_LoginPage extends BaseClass {
	
	//Web Elements
	@FindBy (xpath = "//input[contains(@class,'mat-input-element') and contains(@ng-reflect-placeholder,'User ID')]")
	WebElement Username;
	
	@FindBy (xpath = "//input[contains(@class,'mat-input-element') and contains(@ng-reflect-placeholder,'Password')]")
	WebElement Password;
	
	@FindBy (xpath = "//button[@class='loginBtn']")
	WebElement LoginButton;
	
	@FindBy(xpath="//h1[contains(text(),'eBranch NXT')]")
	WebElement logo;
	
	@FindBy(xpath="//span[contains(text(),' Sign in to continue ')]")
	public WebElement subheadingtext;
	
	public EBranch_LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo()
	{
		boolean logoIsPresent=logo.isDisplayed();
		return logoIsPresent;
	}
	public boolean verifySubheading()
	{
		boolean subheadingIsPresent= subheadingtext.isDisplayed();
		return subheadingIsPresent;
	}
	public String verifyUsernamePlaceholder()
	{
		String Usernameplaceholder=Username.getCssValue("placeholder");
		return Usernameplaceholder;	
	}
	
	public String verifyPasswordPlaceholder()
	{
		String Passwordplaceholder=Password.getCssValue("placeholder");
		return Passwordplaceholder;
		
	}
	
	public void SetUsername(String uname)
	{
		Username.sendKeys(uname);
	}
	public void SetPassword(String pwd )
	{
		Password.sendKeys(pwd);
	}
	
	public void loginToeBranch()
	{
		LoginButton.click();
	}

}
