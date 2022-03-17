package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class POMPracticeForLogin {
	
	@Test
	public void pomPractice()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin","admin");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
		hp.signOutOfApp(driver);
	}

}
