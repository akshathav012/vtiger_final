package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
	public void sampleJDBCExecuteQuery() throws Throwable
	{
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
		int result = state.executeUpdate("insert into student values(5,'anusha','female')");
		if(result==1)
		{
			System.out.println("Updated successfully");
		}
		else
		{
			System.out.println("Updation failed");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		//step 5: close the database
		finally {
		con.close();
		System.out.println("Connection closed");
		}
	}


}
