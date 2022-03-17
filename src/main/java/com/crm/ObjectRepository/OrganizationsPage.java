package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
    //Step 1: Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//Step 2: Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Step 3: utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//business libraries
	public void clickOnCreateOrgImg()
	{
		createOrgLookUpImg.click();
	}
	
	

}
