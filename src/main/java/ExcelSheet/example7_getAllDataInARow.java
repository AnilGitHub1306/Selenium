package ExcelSheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class example7_getAllDataInARow
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("D:\\Daily Examples\\Revision Session2\\SeleniumRevision2.xlsx");		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		int lastCellIndex = sh.getRow(0).getLastCellNum()-1;
		
		for(int i=0; i<=lastCellIndex; i++)
		{
			Cell data = sh.getRow(0).getCell(i);
			CellType s1 = data.getCellType();
			
			if(s1==CellType.STRING)
			{
				System.out.print(data.getStringCellValue()+" ");
			}
			else if (s1 == CellType.NUMERIC) 
			{
				System.out.print(data.getNumericCellValue()+" ");
			}
			else if (s1 == CellType.BOOLEAN) 
			{
				System.out.print(data.getBooleanCellValue()+" ");
			}
	}
}
	
}
