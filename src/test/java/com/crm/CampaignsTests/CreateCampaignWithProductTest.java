package com.crm.CampaignsTests;

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
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest extends BaseClass {
	@Test
	public void createCampaignWithProductTest() throws Throwable
	{
		
		String CampaignName = eLib.readDataFromExcel("Campaign", 1, 2)+"_"+jLib.getRandomNumber();
		String ProductName = eLib.readDataFromExcel("Campaign", 1, 3)+" "+jLib.getRandomNumber();
		
		
		HomePage hp = new HomePage(driver);
		hp.clickOnProductLnk();
		
		ProductPage pp = new ProductPage(driver);
		pp.clickOnCreateProdImg();
		
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createNewProduct(ProductName);
		
		ProductInfoPage pip = new ProductInfoPage(driver);
		String prodHeader = pip.productInfo();
		if(prodHeader.contains(ProductName))
			System.out.println(prodHeader+"---->Product created");
		else
			System.out.println("Product not created");
		
		hp.clickOnMoreLnk();
		hp.clickOnCampaignLnk();
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnCreateCampaignImg();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createNewCampaign(driver, CampaignName, ProductName);
		
		CampaignInfoPage cip = new CampaignInfoPage(driver);
		String campHeader = cip.campaignInfo();
		if(campHeader.contains(CampaignName))
			System.out.println(campHeader+"---->Campaign created");
		else
			System.out.println("Campaign not created");
		

		 
		
		
		
		
		
		
		
		
	}

}
