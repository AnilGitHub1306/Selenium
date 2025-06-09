package fileDownloadUpLoad;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fileUploadWhenUploadDialogcome {

    @Test
    public void fileUpload() throws AWTException, InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // optional

        System.out.println("Browser opened");

        driver.get("https://www.ilovepdf.com/edit-pdf");
        System.out.println("URL opened");

        WebElement uploadButton = driver.findElement(By.xpath("//a[@id='pickfiles']"));
        System.out.println("Upload button found");
        uploadButton.click();

        // Wait for file upload dialog to appear
        Thread.sleep(2000);

        // Prepare the file path
        String filePath = System.getProperty("user.dir") + File.separator + "testData" + File.separator + "SysConfig.pdf";
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Use Robot to paste path and press Enter
        Robot robot = new Robot();
        robot.delay(1000); // wait for dialog

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        System.out.println("File path pasted");

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("File uploaded");
    }
}
