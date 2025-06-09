package com.Pom_Class_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_POMClass 
{
	private WebDriver driver;
	
	public HomePage_POMClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy( xpath = "//div[@class='card mt-4 top-card'][1]") private WebElement elementButton ;
	@FindBy( xpath = "//div[@class='card mt-4 top-card'][2]") private WebElement formButton;
	@FindBy( xpath = "//div[@class='card mt-4 top-card'][3]") private WebElement alerFrameAndWindowButton;
	@FindBy( xpath = "//div[@class='card mt-4 top-card'][4]") private WebElement widgetsButton;
	@FindBy( xpath = "//div[@class='card mt-4 top-card'][5]") private WebElement intractionsButton;
	@FindBy( xpath = "//div[@class='card mt-4 top-card'][6]") private WebElement booStoreApplicationButton;
	
	public void clickElementButton()
	{elementButton.click();}
	
	public void clickFormButton()
	{formButton.click();}
	
	public void clickAlerFrameAndWindowButton()
	{alerFrameAndWindowButton.click();}
	
	public void clickWidgetsButton()
	{widgetsButton.click();}
	
	public void clickIntractionsButton()
	{intractionsButton.clear();}
	
	public void clickBooStoreApplicationButton()
	{booStoreApplicationButton.click();}
	
	public String getHomePageTitle()
	{return driver.getTitle();}
	
	public String getHomePageURL()
	{return driver.getCurrentUrl();}
	
}
