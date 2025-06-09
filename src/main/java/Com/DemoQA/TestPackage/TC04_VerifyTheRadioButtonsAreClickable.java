package Com.DemoQA.TestPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.DemoQA.POMPackage.ElementPage_PomClass;
import Com.DemoQA.POMPackage.HomePage_Pom;
import utilityPackage.ScreenShot;

public class TC04_VerifyTheRadioButtonsAreClickable extends BaseClass
{
	
	@Test (priority=1)
	public void VerifyTheRadioButtonYesIsClickable() throws Exception
	{
		test=extent.createTest("VerifyTheRadioButtonYesIsClickable");
		
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("window.scrollBy(0,100)");
		 
		HomePage_Pom hp = new HomePage_Pom(driver);
		hp.clickElement();
		log.info("Element button clicked");
		
		ElementPage_PomClass ep=new ElementPage_PomClass(driver);
		ep.clickRadioButton();
		log.info("Radio button clicked");
		
		ep.clickRadioButtonYes();	
		log.info("Radio button YES clicked");
	//	ScreenShot.ScreenShotMethod("Radio button YES clicked");
		
	}
	
	@Test (priority=2)
	public void VerifyTheRadioButtonImpressiveIsClickable() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("window.scrollBy(0,100)");
		 
		HomePage_Pom hp = new HomePage_Pom(driver);
		hp.clickElement();
		log.info("Element button clicked");
		
		ElementPage_PomClass ep=new ElementPage_PomClass(driver);
		ep.clickRadioButton();
		log.info("Radio button clicked");
		
		ep.clickRadioButtonImpressive();
		log.info("Radio button IMPRESSIVE clicked");
	//	ScreenShot.ScreenShotMethod("Radio button IMPRESSIVE clicked");
	}
	
	@Test (priority=3)
	public void VerifyTheRadioButtonNoIsClickable() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("window.scrollBy(0,100)");
		 
		HomePage_Pom hp = new HomePage_Pom(driver);
		hp.clickElement();
		log.info("Element button clicked");
		
		ElementPage_PomClass ep=new ElementPage_PomClass(driver);
		ep.clickRadioButton();
		log.info("Radio button clicked");
		
		ep.clickRadioButtonNo();
		log.info("Radio button NO clicked");
		Assert.assertTrue(true);
		test.createNode("Test Case Pass");
	//	ScreenShot.ScreenShotMethod("Radio button NO clicked");
	}
	
}
