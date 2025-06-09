package Com.DemoQA.POMPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class HomePage_Pom
{	
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div/div[1]") private WebElement Element;
	
	public void clickElement()
	{Element.click();}
	
	public HomePage_Pom (WebDriver driver)
	{this.driver = driver; 
	 PageFactory.initElements(driver, this); 
	 
	}
}
