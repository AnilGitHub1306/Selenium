package POM_DDF_TestNG_BAseClass_UtilityClass_PropertyFile_FailedTCesSS;

import javax.accessibility.AccessibleStreamable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.devtools.v113.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMobNumPage 
{
@FindBy(xpath = "(//input[@id='central-login-module-sign-mobile'])[2]")	private WebElement mobNum;
@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]")	private WebElement loginWithPWd;


	public PBMobNumPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void inpPBMobNumPageMobnum(String mobileNumber) 
	{
		mobNum.sendKeys(mobileNumber);
	}
	
	
	public void clickPBMobNumPageLoginWithPwd() 
	{
		loginWithPWd.click();
	}

}
