package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	
	@Test
	public void propertyfile() throws IOException
	{
		//step 1: read the file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//step 2: create obj of properties
		Properties pObj = new Properties();
		pObj.load(fis);
		//step 3:read the data
		String BROWSER = pObj.getProperty("browser");
		//verification
		System.out.println(BROWSER);
		String URL = pObj.getProperty("url") ;
		System.out.println(URL);
		String USERNAME = pObj.getProperty("username");
		System.out.println(USERNAME);
		String PASSWORD = pObj.getProperty("password");
		System.out.println(PASSWORD);
		
	}

}
