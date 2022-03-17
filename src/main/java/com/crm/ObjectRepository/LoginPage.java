package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration using FindBy annotation
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	//Initialization using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization using getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPaswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business library
	public void loginToApp(String userName, String passWord)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(passWord);
		submitBtn.click();
	}
	
	
	
	
	
	

}
