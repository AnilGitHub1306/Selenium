package dropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ByGetOptionMethod {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

		WebElement dropDown = driver.findElement(By.xpath("//select [1]"));
		
		Select s= new Select(dropDown);
		
		List<WebElement> dropDownOptions = s.getOptions();
		
		boolean status = false;
		for(WebElement option :dropDownOptions ) 
		{
			
			System.out.println(option.getText());
			
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				System.out.println("India option selected");
				status = true;
				break;
			}	
		}
		
		if(status==true) 
		{
			System.out.println("Test case PASS : India option selected");
		}
		else {
			System.out.println("Test case FAILED :India option not available here");
		}
		
	}

}
