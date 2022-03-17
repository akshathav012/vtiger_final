package com.crm.ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreateContactWithOrgNameAndLeadSourceTest extends BaseClass{
	@Test
	public void createContactWithOrgNameAndLeadSourceTest() throws Throwable
	{
		
		String lastName = eLib.readDataFromExcel("Contacts", 7, 2)+" "+jLib.getRandomNumber();
		String orgName = eLib.readDataFromExcel("Contacts", 7, 3)+" "+jLib.getRandomNumber();
		String leadSource = eLib.readDataFromExcel("Contacts", 7, 4);
						
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrganization(orgName);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.OrgNameInfo();
		if(orgHeader.contains(orgName))
			System.out.println(orgHeader+"--->Organization created");
		else
			System.out.println("Organization not created");
		
		hp.clickOnContactLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateConImg();
		
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createNewContact(driver, lastName, orgName, leadSource);
		
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String conHeader = cip.ContactNameInfo();
		if(conHeader.contains(lastName))
			System.out.println(conHeader+"--->contact created");
		else
			System.out.println("Contact not created");
		
		
	}

}
