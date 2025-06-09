package com.Test_Class_Package;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base_Class_Package.BaseClass;
import com.Pom_Class_Package.HomePage_POMClass;

import utiltiypackage.UtilityClass;

public class TC002_Verify_URL_Of_Home_Page extends BaseClass
{
	@Test
	public  void VerifyURLOfHomePage() throws Throwable 
	{
	test=extent.createTest("VerifyURLOfHomePage");
	HomePage_POMClass hp = new HomePage_POMClass(driver);
	
	String actualHomePageURL = hp.getHomePageURL();
	log.info("Actual HomePage URL is : "+actualHomePageURL);
	
	String expectedHomePageURL = UtilityClass.getPropertyTestData("homePageurl");
	log.info("Expected HomePage URL is : " + expectedHomePageURL);
	
	Assert.assertEquals(actualHomePageURL, expectedHomePageURL);
	
	

	}
}
