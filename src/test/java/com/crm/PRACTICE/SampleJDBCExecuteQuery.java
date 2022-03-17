package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	@Test
	public void sampleJDBCExecuteQuery() throws Throwable
	{
		Connection con = null;
		try
		{
		//step 1: Register the database
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
			System.out.println(result.getString(1)+"\t "+result.getString(2)+"\t "+result.getString(3));
		}
		}
		catch(Exception e)
		{
			//handle exception
		}
		
		//step 5: close the database
		finally {
		con.close();
		System.out.println("Connetion closed");
		}
	}

}
