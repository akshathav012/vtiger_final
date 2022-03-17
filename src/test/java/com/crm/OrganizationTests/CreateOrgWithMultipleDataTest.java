package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateOrgWithMultipleDataTest {
	
	WebDriverUtility wLib = new WebDriverUtility();
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	JavaUtility jLib = new JavaUtility();
	
	@Test(dataProvider = "OrgtestData" )
	public void createOrgWithMultipleDataTest(String orgName, String indType ) throws Throwable
	{
		//read data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		orgName = orgName+jLib.getRandomNumber();
		
		//launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("Invalid browser");
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("Login successful",true);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		Reporter.log("Navigated to org link",true);
		
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Clicked on create org Lookup image",true);
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrganization(orgName, indType);
		Reporter.log("Create org with ind type",true);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actHeader = oip.OrgNameInfo();
		if(actHeader.contains(orgName))
			System.out.println("passed");
		else
			System.out.println("failed");
		Reporter.log("verification successful",true);
		
		hp.signOutOfApp(driver);
		driver.quit();
			
	}
	
	@DataProvider(name = "OrgtestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readMultipleDataFromExcel("OrgMultipleData");
		return data;
	}

}
