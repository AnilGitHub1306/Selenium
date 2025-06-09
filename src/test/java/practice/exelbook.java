package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class exelbook 
{
public static void main(String[] args) throws IOException, SQLException 
{
	FileInputStream f= new FileInputStream("C:\\Users\\admin\\Desktop\\aaaaa.xlsx");
	XSSFWorkbook z=new XSSFWorkbook(f);
	String a =z.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
	String b =new XSSFWorkbook(f).getSheet("sheet1").getRow(1).getCell(1).getStringCellValue();
	
	int c= new XSSFWorkbook(f).getSheet("sheet1").getFirstRowNum();
	int d= new XSSFWorkbook(f).getSheet("sheet1").getLastRowNum();
	
	int e =z.getSheet("sheet1").getRow(0).getFirstCellNum();
	int g =z.getSheet("sheet1").getRow(0).getLastCellNum();
			
System.out.println(a);
//System.out.println(b);
//	System.out.println(c);
//	System.out.println(d);
	
//	System.out.println(e);
//	System.out.println(g);
	WebDriver driver=new ChromeDriver();
	Actions s= new Actions(driver);
	
	
	//
	
	WebElement src= driver.findElement (By.id("dfdsff"));
	WebElement tar= driver.findElement (By.id("dfdsff"));
	
	//s.sendKeys(Keys.ARROW_UP).
	s.dragAndDropBy(src, 234, 43).perform();
	s.clickAndHold(src).moveToElement(tar).release().perform();
	s.clickAndHold(src).release(tar).perform();
	s.clickAndHold(src).moveByOffset(234, 43).release().perform();
	
	
	src.getLocation();
	src.getLocation().getX();
	src.getLocation().getY();
	src.getRect().getX();
	src.getRect().getY();
	
	List<WebElement> lists= driver.findElements(By.xpath("dhfksdfh"));

	Select ss = new Select(tar) ;
	ss.getOptions();
	
	Connection con = DriverManager.getConnection(b, b, a);
	
	Statement t =con.createStatement();
	
	ResultSet r = t.executeQuery(b);
	
	
	
	
}
}
