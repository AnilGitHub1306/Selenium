package POM_DDF_TestNG_BAseClass_UtilityClass_PropertyFile_FailedTCesSS;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage 
{
	@FindBy(xpath = "//input[@name='personName']")  private WebElement fullName;
	WebDriver driver;

	public MyProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void switchToChildWindow() 
	{
		Set<String> allIds = driver.getWindowHandles();
		ArrayList<String> al=new ArrayList(allIds);
		driver.switchTo().window(al.get(1));		
	}
	
	
	
	public String getMyProfilePageFullName() 
	{
		String actFullName = fullName.getAttribute("value");
		return actFullName;
	}
	
	
//	public void verifyMyProfilePageFullName(String expFullName)
//	{
//		String actFullName = fullName.getAttribute("value");
//		if (actFullName.equals(expFullName)) 
//		{
//			System.out.println("Pass");
//		} 
//		else
//		{
//			System.out.println("Fail");
//		}
//	}
	
	
}
