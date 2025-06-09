package dragAndDrop;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Method3_WithOutUstingActionsClass 
{
	
	
@Test
	public void dragAndDrop_WithOutUstingActionsClass() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/dragabble");
		
		driver.findElement(By.xpath("//a[@id='draggableExample-tab-axisRestriction']")).click();
		
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='restrictedX']"));
		WebElement distElement = driver.findElement(By.xpath("//div[@id='restrictedY']"));
		Thread.sleep(2000);
		Actions act =new Actions(driver);
		
		//Method1 *************************
		dragAndDrop(driver,sourceElement,distElement);
	
		//Method2 ****************************
	//	act.clickAndHold(sourceElement).moveToElement(distElement).release(distElement).perform();
		
		//Method3 *****************************
	//	act.dragAndDrop(sourceElement, distElement).perform();
	
	}

	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement destination ) throws Exception 
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    js.executeScript("function createEvent(typeOfEvent) {\n" 
	    +"var event =document.createEvent(\"CustomEvent\");\n" 
	    +"event.initCustomEvent(typeOfEvent,true, true, null);\n" 
	    +"event.dataTransfer = {\n" +"data: {},\n" 
	    +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" 
	    +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" 
	    +"return event;\n" +"}\n" +"\n" 
	    +"function dispatchEvent(element, event,transferData) {\n" 
	    +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" 
	    +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" 
	    +"} else if (element.fireEvent) {\n" 
	    +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" 
	    +"function simulateHTML5DragAndDrop(element, destination) {\n" 
	    +"var dragStartEvent =createEvent('dragstart');\n" 
	    +"dispatchEvent(element, dragStartEvent);\n" 
	    +"var dropEvent = createEvent('drop');\n" 
	    +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" 
	    +"var dragEndEvent = createEvent('dragend');\n" 
	    +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" 
	    +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" 
	    +"simulateHTML5DragAndDrop(source,destination);",source, destination);
	    Thread.sleep(1500);

	}
		
	
	
}
