package POM_DDF_TestNG_BAseClass_UtilityClass_PropertyFile_FailedTCesSS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtiltyClass 
{
	
	//@Author Name: Sanjay
	//Date: 25th Aug 23
	//this method is use to get test data from excel sheet
	//need to pass  2 inputs
	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("D:\\workspace\\SeleniumRevision2\\TestData\\SeleniumRevision2.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	public static void captureSS(WebDriver driver, int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\workspace\\SeleniumRevision2\\FailedTCesSS\\TestCaseID"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("D:\\workspace\\SeleniumRevision2\\PropertyFile.properties");
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	}
	
	

}
