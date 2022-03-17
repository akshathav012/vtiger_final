package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name = "campaignname")
	private WebElement campaignNameEdt;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement selectProductLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn ;
	
	//initialization
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCampaignNameEdt() {
		return campaignNameEdt;
	}

	public WebElement getSelectProductLookUpImg() {
		return selectProductLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	public void createNewCampaign(WebDriver driver, String campaignName, String ProductName)
	{
		campaignNameEdt.sendKeys(campaignName);
		selectProductLookUpImg.click();
		switchToWindow(driver, "Products");
		searchTextEdt.sendKeys(ProductName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ProductName+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
	}
	
	
	
	

}
