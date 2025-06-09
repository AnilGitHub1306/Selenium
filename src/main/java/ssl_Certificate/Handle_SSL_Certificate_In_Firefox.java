package ssl_Certificate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_SSL_Certificate_In_Firefox 
{
	@Test
	public void handle_SSL_Certificate_In_Firefox () throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions op = new FirefoxOptions();
		op.setAcceptInsecureCerts(true);
	//	op.addArguments("--ignore-certificate-errors");
	//	op.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://self-signed.badssl.com");
		System.out.println("url opened");
		Thread.sleep(5000);
		driver.quit();
	}
}
