package toolTip;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tooltip_Handling 
{
	@Test
	public void tooltip_Handlig()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/tool-tips");
		
		WebElement tooltipButton = driver.findElement(By.xpath("//*[@id='toolTipButton']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", tooltipButton);
		
		tooltipButton.click();
		
		WebElement tooltipMsg = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
		System.out.println(tooltipMsg.isDisplayed());
		String actualToolTipMsg = tooltipMsg.getText();
		String expectesTooltipMsg = "You hovered over the Button";
		
		Assert.assertEquals(actualToolTipMsg, expectesTooltipMsg);
		
		System.out.println("TC Pass for tooltip ");
	}

}
