package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class practiceForGenericUtils {
	@Test
	public void practice() throws Throwable
	{
		JavaUtility jLib = new JavaUtility();
		int ran =  jLib.getRandomNumber();
		String dat = jLib.getSystemDate();
		String date = jLib.getSystemDateInFormat();
		System.out.println(ran);
		System.out.println(dat);
		System.out.println(date);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String browser = pLib.readDataFromPropertyFile("browser");
		System.out.println(browser);
		
		
		
	}

	
}


