package Com.DemoQA.TestPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.DemoQA.POMPackage.ElementPage_PomClass;
import Com.DemoQA.POMPackage.HomePage_Pom;

public class TC05_VerifyThatNumberofLinksPresent extends BaseClass
{	@Test
	public void VerifyThatNumberofLinksPresent () throws Exception
	{
	test=extent.createTest("VerifyThatNumberofLinksPresent");
	
	 JavascriptExecutor js = (JavascriptExecutor) driver; 
	 js.executeScript("window.scrollBy(0,100)");
	 

	 HomePage_Pom hp = new HomePage_Pom(driver);
	 hp.clickElement();
	 log.info("Element button clicked");
	
	 js.executeScript("window.scrollBy(0,160)");
	 
	 Thread.sleep(3000);
	ElementPage_PomClass ep = new ElementPage_PomClass(driver);
	ep.clickLinks();
	log.info("Links button clicked");
	
	
	int AutalNumberOfLinks = ep.brockenlinks();
	log.info("Number Of Links" + AutalNumberOfLinks);
	
	int ExpectedNumberOfLinks = 1;
	
	Assert.assertEquals(AutalNumberOfLinks, ExpectedNumberOfLinks);
	test.createNode("Test Case Pass");
	
	
	
	}
}
