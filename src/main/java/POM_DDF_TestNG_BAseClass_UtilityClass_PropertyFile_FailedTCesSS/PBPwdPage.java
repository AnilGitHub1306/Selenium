package POM_DDF_TestNG_BAseClass_UtilityClass_PropertyFile_FailedTCesSS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPwdPage
{
	@FindBy(xpath = "//input[@id='central-login-password']")	private WebElement pwd;
	@FindBy(xpath = "//span[text()='Sign in']")	private WebElement signIn;

	
	public PBPwdPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void inpPBPwdPagePwd(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void clickPBPwdPageSignInBtn() 
	{
		signIn.click();
	}
	
}
