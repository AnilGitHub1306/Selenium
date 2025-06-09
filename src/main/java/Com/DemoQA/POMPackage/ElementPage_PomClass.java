package Com.DemoQA.POMPackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementPage_PomClass 
{
private WebDriver driver;
	
	@FindBy(xpath="(//li[@id='item-0'])[1]") private WebElement TextBox;
	@FindBy(xpath="(//li[@id='item-1'])[1]") private WebElement CheckBox;
	@FindBy(xpath="(//li[@id='item-2'])[1]") private WebElement RadioButton;
	@FindBy(xpath="(//li[@id='item-3'])[1]") private WebElement WebTables;
	@FindBy(xpath="(//li[@id='item-4'])[1]") private WebElement Buttons;
	@FindBy(xpath="(//li[@id='item-5'])[1]") private WebElement Links;
	@FindBy(xpath="(//li[@id='item-6'])[1]") private WebElement BrokenLinksImages;
	@FindBy(xpath="(//li[@id='item-7'])[1]") private WebElement UploadandDownload;
	@FindBy(xpath="(//li[@id='item-8'])[1]") private WebElement DynamicProperties;
	
	public void clickTextBox() {TextBox.click();}
	public void clickCheckBox() {CheckBox.click();}
	public void clickRadioButton() {RadioButton.click();}
	public void clickWebTables() {WebTables.click();}
	public void clickButtons() {Buttons.click();}
	public void clickLinks() {Links.click();}
	public void clickBrokenLinksImages() {BrokenLinksImages.click();}
	public void clickUploadandDownload() {UploadandDownload.click();}
	public void clickDynamicProperties() {DynamicProperties.click();}
	
	@FindBy(xpath="//input[@id='userName']") private WebElement FullName;
	public void putFullName() {FullName.sendKeys("Mr. Raghu Suryawanshi");}
	@FindBy(xpath="//input[@id='userEmail']") private WebElement Email;
	public void putEmail() {Email.sendKeys("RaghuSuryawanshi@gmail.com");}
	@FindBy(xpath="//textarea[@id='currentAddress']") private WebElement CurrentAddress;
	public void putCurrentAddress() {CurrentAddress.sendKeys("RH 12 ,Gowing Society, Delhi 436478");}
	@FindBy(xpath="//textarea[@id='permanentAddress']") private WebElement PermanentAddress;
	public void putPermanentAddress() {PermanentAddress.sendKeys("RH 12 ,Gowing Society, Delhi 436478");}
	@FindBy(xpath="//button[@id='submit']") private WebElement Submit;
	public void clickSubmit() {Submit.click();}
	@FindBy(xpath="//div[@class='border col-md-12 col-sm-12']") private WebElement SubmitFeedback;
	public boolean SubmitFeedbackPresent() {SubmitFeedback.isDisplayed(); return true;}
	
	@FindBy(xpath="//*[@id=\"tree-node\"]/ol/li/span/label") private WebElement Home;
	public void clickHomeButton() throws InterruptedException 
	{	Thread.sleep(8000);
		if(Home.isSelected()==true)
		{System.out.println("initialy home is selected");}
		else 
		{Home.click();}}
	@FindBy(xpath="//*[@id=\"result\"]/span[1]") private WebElement Feedback;
	public boolean youhaveselectedFeedback()
	{Feedback.isDisplayed(); return true;}
	
	@FindBy(xpath="(//div[@class='custom-control custom-radio custom-control-inline'])[1]") private WebElement RadioButtonYes;
	public void clickRadioButtonYes() 
	{if(RadioButtonYes.isEnabled()==true && RadioButtonYes.isSelected()==false)
       {RadioButtonYes.click();}
	else
	   {System.out.println("Radio button yes is enabled");}}
	
	
	@FindBy(xpath="(//div[@class='custom-control custom-radio custom-control-inline'])[2]") private WebElement RadioButtonImpressive;
	public void clickRadioButtonImpressive() 
	{if(RadioButtonImpressive.isEnabled()==true && RadioButtonImpressive.isSelected()==false)
       {RadioButtonImpressive.click();}
	else
	   {System.out.println("Radio button Impressive is enabled");}}
	
	
	@FindBy(xpath="//div[@class='custom-control disabled custom-radio custom-control-inline']") private WebElement RadioButtonNo;
	public void clickRadioButtonNo() 
	{if(RadioButtonNo.isEnabled()==true && RadioButtonNo.isSelected()==false)
       {RadioButtonNo.click();}
	else
	   {System.out.println("Radio button No is enabled");}}
	
//Link
	@FindBy(tagName="a") private List<WebElement> links1;
//	List<WebElement> links1 = driver.findElements(tagname("a"));
	int brokenlink=0;
	public int brockenlinks() throws Exception
	{	
		for(WebElement i:links1)
		{
			String url = ((WebElement) links1).getAttribute("href");
		
		if(url==null || url.isEmpty())
			{System.out.println("link is empty");}
		else 
			{URL url1 = new  URL(url);
			HttpURLConnection httpocon =(HttpURLConnection) url1.openConnection();
			httpocon.connect();
			
			if(httpocon.getResponseCode()>=400) 
			{System.out.println(httpocon.getResponseCode()+" status code for link   "+links1+" - which is brocken link");brokenlink++;}
		else
			{System.out.println(httpocon.getResponseCode()+" status code for link   "+links1+"  - which is normal link");}	
			}
		}
		
		System.out.println("Number of broken links - "+ brokenlink);
		return 4;
	}
	
	
	
	
	
	
	
	
	private By tagname(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public ElementPage_PomClass (WebDriver driver)
	{this.driver = driver; 
	 PageFactory.initElements(driver, this);}
}
