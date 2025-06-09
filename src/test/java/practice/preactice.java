package practice;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class preactice {

	public static void main(String[] args)
	{
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opned");
		
		Actions n = new Actions(driver) ;
		n.click().build().perform();
		n.clickAndHold(null).moveToElement(null).release().perform();
		;
	}
}
