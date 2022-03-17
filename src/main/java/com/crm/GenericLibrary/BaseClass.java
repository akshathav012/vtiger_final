package com.crm.GenericLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//Create object of all utilities
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	
	@BeforeSuite(groups= {"smokeSuite","regressionSuite"})
	public void connectDataBase() throws Throwable
	{
		//dLib.connectToDB();
		Reporter.log("====db connection successful====",true);
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups= {"smokeSuite","regressionSuite"})
	public void LaunchTheBrowser() throws Throwable
	{
		//read data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		//create RunTime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		sDriver = driver;
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("===Browser launch successful===",true);
	}
	
	@BeforeMethod(groups= {"smokeSuite","regressionSuite"})
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("=====Login successful====", true);
	}
	
	@AfterMethod(groups= {"smokeSuite","regressionSuite"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("=====logout successful===",true);
	}
	
	//@AfterTest
	@AfterClass(groups= {"smokeSuite","regressionSuite"})
	public void closeTheBrowser()
	{
		driver.quit();
		Reporter.log("====browser close successful===",true);
	}
	
	@AfterSuite(groups= {"smokeSuite","regressionSuite"})
	public void closeDB() throws Throwable
	{
		//dLib.closeDB();
		Reporter.log("====Database close successful===",true);
	}
}
