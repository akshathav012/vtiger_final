package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice1 {
	
	@Test(dataProvider="getData1")
	public void DataProvider(int id, String name)
	{
		System.out.println(id+"---"+name);
	}
	
	@DataProvider
	public Object[][] getData1()
	{
		Object[][] obj = new Object[6][2];
		
		obj[0][0]=1;
		obj[0][1]="Aks";
		
		obj[1][0]=2;
		obj[1][1]="Ash";
		
		obj[2][0]=3;
		obj[2][1]="Anu";
		
		obj[3][0]=4;
		obj[3][1]="Ashu";
		
		obj[4][0]=5;
		obj[4][1]="Gayu";
		
		obj[5][0]=6;
		obj[5][1]="krish";
		
		return obj;
		
		
	}

}
