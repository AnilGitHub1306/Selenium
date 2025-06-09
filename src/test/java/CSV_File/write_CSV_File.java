package CSV_File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class write_CSV_File 
{
	@Test
	public void write_CSV_File() throws IOException
	{
		FileWriter fr = new FileWriter("C:\\Users\\Anil\\git\\JunFirstWeek2023\\DataFiles\\data11.csv");
		
		BufferedWriter br = new BufferedWriter(fr);
		
		br.write("url : www.google.com");
		
		br.close();
		System.out.println("done");
		
	}
}
