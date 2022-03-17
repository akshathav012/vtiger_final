package com.crm.PRACTICE;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingCalender {
	
    @Test(enabled = false)
    public void handlingCalender()
    {
    	String date = "13";
    	String monthAndYear = "April 2022";
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("https://www.makemytrip.com/");
    	Actions actions = new Actions(driver);
    	actions.moveByOffset(10, 10).click().perform();
    	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
    	String dateXpath = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
    	driver.findElement(By.xpath(dateXpath)).click();
    	
    }
    
    @Test(enabled = false)
    public void handleFutureMonths()
    {
    	String date = "22";
    	String monthAndYear = "December 2022";
    	
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("https://www.makemytrip.com/");
    	
    	Actions actions = new Actions(driver);
    	actions.moveByOffset(10, 10).click().perform();
    	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
    	String dateXpath = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
    	String arrowXpath = "//span[@aria-label='Next Month']";
    	
    	for(;;)
    	{
    		try {
				driver.findElement(By.xpath(dateXpath)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath(arrowXpath)).click();
			}
    	}
   }
    
    @Test(enabled = false)
    public void goibibo()
    {
    	String date = "10";
    	String monthAndYear = "April 2022";
    	
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("https://www.goibibo.com/");
    	
    	driver.findElement(By.xpath("//span[.='Departure']")).click();
    	String dateXpath="//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
    	driver.findElement(By.xpath(dateXpath)).click();
    	driver.findElement(By.xpath("//span[.='Done']")).click();
  	
    	
    	
    }
    
    @Test
    public void selectCurrentDate()
    {
    	Date d = new Date();
    	String currentDate = d.toString();
    	System.out.println(currentDate);
    	System.out.println(d);
    	
    	/*String date = "13";
    	String monthAndYear = "April 2022";
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("https://www.makemytrip.com/");
    	Actions actions = new Actions(driver);
    	actions.moveByOffset(10, 10).click().perform();
    	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
    	String dateXpath = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
    	driver.findElement(By.xpath(dateXpath)).click();*/
    }

}
