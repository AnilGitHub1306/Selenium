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

public class dragAndDropBydifferentMethods 
{
	
	
@Test
	public void dragAndDrop() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		
		
		WebElement osloSrc = driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement etalytarg = driver.findElement(By.xpath("//div[text()='Italy']"));
		
		WebElement box2Src = driver.findElement(By.xpath("//div[@id='box2']"));
		WebElement Norwaytarg = driver.findElement(By.xpath("//div[text()='Norway']"));
		
		WebElement box3Src = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement SouthKoreatarg = driver.findElement(By.xpath("//div[text()='South Korea']"));
		
		Thread.sleep(2000);
		Actions act =new Actions(driver);
		
		//Method1 *************************
	//	dragAndDrop(driver,osloSrc,etalytarg);
	
		//Method2 ****************************
	//	act.clickAndHold(osloSrc).moveToElement(etalytarg).release().perform();
		
		//Method3 *****************************
	//	act.dragAndDrop(box2Src, Norwaytarg).perform();
	
	
		//Method4 *****************************
		
		String jsDragAndDrop = 
	            "function createEvent(typeOfEvent) {" +
	            " var event = document.createEvent(\"CustomEvent\");" +
	            " event.initCustomEvent(typeOfEvent, true, true, null);" +
	            " event.dataTransfer = {" +
	            "   data: {}," +
	            "   setData: function (key, value) { this.data[key] = value; }," +
	            "   getData: function (key) { return this.data[key]; }" +
	            " };" +
	            " return event;" +
	            "}" +
	            "function dispatchEvent(element, event, transferData) {" +
	            " if (transferData !== undefined) {" +
	            "   event.dataTransfer = transferData;" +
	            " }" +
	            " element.dispatchEvent(event);" +
	            "}" +
	            "function dragAndDrop(source, target) {" +
	            " var dragStartEvent = createEvent('dragstart');" +
	            " dispatchEvent(source, dragStartEvent);" +
	            " var dropEvent = createEvent('drop');" +
	            " dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);" +
	            " var dragEndEvent = createEvent('dragend');" +
	            " dispatchEvent(source, dragEndEvent, dragStartEvent.dataTransfer);" +
	            "}" +
	            "dragAndDrop(arguments[0], arguments[1]);";
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
//	    js.executeScript("function createEvent(typeOfEvent) {\n" 
//	    +"var event =document.createEvent(\"CustomEvent\");\n" 
//	    +"event.initCustomEvent(typeOfEvent,true, true, null);\n" 
//	    +"event.dataTransfer = {\n" +"data: {},\n" 
//	    +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" 
//	    +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" 
//	    +"return event;\n" +"}\n" +"\n" 
//	    +"function dispatchEvent(element, event,transferData) {\n" 
//	    +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" 
//	    +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" 
//	    +"} else if (element.fireEvent) {\n" 
//	    +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" 
//	    +"function simulateHTML5DragAndDrop(element, destination) {\n" 
//	    +"var dragStartEvent =createEvent('dragstart');\n" 
//	    +"dispatchEvent(element, dragStartEvent);\n" 
//	    +"var dropEvent = createEvent('drop');\n" 
//	    +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" 
//	    +"var dragEndEvent = createEvent('dragend');\n" 
//	    +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" 
//	    +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" 
//	    +"simulateHTML5DragAndDrop(source,destination);",box3Src, SouthKoreatarg);
	    
	    js.executeScript(jsDragAndDrop,box3Src, SouthKoreatarg);
	}
	
		
	
	
}
