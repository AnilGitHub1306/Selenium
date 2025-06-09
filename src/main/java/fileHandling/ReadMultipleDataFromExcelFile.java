package fileHandling;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadMultipleDataFromExcelFile 
{
	@Test
	public void readExcelFile() throws Exception, Throwable 
	{
		
		
		FileInputStream file = new FileInputStream("./testData/book.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
	//	String s = book.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	//	System.out.println(s);
		
		int lastRowNum = book.getSheet("Sheet1").getLastRowNum()+1;
		int lastCellNum = book.getSheet("Sheet1").getRow(0).getLastCellNum();
		System.out.println("lastRowNum : "+ lastRowNum );
		System.out.println("lastCellNum : "+lastCellNum);
		
		for(int i=0;i<lastRowNum;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				String s1 = book.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
				System.out.print(s1);
				System.out.print(" ");
			}
		System.out.println();
		}
	}
}
