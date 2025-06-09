package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PassTheData 
{
	@Test (dataProvider="dataToMethod")
	public void passTheValideData(String data1, String data2)
	{

		String userName =data1;
		String password =data2;
		System.out.println("UserName & Passowerd is - "+userName+ "  "+password);
	}
	
	@DataProvider(name="dataToMethod")
	public Object [][] senddatamethod()
	{
		Object[][]data = {{"admin","Test"},{"admin1","Test1"}};
		return data;

	}
	
	
	@Test(dataProvider="data")
	public void printUserNameAndPassword(String UserName, String password,String key)
	{
		System.out.println(UserName+" "+password+ " "+ key);
	}
	
	
	@DataProvider(name="data")
	public Object [][] setData()
	{
		Object[][]data = {{"admin0","Test0","1"},{"admin1","Test1","1"},{"admin3","Test3","1"},{"admin3","Test3","1"}};
		return data;

	}
}
