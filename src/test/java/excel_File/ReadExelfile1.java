package excel_File;

import java.io.FileInputStream;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExelfile1 
{


	public static void main(String[] args) throws IOException
	{
		String file = ".\\DataFiles\\StudentData.xlsx";
		
		FileInputStream a= new FileInputStream(file);	
		XSSFWorkbook workbook = new XSSFWorkbook(a);
		XSSFSheet sheet =workbook.getSheet("Sheet1");
		
		int noOfRow = sheet.getLastRowNum();
		int noOfCol = sheet.getRow(1).getLastCellNum();	
		System.out.println("No of row =" +noOfRow+"    |    No. of Col = "+noOfCol);
		
		for(int r=0; r<noOfRow; r++)
		{	for(int c=0; c<noOfCol; c++)
			{
				CellType cell = sheet.getRow(r).getCell(c).getCellType();
			
			//	CellType y = cell.getCellType();
				Object b =(Object) cell;
				
				if(b instanceof String)
				{	 sheet.getRow(r).getCell(c).getStringCellValue();
					System.out.println();};	
				
				if(b instanceof Boolean)
				{System.out.println(sheet.getRow(r).getCell(c).getStringCellValue());};
				
				if(b instanceof Integer)
				{System.out.println(sheet.getRow(r).getCell(c).getStringCellValue());};
				
				System.out.print(" | ");
			}
			System.out.println("");
		}

	}
}
