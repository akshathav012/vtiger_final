package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrgwithIndustryTypeTest extends BaseClass{
	@Test(groups="regressionSuite")
	public void createOrgwithIndustryTypeTest() throws Throwable
	{
		String ORGNAME = eLib.readDataFromExcel("org", 4, 2)+" "+jLib.getRandomNumber();
		String INDTYPE = eLib.readDataFromExcel("org", 4, 3);
		
        HomePage hp = new HomePage(driver);
        hp.clickOnOrgLnk();
        
        OrganizationsPage op = new OrganizationsPage(driver);
        op.clickOnCreateOrgImg();
      //  Assert.fail();
        
        CreateOrganizationPage cop = new CreateOrganizationPage(driver);
        cop.createNewOrganization(ORGNAME, INDTYPE);
        
        OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgHeader = oip.OrgNameInfo();
		
		if(actOrgHeader.contains(ORGNAME))
			System.out.println(actOrgHeader+"---->data Verified");
		else
			System.out.println("data invalid");
		
		
	}

}
