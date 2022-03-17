package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	
	
	
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	
	public WebElement getMoreLnk() {
		return moreLnk;
	}
	
	//business library
	public void clickOnOrgLnk()
	{
		organizationLnk.click();
	}
	
	public void clickOnContactLink()
	{
		contactsLnk.click();
	}
	
	public void clickOnMoreLnk()
	{
		moreLnk.click();
	}
	
	public void clickOnProductLnk()
	{
		productsLnk.click();
	}
	
	public void clickOnCampaignLnk()
	{
		campaignsLnk.click();
	}
	
	public void clickOnOpportunityLnk()
	{
		opportunitiesLnk.click();
	}
	
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, administratorImg);
		signOutLnk.click();
	}

	
	

}
