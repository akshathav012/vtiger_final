package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void sampleDataProvider(String name, String model, int qty)
	{
		System.out.println(name+"----"+model+"----"+qty);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[4][3];
		
		obj[0][0] = "Mi";
		obj[0][1] = "13 pro max";
		obj[0][2] = 15;
		
		obj[1][0] = "samsung";
		obj[1][1] = "m21";
		obj[1][2] = 25;
		
		obj[2][0] = "vivo";
		obj[2][1] = "11 pro";
		obj[2][2] = 5;
		
		obj[3][0] = "iphone";
		obj[3][1] = "SE";
		obj[3][2] = 20;
		
		return obj;
		
		
	}

}
