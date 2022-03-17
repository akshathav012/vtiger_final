package com.crm.ContactsTests;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass {
	@Test
	public void createContactTest() throws Throwable
	{
		
		String LASTNAME = eLib.readDataFromExcel("contacts", 1, 2)+" "+jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateConImg();
		
		//Assert.fail();
		
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createNewContact(LASTNAME);
		
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String header = cip.ContactNameInfo();
		if(header.contains(LASTNAME))
			System.out.println(header+"---> Contact created");
		
		else
			System.out.println("Contact not created");
		
		
		
		
	}

}
