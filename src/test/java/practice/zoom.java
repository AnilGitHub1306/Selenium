package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class zoom 
{

	@Test
	public void zoom()
	{
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
//		driver.navigate().to("https://www.google.com/");
//		
//		
//	Actions actions = new Actions(driver);
//	//actions.keyDown(Keys.CONTROL).sendKeys("+").perform();

		 // Navigate to a website
        driver.get("https://www.example.com");

        // Find an element to measure its size
        WebElement element = driver.findElement(By.tagName("body"));
        Dimension initialSize = element.getSize();

        // Perform zoom in using JavaScript
        ((FirefoxDriver) driver).executeScript("document.body.style.zoom='150%'");

        // Find the element again after zooming
        WebElement elementAfterZoom = driver.findElement(By.tagName("body"));
        Dimension sizeAfterZoom = elementAfterZoom.getSize();

        // Calculate the zoom percentage
        int zoomPercentage = calculateZoomPercentage(initialSize, sizeAfterZoom);
        System.out.println(initialSize);
        System.out.println(sizeAfterZoom);
        System.out.println(zoomPercentage);
        // Check if the zoom percentage is within the expected range
        if (zoomPercentage == 100) {
            System.out.println("Zoom in operation successful.");
        } else {
            System.out.println("Zoom in operation unsuccessful.");
        }

        // Quit the WebDriver session
        driver.quit();
    }

    // Method to calculate the zoom percentage
    private static int calculateZoomPercentage(Dimension initialSize, Dimension sizeAfterZoom) {
        double widthRatio = (double) sizeAfterZoom.width / initialSize.width;
        double heightRatio = (double) sizeAfterZoom.height / initialSize.height;
        double averageRatio = (widthRatio + heightRatio) / 2;
        return (int) (averageRatio * 100);
		

	}
}
