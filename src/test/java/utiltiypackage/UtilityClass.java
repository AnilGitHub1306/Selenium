package utiltiypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	public static String getSceenShot(WebDriver driver, String imageName) throws IOException
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy & hh-mm-ss");
		String date = sdf.format(d);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/screenshot/"+date+imageName+".png";
		File destFile    = new File(path);
		FileHandler.copy(sourceFile, destFile);
		return path;
	}

	public static String getPropertyTestData(String testData) throws Throwable
	{
		FileInputStream f = new FileInputStream("./testData/propertiesFile.properties");
		Properties prop=new Properties();
		prop.load(f);	
		
		prop.getProperty(testData);
		return prop.getProperty(testData);
	}
	
	public static String getExcelTestData(int rowNum ,int cellNum) throws IOException
	{
		FileInputStream f = new FileInputStream("./testData/book.xlsx");
		XSSFWorkbook book =new XSSFWorkbook(f);
		//String value = WorkbookFactory.create(f).getSheet("sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		String value = book.getSheet("sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
		
	}
}
