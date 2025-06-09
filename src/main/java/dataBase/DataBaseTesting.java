package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBaseTesting {

	@Test
	public void dataBaseTesting() throws Throwable {
		// Port Number = 3306
		// DataBase Name = openshop
		// User Name = root
		// Password = admin123
		String cus_firstname = "Ram";
		String cus_lastname = "Jadhav";
		String cus_city = "Nashik";

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testerdb", "root", "Anil@007");
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select FirstName, LastName, city from employee;");

		boolean status = false;

		while (rs.next()) {
			String FirstName = rs.getString("FirstName");
			String LastName = rs.getString("LastName");
			String city = rs.getString("city");

			if (cus_firstname.equals(FirstName) && cus_lastname.equals(LastName)
					&& cus_city.equals(city)) {
				System.out.println("Record found in the table || Test Pass");
				status = true;
				break;
			}
		}
		if (status == false) {
			System.out.println("Record not found || Test Failed");
		}
		
	}
}
