package fileHandling;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile 
{
	@Test
	public void readExcelFile() throws Exception, Throwable 
	{
//		FileInputStream file = new FileInputStream("./testData/book.xlsx");
//		String s = WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
//		String s1 = WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
//		
//		System.out.println(s);
//		System.out.println(s1);
		
		FileInputStream file = new FileInputStream("./testData/book.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		String s = book.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(s);
		
		String s2 = book.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		System.out.println(s2);
		
	}
}
