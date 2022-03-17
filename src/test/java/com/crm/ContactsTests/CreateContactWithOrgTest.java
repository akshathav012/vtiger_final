package com.crm.ContactsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass {
	@Test
	public void createContactWithOrgTest() throws Throwable
	{
		
		String LASTNAME = eLib.readDataFromExcel("contacts", 4, 2)+" "+jLib.getRandomNumber();
		String ORGNAME = eLib.readDataFromExcel("contacts", 4, 3)+" "+jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.OrgNameInfo();
		if(orgHeader.contains(ORGNAME))
			System.out.println(orgHeader+"----->Organization created");
		else
			System.out.println("Organization not created");
		
		
		hp.clickOnContactLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateConImg();
		
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createNewContact(driver, LASTNAME, ORGNAME);
		
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String conHeader = cip.ContactNameInfo();
		if(conHeader.contains(LASTNAME))
			System.out.println(conHeader+"---->Contact created");
		else
			System.out.println("contact not created");
		
		
		
	}

}
