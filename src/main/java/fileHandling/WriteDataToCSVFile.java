package fileHandling;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class WriteDataToCSVFile 
{
	public static void main(String[] args) throws IOException 
	{
		
		File f = new File("./testData/CSVOne2.csv");
		FileWriter fr = new FileWriter(f);   //true- doesn't replace existing data 								   //false - Replace the existing data

		CSVWriter writer = new CSVWriter(fr);
		
		String data1[]= {"URL","https://google.com"};
		String data2[]= {"UserName","admin"};
		String data3[]= {"Password","123"};
		
		writer.writeNext(data1);
		writer.writeNext(data2);
		writer.writeNext(data3);
		
		writer.flush();
		System.out.println("done");
	}
}


