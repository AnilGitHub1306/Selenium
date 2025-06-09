package Com.DemoQA.TestPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.DemoQA.POMPackage.ElementPage_PomClass;
import Com.DemoQA.POMPackage.HomePage_Pom;
import utilityPackage.ScreenShot;

public class TC02_VerifyTheTextboxFiedAcceptingTheText extends BaseClass
{
	@Test
	public void VerifyTheTextboxFiedAcceptingTheText() throws Exception
	{	
		test=extent.createTest("VerifyTheTextboxFiedAcceptingTheText");
		
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("window.scrollBy(0,100)");
		 
		HomePage_Pom hp = new HomePage_Pom(driver);
		hp.clickElement();
		log.info("Element button clicked");
		
		ElementPage_PomClass  ep = new ElementPage_PomClass (driver);
		ep.clickTextBox();
		log.info("Textbox button clicked");
		
		ep.putFullName();
		log.info("Full Name entered");
		
		ep.putEmail();
		log.info("Email entered");

		 
	 js.executeScript("window.scrollBy(0,300)");
		 
		ep.putCurrentAddress();
		log.info("Current Address entered");
		
		ep.putPermanentAddress();
		log.info("Permanent Address entered");
		
		ep.clickSubmit();
		log.info("Submit button clicked");
		
		boolean Feedback = ep.SubmitFeedbackPresent();
		
		Assert.assertTrue(Feedback);
		test.createNode("Test Case Pass");
		log.info("Asserion applied to check Feedback present ");
		
	//	ScreenShot.ScreenShotMethod("Textbox page");
	}
}
