package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateOrganizationWithTypeAndIndustryTest extends BaseClass{
	
	@Test
	public void OrganizationWithTypeAndIndustryTest() throws Throwable
	{
	
	String orgName = eLib.readDataFromExcel("org", 7, 2)+" "+ jLib.getRandomNumber();
	String indType = eLib.readDataFromExcel("Org", 7, 3);
	String type = eLib.readDataFromExcel("org", 7, 4);
	
	
	HomePage hp = new HomePage(driver);
	hp.clickOnOrgLnk();
	
	OrganizationsPage op = new OrganizationsPage(driver);
	op.clickOnCreateOrgImg();
	
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
    cop.createNewOrganization(orgName, indType, type);
    
    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
    String header = oip.OrgNameInfo();
    if(header.contains(orgName))
    	System.out.println(header+"-----> Organization created");
    else
    	System.out.println("Organization not created");
    
   
	
	
		
	
	
	
	
	
	
	}
	
}
