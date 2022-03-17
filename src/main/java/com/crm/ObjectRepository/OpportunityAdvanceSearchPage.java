package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OpportunityAdvanceSearchPage extends WebDriverUtility {
	//declaration
	@FindBy(id="fcol0")
	private WebElement searchFieldDropDown;
	
	@FindBy(id="fop0")
	private WebElement searchContainsDropDown;
	
	@FindBy(id="fval0")
	private WebElement searchEdt;
	
	@FindBy(xpath="//table[@class='searchUIAdv3 small']//input[1]")
	private WebElement searchNowBtn;
	
	//initialization
	public OpportunityAdvanceSearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getSearchFieldDropDown() {
		return searchFieldDropDown;
	}

	public WebElement getSearchContainsDropDown() {
		return searchContainsDropDown;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	


	
	//business library
	public void searchNew(String searchField, String searchContains, String value)
	{
		select(searchFieldDropDown, searchField);
		select(searchContainsDropDown, searchContains);
		searchEdt.sendKeys(value);
		searchNowBtn.click();
	}
	
	public void searchNow(String searchField)
	{
		select(searchFieldDropDown, searchField);
		searchNowBtn.click();
	}

	
	

}
