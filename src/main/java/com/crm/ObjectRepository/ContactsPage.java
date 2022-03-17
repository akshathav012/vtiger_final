package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookupImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	
	//business library
	/**
	 * This method will click on create contact lookup image
	 */
	public void clickOnCreateConImg()
	{
		createContactLookupImg.click();
	}
	

}
