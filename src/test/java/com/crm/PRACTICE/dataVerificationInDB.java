package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class dataVerificationInDB {
	       @Test
		public void sampleJDBCExecuteQuery() throws Throwable
		{
	    	String expectedData = "anusha";
			Connection con = null;
			try
			{
			//step 1: register the database
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//step 2: get connection from database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			System.out.println("Connection established");
			
			//step 3: issue create statement
			Statement state = con.createStatement();
			
			//step 4: execute a query
			ResultSet result = state.executeQuery("select * from student");
			while(result.next())
			{
			
				String actualData = result.getString(2);
				if(expectedData.equalsIgnoreCase(actualData))
				{
				System.out.println(actualData+" Data verified");
				}
				
			}
			}
			catch(Exception e)
			{
				//handle exception
			}
			
			//step 5: close the database
			finally {
			con.close();
			System.out.println("Connection closed");
			}
		}

	

}
