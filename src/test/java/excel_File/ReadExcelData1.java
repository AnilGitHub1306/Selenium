package excel_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelData1 {
	static Object[][] data = null;
	
	public static Object[][] getExceData() throws IOException 
	{
		String path = System.getProperty("user.dir")+File.separator+"testData"+File.separator+"book2.xlsx";
		FileInputStream filestr = new FileInputStream(path);
		XSSFWorkbook book =new XSSFWorkbook(filestr);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int numberOfRows = sheet.getLastRowNum();
		int numberOfColumn = sheet.getRow(0).getLastCellNum();
		
		data = new Object[numberOfRows][numberOfColumn];
		for(int i=1;i<=numberOfRows;i++)
		{
			for(int j=0;j<numberOfColumn;j++)
			{String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
			data[i - 1][j] = cellValue;}
		}
		return data;
	}
	
	 @DataProvider(name = "loginData")
	    public Object[][] getData() throws IOException 
	 	{return getExceData();}

	 @Test(dataProvider = "loginData")
	 public void loginTest(String username, String password, String key) 
	   	{System.out.println("Username: " + username + ", Password: " + password);}
}
