package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//business library
	
	/**
	 * This method will return the Contact header
	 * @return
	 */
	public String ContactNameInfo()
	{
		return headerText.getText();
	}
	
	
	
	
	
}
