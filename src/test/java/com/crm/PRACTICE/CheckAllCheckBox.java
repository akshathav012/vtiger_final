package com.crm.PRACTICE;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CheckAllCheckBox extends BaseClass{
	
	@Test(enabled = false)
	public void checkAllCheckBox() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		List<WebElement> allCheckBox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
		for (WebElement ele : allCheckBox) {
			ele.click();
			Thread.sleep(1000);
			
		}
		
	}
	
	@Test(enabled = false)
	public void printAllName() 
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		List<WebElement> allCheckBox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a[@title='Contacts']"));
		for (WebElement ele : allCheckBox) {
			String lastName = ele.getText();
			System.out.println(lastName);
			
			
		}
		
	}
	@Test(enabled=false)
	public void checkLastCheckBox() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		List<WebElement> allCheckBox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
		WebElement[] cbox = new WebElement[allCheckBox.size()];
		for(int i=0; i<allCheckBox.size();i++)
		{
			cbox[i] = allCheckBox.get(i);
		}
		
	     
	     Thread.sleep(2000);
		cbox[cbox.length-1].click();
		Thread.sleep(2000); 
		
		
		
	}
	
	@Test
	public void checkOn5thAndDelete() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		List<WebElement> allCheckBox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
		WebElement[] cboxArray = new WebElement[allCheckBox.size()];
		for(int i=0; i<cboxArray.length;i++)
		{
			cboxArray[i] = allCheckBox.get(i);
		}
		
		cboxArray[4].click();
		
		List<WebElement> del = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/a[.='del']"));
		WebElement[] delArray = new WebElement[allCheckBox.size()];
		for (int i = 0; i<delArray.length; i++) {
			delArray[i]=del.get(i);
			
		}
		Thread.sleep(5000);
		delArray[4].click();
		Thread.sleep(5000);
		wLib.acceptAlert(driver);
		Thread.sleep(5000);
		
	     
		
	}

}

















