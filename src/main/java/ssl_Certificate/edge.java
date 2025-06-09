package ssl_Certificate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class edge {

	 public static void main(String[] args) throws Exception {
	        WebDriverManager.edgedriver().setup();

	        // Create instance of EdgeOptions
	        EdgeOptions options = new EdgeOptions();
	        
	        // Ignore SSL certificate errors
	        //options.addArguments("--ignore-certificate-errors");
	        options.setAcceptInsecureCerts(true);

	        // Launch Edge with options
	        WebDriver driver = new EdgeDriver(options);
	        
	        // Open a website with SSL certificate error
	        driver.get("https://expired.badssl.com/");
	        
	        Thread.sleep(3);
	        // Close the browser
	        driver.quit();
	    }

}
