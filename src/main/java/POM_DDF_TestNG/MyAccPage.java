package POM_DDF_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccPage 
{
	@FindBy(xpath = "//span[text()=' My profile ']")	private WebElement myProfile;
	@FindBy(xpath = "//span[text()='Sign out']")	private WebElement logout;
	

	
	public MyAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyAccPageMyProfile() 
	{
		myProfile.click();
	}
	
	
	public void clickMyAccPageMyLogout() 
	{
		logout.click();
	}
}
