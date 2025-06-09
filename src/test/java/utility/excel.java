package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excel 
{
	@Test
	public static String exelsheetmethod(int l, int k) throws IOException
	{
	String path="./screenshot/soucedemo.xlsx";
	FileInputStream file = new FileInputStream(path);
	XSSFWorkbook book = new XSSFWorkbook(file);
	
//	String df=new XSSFWorkbook(file).getSheet("anil").getRow(l).getCell(k).getStringCellValue();
	String data = book.getSheet("anil").getRow(l).getCell(k).getStringCellValue();
	return data;
	}
	
//	@Test
//	public void exelsheetmethod() throws IOException
//	{
//		String path="C:\\Users\\admin\\Desktop\\soucedemo.xlsx";
//		
//	FileInputStream file = new FileInputStream(path);
//	XSSFWorkbook book = new XSSFWorkbook(file);
//	
//	String data = book.getSheet("anil").getRow(1).getCell(0).getStringCellValue();
//	
//	System.out.println(data);
//	}
}
