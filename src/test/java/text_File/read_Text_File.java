package text_File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class read_Text_File 
{
	@Test
	public void read_Text_File() throws IOException
	{
		FileReader fr = new FileReader("C:\\Users\\Anil\\git\\JunFirstWeek2023\\DataFiles\\data.text");
		
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine();
		System.out.println(br.readLine());
		//br.close();
		//System.out.println("done");
		
	}
}
