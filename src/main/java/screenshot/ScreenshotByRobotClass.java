package screenshot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotByRobotClass {
	
	public static void main(String[] args) throws AWTException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Robot robot = new Robot();
		Dimension diamension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(diamension);
		BufferedImage bufferimage = robot.createScreenCapture(rect);
		
		String path = System.getProperty("user.dir")+"\\screenshot\\imageName.png";
		ImageIO.write(bufferimage, "png", new File(path));
	
		driver.quit();
	}

	
}
