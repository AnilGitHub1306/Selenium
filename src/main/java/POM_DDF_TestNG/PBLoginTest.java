package POM_DDF_TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PBLoginTest 
{
	int a;            //declare globally 
	PBLoginPage login;
	PBMobNumPage mobNum;
	PBPwdPage pwd;
	PBHomePage home;
	MyAccPage myAcc;
	MyProfilePage profile;
	Sheet sh;
	WebDriver driver;
	
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException 
	{	
		FileInputStream file=new FileInputStream("D:\\Daily Examples\\Revision Session2\\SeleniumRevision2.xlsx");
		 sh = WorkbookFactory.create(file).getSheet("DDF");
			
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		 driver=new ChromeDriver(op);
		driver.get("https://www.policybazaar.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		login=new PBLoginPage(driver); 
		mobNum=new PBMobNumPage(driver);
		pwd=new PBPwdPage(driver);
	    home=new PBHomePage(driver);
		myAcc=new MyAccPage(driver);
		profile=new MyProfilePage(driver);	
		 a=20;             //initialize locally
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException 
	{
		System.out.println(a);
		login.clickPBLoginPageSignInBtn();
		Thread.sleep(2000);
		mobNum.inpPBMobNumPageMobnum(sh.getRow(0).getCell(0).getStringCellValue());
		mobNum.clickPBMobNumPageLoginWithPwd();
		Thread.sleep(2000);
		pwd.inpPBPwdPagePwd(sh.getRow(0).getCell(1).getStringCellValue());
		pwd.clickPBPwdPageSignInBtn();
		Thread.sleep(2000);
	}
	
	@Test
	public void VerifyFullName() throws InterruptedException   
	{
		home.openDDOptionPBHomePageMyAcc();
		Thread.sleep(2000);
		myAcc.clickMyAccPageMyProfile();
		profile.switchToChildWindow();
		//profile.verifyMyProfilePageFullName(sh.getRow(0).getCell(2).getStringCellValue());
		
		String actFullName=profile.getMyProfilePageFullName();
		String expFullName=sh.getRow(0).getCell(2).getStringCellValue();
		
		Assert.assertEquals(actFullName, expFullName, "Failed: both results are diff");
		Thread.sleep(2000);
	}
	

	
	@AfterMethod
	public void logoutFromApp() 
	{
		
	}
	
	
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
	}
}
