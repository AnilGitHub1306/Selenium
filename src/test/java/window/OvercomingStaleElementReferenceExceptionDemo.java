package window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OvercomingStaleElementReferenceExceptionDemo {

	 public static void main(String[] args) throws InterruptedException {
		    
		    ChromeDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://omayo.blogspot.com/");
		    
		    int size = driver.findElements(By.xpath("//div[@id='LinkList1']//a")).size();
		    
		    for(int i=1;i<=size;i++) {
		      String xpathText = "(//div[@id='LinkList1']//a)["+i+"]";
		      WebElement element = driver.findElement(By.xpath(xpathText));
		      element.click();
		      Thread.sleep(3000);
		      driver.navigate().back();
		    }
		  
		  }
}
