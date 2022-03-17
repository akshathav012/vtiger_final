package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	//declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerText;
	
	
	//initialization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//business library
	public String productInfo()
	{
		return headerText.getText();
	}
	

}
