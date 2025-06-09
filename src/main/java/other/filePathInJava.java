package other;

import java.io.File;
import java.io.IOException;

public class filePathInJava {

	public static void main(String[] args) throws IOException 
	{
		// File path in the machine
		File f = new File("G:\\Testing\\2 Java\\Java-Velocity\\Note\\Java_Combined.docx");
		System.out.println(f.exists());	
		
		// File path in the project
		
		File f1 = new File(System.getProperty("user.dir")+"/csvFile.csv");  
		System.out.println(f1.exists());
		System.out.println(f1);

		File f2 = new File("./csvFile.csv");  
		System.out.println(f2.exists());

	String currentProjectAdd =	System.getProperty("user.dir");
		File f3 = new File(currentProjectAdd+"/abc.text");
		f3.createNewFile();
		System.out.println(f3.exists());
		System.out.println(f3.getPath());
	
	}
}
