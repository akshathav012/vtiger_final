package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//initialization
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//business library
	public String campaignInfo()
	{
		return headerText.getText();
	}
	
	
	
	
	

}
