package CSV_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class read_CSV_File 
{

	@Test
	public void read_CSV_File() throws IOException, CsvValidationException
	{
		File f= new File("C:\\Users\\Anil\\git\\JunFirstWeek2023\\DataFiles\\data.csv");
		FileReader fr = new FileReader(f);
		CSVReader reader = new CSVReader(fr);
		String[] str;
		
		while((str=reader.readNext())!=null )
		{
		for(String s:str)
		{
			System.out.print(s+" ");
		}	
		System.out.println();
		}
		
	}
}
