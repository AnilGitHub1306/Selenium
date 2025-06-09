package WebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class example2_getColsize
{
	public static void main(String[] args) throws InterruptedException 
	{		
		WebDriver driver=new ChromeDriver();
		driver.get("file:///D:/Daily%20Examples/Revision%20Session2/Selenium/Html%20Files/webtable.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();		
		
		List<WebElement> allCol = driver.findElements(By.xpath("//table[@id='1234']//tr[2]/td"));
		System.out.println(allCol.size());
		
		
		//header
		List<WebElement> allCol1 = driver.findElements(By.xpath("//table[@id='1234']//tr[1]/th"));
		System.out.println(allCol1.size());		
	}
}
