package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.SetOfIntegerSyntax;

import org.testng.annotations.Test;

public class TC16_curruntdate 
{
	@Test
	public void CurrentDate()
	{
		Date d = new Date();
		
		System.out.println(d);
		SimpleDateFormat sdp = new SimpleDateFormat("YYYY.MM.dd_hh:mm:ss");
		
		String date = sdp.format(d);
		System.out.println(date);
		
	}
}
