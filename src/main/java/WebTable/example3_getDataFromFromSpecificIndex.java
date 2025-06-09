package WebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class example3_getDataFromFromSpecificIndex
{
	public static void main(String[] args) throws InterruptedException 
	{		
		WebDriver driver=new ChromeDriver();
		driver.get("file:///D:/Daily%20Examples/Revision%20Session2/Selenium/Html%20Files/webtable.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();		
		
		String value = driver.findElement(By.xpath("//table[@id='1234']//tr[4]/td[2]")).getText();
		System.out.println(value);
				
		
		//header
		String value1 = driver.findElement(By.xpath("//table[@id='1234']//tr[1]/th[3]")).getText();
		System.out.println(value1);
	}
}
