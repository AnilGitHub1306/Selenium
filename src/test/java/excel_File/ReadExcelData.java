package excel_File;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelData 
{
	public static void main(String[] args) throws IOException
	{
		String file = ".\\DataFiles\\StudentData1.xlsx";
		
		FileInputStream a= new FileInputStream(file);	
		XSSFWorkbook workbook = new XSSFWorkbook(a);
		XSSFSheet sheet =workbook.getSheet("Sheet1");
		
		int noOfRow = sheet.getLastRowNum();
		int noOfCol = sheet.getRow(1).getLastCellNum();	
		System.out.println("No of row =" +noOfRow+"    |    No. of Col = "+noOfCol);
		
		for(int r=0; r<noOfRow; r++)	
		{	
			for(int c=0; c<noOfCol; c++)
			{
				CellType TypeOfCell = sheet.getRow(r).getCell(c).getCellType();
				
				switch(TypeOfCell)
				{
				case STRING :System.out.print(sheet.getRow(r).getCell(c).getStringCellValue()); break;
				case NUMERIC:System.out.print(sheet.getRow(r).getCell(c).getNumericCellValue());break;
				case BOOLEAN:System.out.print(sheet.getRow(r).getCell(c).getBooleanCellValue());break;
				}	
				System.out.print(" | ");
			}
			System.out.println("");
		}	
	}
}
