package com.Test_Class_Package;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base_Class_Package.BaseClass;
import com.Pom_Class_Package.HomePage_POMClass;

import utiltiypackage.UtilityClass;

public class TC001_Verify_Title_Of_Home_Page extends BaseClass
{
	@Test
	public  void VerifyTitleOfPage() throws IOException 
	{
	test=extent.createTest("VeifyTitleOfPage");
	HomePage_POMClass hp = new HomePage_POMClass(driver);
	
	String actualHomePageTitle = hp.getHomePageTitle();
	log.info("Actual Title of the home page - "+actualHomePageTitle);
	
	String expectedHomePageTitle = UtilityClass.getExcelTestData(0, 1);
	log.info("Expected title of home page"+expectedHomePageTitle);
	
	Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
	}
}
