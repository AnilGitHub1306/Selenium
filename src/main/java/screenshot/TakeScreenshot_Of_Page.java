package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot_Of_Page {
	
	public static String date() {
		Date d = new Date();
		String date = d.toString().replaceAll(" ", "").replaceAll(":", "");
		return date;
	}

	public static void main(String[] args) throws IOException
	{
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/accordian");
		
		WebElement formsDropDown = driver.findElement(By.xpath("//div[@class='element-group'][1]"));
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/formsDropDownPage"+date()+".png");
		FileHandler.copy(source, dest);
		
		driver.quit();
		
	}

}
