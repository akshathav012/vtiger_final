package com.crm.OpportunitiesTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOpportunityPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OpportunityAdvanceSearchPage;
import com.crm.ObjectRepository.OpportunityInfoPage;
import com.crm.ObjectRepository.OpportunityPage;

public class CreateOpportunitySearchWithEndsWithTest extends BaseClass {

	@Test
	public void createOpportunityTest() throws Throwable
	{
		
		
		//read data from excel sheet
				String oppName = eLib.readDataFromExcel("opportunity", 1, 2)+"_"+jLib.getRandomNumber();
				String relatedTo = eLib.readDataFromExcel("opportunity", 1, 3);
				String expCloseDate = eLib.readDataFromExcel("opportunity", 1, 5);
				String lastName = eLib.readDataFromExcel("opportunity", 1, 7)+" "+jLib.getRandomNumber();
				
				//Create contacts with mandatory fields
				HomePage hp = new HomePage(driver);
				hp.clickOnContactLink();
				
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateConImg();
				
				CreateContactsPage ccp = new CreateContactsPage(driver);
				ccp.createNewContact(lastName);
				
				ContactsInfoPage cip = new ContactsInfoPage(driver);
				String conHeader = cip.ContactNameInfo();
				if(conHeader.contains(lastName))
					System.out.println(conHeader+"Data verified");
				else
					System.out.println("contact not created");
				
				//Create opportunity with mandatory fields
				hp.clickOnOpportunityLnk();
				
				OpportunityPage op = new OpportunityPage(driver);
				op.clickOnCreateOpportunityImg();
				
				CreateOpportunityPage cop = new CreateOpportunityPage(driver);
				cop.createNewOpportunity(oppName, relatedTo,lastName, expCloseDate, driver);
				
				
				//Verify created Opportunity 
				OpportunityInfoPage oip = new OpportunityInfoPage(driver);
				String oppHeader = oip.OppInfoName();
				if(oppHeader.contains(oppName))
					System.out.println(oppHeader+" opportunity created");
				else
					System.out.println("opportunity not created");
				
				//Go to advance search
				hp.clickOnOpportunityLnk();
				op.getGoToadvSearchLnk().click();
				
				OpportunityAdvanceSearchPage as = new OpportunityAdvanceSearchPage(driver);
				as.searchNow("Opportunity Name");
				
				//verify for alert pop-up
				String popupText = wLib.getAlertText(driver);
				if(popupText.equalsIgnoreCase("Opportunity Name Option cannot be empty"))
					System.out.println("Pop-up displayed!!!");
				Thread.sleep(5000);
				wLib.acceptAlert(driver);
				
				
				//search with contains
				as.searchNew("Opportunity Name", "ends with", oppName);
				Thread.sleep(5000);
		
				
	}

}
