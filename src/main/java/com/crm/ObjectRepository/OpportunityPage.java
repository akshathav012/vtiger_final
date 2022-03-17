package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OpportunityPage extends WebDriverUtility {
	//declaration
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createOrgLookupImg;
	
	@FindBy(xpath = "//a[.='Go to Advanced Search']")
	private WebElement goToadvSearchLnk;
	
	
	//initialization
	public OpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	
	public WebElement getGoToadvSearchLnk() {
		return goToadvSearchLnk;
	}

	//business library
	public void clickOnCreateOpportunityImg()
	{
		createOrgLookupImg.click();
	}
	
	
}