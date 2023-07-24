package IFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleIFrameByIndex 
{
	String key= "webdriver.gecko.driver";
	String path= 
	"./Selenium/Driver/geckodriver.exe";
	String url= "https://mockzee.blogspot.com/2022/01/nested-iframe.html";
	static WebDriver l;
	static WebElement hi;
	public void nested_frame() throws InterruptedException
	{
	System.setProperty(key, path);
	l= new ChromeDriver();
	l.manage().window().maximize();
	l.get(url);
	hi=l.findElement(By.xpath("//iframe[@name='D54B85GFG8']"));
	l.switchTo().frame(hi);
	}
}
