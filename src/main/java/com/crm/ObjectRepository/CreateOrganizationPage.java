package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
		
	//initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	//business libraries
	
	public void createNewOrganization(String orgName)
	{
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
		
	}
	
	public void createNewOrganization(String orgName, String IndType)
	{
		organizationNameEdt.sendKeys(orgName);
		select(IndType, industryDropDown);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with type dropdown and industry type dropdown
	 * @param orgName
	 * @param IndType
	 * @param TypeName
	 */
	public void createNewOrganization(String orgName, String IndType, String TypeName)
	{
		organizationNameEdt.sendKeys(orgName);
		select(IndType, industryDropDown);
		select(TypeName, typeDropDown);
		saveBtn.click();
	}
	
	
	
	
	

}
