package com.crm.OpportunitiesTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunityWithContactAndCampaignTest {
	
	@Test
	public void createOpportunityWithContactAndCampaignTest() throws Throwable
	{
		JavaUtility jLib = new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		PropertyFileUtility pLib = new PropertyFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		//fetch data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		//generate random number
		int rNum = jLib.getRandomNumber();
		
		//fetch data from excel
		String lastName = eLib.readDataFromExcel("opportunity", 1, 7)+" "+rNum;
		String campaignName = eLib.readDataFromExcel("opportunity", 1, 8)+" "+rNum;
		String opportunityName = eLib.readDataFromExcel("opportunity", 1, 2)+" "+rNum;
		String RelatedTo = eLib.readDataFromExcel("opportunity", 1, 3);
		String LeadSource = eLib.readDataFromExcel("opportunity", 1, 9);
		
		//launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("Invalid Browser");
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//create contacts
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify contacts 
		String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(conHeader.contains(lastName))
			System.out.println(conHeader+" contact created");
		else
			System.out.println("contact not created");
		
      	//navigate to more
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wLib.mouseHover(driver, more);
		driver.findElement(By.linkText("Campaigns")).click();
		
		//create campaign
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify campaign
		String camHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(camHeader.contains(campaignName))
			System.out.println(camHeader+" campaign created");
		else
			System.out.println("campaign not created");
		
		//Create opportunity with mandatory fields
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(opportunityName);
		
		WebElement relateToDropdown = driver.findElement(By.id("related_to_type"));
		wLib.select(RelatedTo, relateToDropdown);
		
		driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img[@alt='Select']")).click();
		                              
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(lastName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(lastName)).click();
		wLib.switchToWindow(driver, "Potentials");
		
		WebElement LeadSourceDropDown = driver.findElement(By.name("leadsource"));
		wLib.select(LeadSource, LeadSourceDropDown);
		
		driver.findElement(By.xpath("//input[@name='campaignname']/following-sibling::img[@alt='Select']")).click();
		wLib.switchToWindow(driver, "Campaigns");
		driver.findElement(By.name("search_text")).sendKeys(campaignName);
		driver.findElement(By.linkText(campaignName)).click();
		wLib.switchToWindow(driver, "Potentials");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify opportunity or not
		String oppHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(oppHeader.contains(opportunityName))
			System.out.println(oppHeader+" opportunity created");
		else
			System.out.println("opportunity not created");
		
		//sign out and close the browser
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, signOut);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		
		
	}
	
	

}
