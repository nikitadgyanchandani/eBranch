package com.Ebranch.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EBranch_HomePage {
	
WebDriver driver=null;
	
	public EBranch_HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//img[contains(@class,'pnbLogo')]")
	WebElement eBranch_logo;
	
	@FindBy(xpath="//title[text()='EBranchNxt']")
	WebElement DashboardTitle;
	
	@FindBy(xpath="//img[contains(@class,'hamburgerMenuIcon')]")
	WebElement HamBurgerMenu;
	
	@FindBy(xpath="//span[text()=\\\"Home\\\"]\"")
	WebElement HomeHamburger;
	
	@FindBy(xpath="//img[contains(@class,'hamburger_close')]")
	WebElement CloseHamburgerMenu;
	
	@FindBy(xpath="//div[contains(@class,'create_quote_btn')]//text()")
	WebElement createQuoteButton;
	
	public EBranch_HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo()
	{
		boolean ebranchlogo=eBranch_logo.isDisplayed();
		return ebranchlogo;
		/*if(ebranchlogo=true)
		{
			System.out.println("Logo is present on UI");
		}
		else
		{
			System.out.println("Logo is not present or currently not visible");
		}*/
	}
	
	public boolean verifyHamburgerMenuExistence()
	{
		HamBurgerMenu.click();
		boolean hamburgermenuIsPresent=HomeHamburger.isDisplayed();
		return hamburgermenuIsPresent;
		/*if(hamburgermenuIsPresent=true)
		{
			System.out.println("Hamburger menu is present");
		}
		else
		{
			System.out.println("Hamburger menu is not present");
		}
		CloseHamburgerMenu.click();*/
	}
	
	public String getTitle()
	{
		String pageTitle=DashboardTitle.getText();
		return pageTitle;
		
		//pageTitle.compareTo("WELCOME TO eBRANCH NXT");
		
	}
	
	public String verifygreetingMessage()
	{
		String message="";
		String completeGreetingMessage=null;
		List<WebElement> spanList = driver.findElements(By.xpath("//div[contains(@class,'welcome_msg')]//span//text()"));
        int totalValues = spanList.size();
        for(int i=1;i<=totalValues;i++)
        {
        	message=driver.findElement(By.xpath("//*[@id='collapseCM']/div[2]/div[2]/div"+"["+i+"]"+"/span")).getText();
        	completeGreetingMessage.concat(message);
        }
        return completeGreetingMessage;
	}
	
	public boolean verifyCreateQuoteButtonVisiblity()
	{
		boolean createQuoteButtonIsDisplayed=createQuoteButton.isDisplayed();
		return createQuoteButtonIsDisplayed; 
	}
	

}
