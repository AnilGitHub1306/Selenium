package excel_File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class textSendToExcelFileByArrayList 
{

	static Logger log =Logger.getLogger("JunFirstWeek2023");
	@Test
	public static void main() throws IOException 
	{
		PropertyConfigurator.configure("log4j.properties");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("StudentMarks");
		
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[] {"Username", "Password"});
		data.add(new Object[] {"admin123", 1234567890});
		data.add(new Object[] {true,true});
						
		int noOfRows = 0;
		
		for(Object[] rows:data) 
		{
			XSSFRow row = sheet.createRow(noOfRows++);
			int noOfCell = 0;
			
			for(Object Cells:rows)
			{
				XSSFCell cell = row.createCell(noOfCell++);
				
				if(Cells instanceof String)
				{cell.setCellValue((String)Cells);}
				
				if(Cells instanceof Integer)
				{cell.setCellValue((Integer)Cells);}
				
				if(Cells instanceof Boolean)
				{cell.setCellValue((Boolean)Cells);}	
			}
		}		
		
		log.info("File witten successfuly");
		
		String excelFile = ".\\DataFiles\\getStudentDataByArrayList.xlsx";
		FileOutputStream file = new FileOutputStream(excelFile);
		workbook.write(file);
		file.close();
		
		Boolean x=true;
		Assert.assertTrue(true);
	}
	
	
}
