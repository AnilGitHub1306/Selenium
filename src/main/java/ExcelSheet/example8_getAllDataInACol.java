package ExcelSheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class example8_getAllDataInACol
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("D:\\Daily Examples\\Revision Session2\\SeleniumRevision2.xlsx");		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		int lastRowIndex = sh.getLastRowNum();
		
		for(int i=0; i<=lastRowIndex; i++)
		{
			Cell data = sh.getRow(i).getCell(0);
			CellType s1 = data.getCellType();
			
			if(s1==CellType.STRING)
			{
				System.out.println(data.getStringCellValue());
			}
			else if (s1 == CellType.NUMERIC) 
			{
				System.out.println(data.getNumericCellValue());
			}
			else if (s1 == CellType.BOOLEAN) 
			{
				System.out.println(data.getBooleanCellValue());
			}			
		}			
	}	
}
