package POM_DDF_TestNG_BAseClass_UtilityClass_PropertyFile_FailedTCesSS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomePage 
{
	@FindBy(xpath = "//div[text()='My Account']")	private WebElement MyAcc;
	WebDriver driver;

	public PBHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void openDDOptionPBHomePageMyAcc() 
	{
		Actions act=new Actions(driver);
		act.moveToElement(MyAcc).perform();		
	}


}
