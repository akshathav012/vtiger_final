package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	//declaration
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProdLookUpImg;
	
	//initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateProdLookUpImg() {
		return createProdLookUpImg;
	}
	
	//business library
	public void clickOnCreateProdImg()
	{
		createProdLookUpImg.click();
	}
	

}
