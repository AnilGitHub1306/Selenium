package Com.DemoQA.TestPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.DemoQA.POMPackage.HomePage_Pom;
import utilityPackage.ScreenShot;

public class TC01_VerifyTheFunctionalityOfElementButton extends BaseClass
{
	@Test
	public void VerifyTheFunctionalityOfElementButton () throws Exception
	{
		test=extent.createTest("VerifyTheFunctionalityOfElementButton");
		
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("window.scrollBy(0,100)");
		 
	
		HomePage_Pom hp = new HomePage_Pom(driver);
		hp.clickElement();
		log.info("Element button clicked");
	//	ScreenShot.ScreenShotMethod("Element button clicked");
		
		String givenUrl = "https://demoqa.com/elements";
		log.info("givenUrl = https://demoqa.com/elements");
		
		String actualUrl=driver.getCurrentUrl();
		
		log.info("actualUrl = "+ actualUrl);
		
		
		Assert.assertEquals(actualUrl, givenUrl);
		test.createNode("Test Case Pass");
		log.info("Assertion applied");
	//	ScreenShot.ScreenShotMethod("Element page");
	}
}
