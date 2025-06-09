package get_WebElements_color_backgroundColor_FontSize_FontColor_FontFamily_FontAllignment_HightlightFont;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Get_WebElements_color_backgroundColor_FontSize_FontColor_FontFamily_FontAllignment_HightlightFont 
{

	@Test()
	public void GetpropertiesofElement()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
	      // identify text
	    WebElement text = driver.findElement(By.tagName("h1"));
	    
	    System.out.println("color of text: "+text.getCssValue("color"));
	    System.out.println("background-color: "+text.getCssValue("background-color"));
	    System.out.println("font-size: "+text.getCssValue("font-size"));
	    System.out.println("font-family: "+text.getCssValue("font-family"));
	    System.out.println("text-align: "+text.getCssValue("text-align"));
	    System.out.println("font-weight: "+text.getCssValue("font-weight"));
	    
	    
	    driver.quit();
	    
	    
	}
}
