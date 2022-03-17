package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	//declaration
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	public void createNewProduct(String prodName)
	{
		productNameEdt.sendKeys(prodName);
		saveBtn.click();
	}

}
