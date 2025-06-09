package fileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;

public class ReadDataFromCSVFile {
	//@Test
	public void readDataFromCSV_Textfile() throws Exception {
		File f = new File("./testData/new.csv");
		FileReader fr = new FileReader(f);
		CSVReader reader = new CSVReader(fr);

		String[] str;

		while ((str = reader.readNext()) != null) {
			for (String s : str) {
				System.out.println(s);
			}
		}
	}

	@Test
	public void readDataFromCSV_Textfile1() throws Exception 
	{
		File f = new File("./testData/Textone.text");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		String str=br.readLine();
		
		while (str != null) 
			{
			  System.out.println(str);
			  str=br.readLine();
			}
	}
}
