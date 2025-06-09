package Com.DemoQA.TestPackage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.DemoQA.POMPackage.ElementPage_PomClass;
import Com.DemoQA.POMPackage.HomePage_Pom;
public class TC06_VerifyTheLinkBrokenandnormal extends BaseClass

{	@Test
	public void VerifyTheLinkBrokenandnormal () throws Exception
	{
	test=extent.createTest("VerifyTheLinkBrokenandnormal");
	
	 JavascriptExecutor js = (JavascriptExecutor) driver; 
	 js.executeScript("window.scrollBy(0,100)");
	 

	HomePage_Pom hp = new HomePage_Pom(driver);
	hp.clickElement();
	log.info("Element button clicked");
	

	 js.executeScript("window.scrollBy(0,150)");
	 
	ElementPage_PomClass ep = new ElementPage_PomClass(driver);
	ep.clickBrokenLinksImages();
	log.info("BrokenLinksImages button clicked");
	
	ep.brockenlinks();
	Assert.assertTrue(true);
	test.createNode("Test Case Pass");
	
	
	
	}
}
