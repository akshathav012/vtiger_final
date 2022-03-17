package com.crm.ObjectRepository;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility {
	//declaration
	@FindBy(name="potentialname")
	private WebElement OpportunityNameEdt;
	
	@FindBy(id = "related_to_type")
	private WebElement relatedToDropDown;
	
	@FindBy(name = "closingdate")
	private WebElement expectedCloseDataEdt;
	
	@FindBy(name ="sales_stage")
	private WebElement salesStageDropDown;
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img[@alt='Select']")
	private WebElement selectConLookUpImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name ="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	//initialization
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOpportunityNameEdt() {
		return OpportunityNameEdt;
	}

	public WebElement getRelatedToDropDown() {
		return relatedToDropDown;
	}

	public WebElement getExpectedCloseDataEdt() {
		return expectedCloseDataEdt;
	}

	public WebElement getSalesStageDropDown() {
		return salesStageDropDown;
	}

	public WebElement getSelectConLookUpImg() {
		return selectConLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	//business library
	public void createNewOpportunity(String oppName, String relatedTo, String contactName, String expCloseDate,WebDriver driver)
	{
		OpportunityNameEdt.sendKeys(oppName);
		select(relatedTo, relatedToDropDown);
		selectConLookUpImg.click();
		switchToWindow(driver, "Contacts");
		searchTextEdt.sendKeys(contactName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.=' "+contactName+"']")).click();
		switchToWindow(driver, "Potentials");
		expectedCloseDataEdt.clear();
		expectedCloseDataEdt.sendKeys(expCloseDate);
		saveBtn.click();
		
	
	}
	
	

}


