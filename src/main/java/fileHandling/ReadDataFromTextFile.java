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

public class ReadDataFromTextFile
{
	@Test
	public void readDataFromCSV_Textfile() throws Exception 
	{		
		File f= new File("./testData/textFile.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String str;
		
		while((str=br.readLine())!=null )
		{
			System.out.println(str);
		}	
		
		br.close();
	}
}
