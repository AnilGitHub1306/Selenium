package fileHandling;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class WriteDataToTEXTFile 
{
	public static void main(String[] args) throws IOException 
	{
		
		File f = new File("./testData/TextOne.text");
		FileWriter fr = new FileWriter(f);   //true- doesn't replace existing data 								   //false - Replace the existing data

		fr.write("dsjbfhaslh");

		fr.flush();
		System.out.println("done");
	}
}
