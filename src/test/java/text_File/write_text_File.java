package text_File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class write_text_File 
{

	@Test
	public void write_Text_File() throws IOException
	{
		FileWriter fr = new FileWriter("C:\\Users\\Anil\\git\\JunFirstWeek2023\\DataFiles\\data1.text");
		
		BufferedWriter br = new BufferedWriter(fr);
		
		br.write("url : www.google.com"
				+ "");
		br.write("username : admin"
				+ "");
		br.write("password : admin123"
				+ "");
		br.close();
		System.out.println("done");
		
	}
	
}

