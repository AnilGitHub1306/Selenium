package ExcelSheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class example6_getDataByVeriyingTypeOfCell
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("D:\\Daily Examples\\Revision Session2\\SeleniumRevision2.xlsx");		
		
		Cell data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(2);
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
