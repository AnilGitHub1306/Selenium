package excel_File;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class textSendToExcleFileByForEachLoop 
{

	public static void main(String[] args) throws IOException 
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("StudentMarks");
		
		Object data[][] = { {4543, 5435},
							{677, 768},
							{true,true}
						  };
		
		int noOfRows = 0;
		
		for(Object rows[]:data) 
		{
			 XSSFRow row = sheet.createRow(noOfRows++);
			 int noOfColoumn =0;
			 
			for(Object columnsCell:rows)
			{
				XSSFCell cell = row.createCell(noOfColoumn++);
				
				if(columnsCell instanceof String)
				{cell.setCellValue((String)columnsCell);}
				
				if(columnsCell instanceof Integer)
				{cell.setCellValue((Integer)columnsCell);}
				
				if(columnsCell instanceof Boolean)
				{cell.setCellValue((Boolean)columnsCell);}	
			}
		}		
		System.out.println("File written successfully");
		
		String excelFile = ".\\DataFiles\\getData.xlsx";
		FileOutputStream file = new FileOutputStream(excelFile);
		workbook.write(file);
		file.close();
	}
}
