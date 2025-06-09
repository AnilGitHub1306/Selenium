package date;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;
public class CurrentDate 
{
	@Test(priority=1)
	public void getCurrentDate()
	{Date d= new Date();
	System.out.println(d);}
	
	@Test(priority=2)
	public void getCurrentDate1()
	{Date d= new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd & hh-mm-ss");
	String date = sdf.format(d);
	System.out.println(date);}
	
	@Test(priority=3)
	public void getCurrentDate2()
	{Date d= new Date();
	
	System.out.println(d.getDate()+" getDate");
	System.out.println(d.getDay()+" getDay");
	System.out.println(d.getHours()+" getHours");
	System.out.println(d.getHours()+" getHours");
	System.out.println(d.getMonth()+" getMonth");
	System.out.println(d.getSeconds()+" getSeconds");
	System.out.println(d.getTime()+" getTime");
	System.out.println(d.getTimezoneOffset()+" getTimezoneOffset");
	System.out.println(d.getYear()+" getYear");
	System.out.println(d.toGMTString()+" toGMTString");
	System.out.println(d.toLocaleString()+" toLocaleString");}
}
