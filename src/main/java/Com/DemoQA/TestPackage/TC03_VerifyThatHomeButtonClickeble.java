package Com.DemoQA.TestPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.DemoQA.POMPackage.ElementPage_PomClass;
import Com.DemoQA.POMPackage.HomePage_Pom;
import utilityPackage.ScreenShot;

public class TC03_VerifyThatHomeButtonClickeble extends BaseClass
{
	@Test
	public void VerifyThatHomeButtonClickeble () throws Exception
	{
		test=extent.createTest("VerifyThatHomeButtonClickeble");
		
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("window.scrollBy(0,100)");
		 
		HomePage_Pom hp = new HomePage_Pom(driver);
		hp.clickElement();
		log.info("Element button clicked");
	//	Reporter.log("Element button clicked", true);
		ElementPage_PomClass ep=new ElementPage_PomClass(driver);
		
		ep.clickCheckBox();
		
		ep.clickHomeButton();
		log.info("Home button clicked");
	//	Reporter.log("Home button clicked", true);
		
		boolean feedbackvalue=ep.youhaveselectedFeedback();
		Assert.assertTrue(feedbackvalue);
		test.createNode("Test Case Pass");
	//	ScreenShot.ScreenShotMethod("Button page");
	//	Reporter.log("TC pass", true);
	}
	
	@Test
	public void tc2 ()
	{
		Reporter.log("TC2 Pass",true);
	}
	
}
