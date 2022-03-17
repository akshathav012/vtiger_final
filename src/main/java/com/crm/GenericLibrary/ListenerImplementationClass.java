package com.crm.GenericLibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"----Test script execution started");
		test=report.createTest(methodName);
				
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"----Test script execution successful-Pass");
		test.log(Status.PASS, methodName+"------>Pass");
		
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName()+"-";
		Reporter.log(methodName+"----Test script failed");
		String path = null;
		
		//step1: configure screenshot name
		String screenShotName = methodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenShotName);
		
		
		//step 2:using screenshot method from webdriver utility
		try
		{
		path = new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenShotName);
		
		/*EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenShotName+".PNG";
		String path = "./ScreenShots/"+screenShotName+".png";
		File dst = new File(pa);
		FileUtils.copyFile(src, dst);*/
		} catch(Throwable e) {
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, methodName+"------->failed");
		//it will capture the exception and log it in the report
		test.log(Status.FAIL, result.getThrowable());
 		test.addScreenCaptureFromPath(path);
			
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"----Test script execution skipped");
		test.log(Status.SKIP, methodName+"------>Skipped");
		//it will capture the exception and log it in the report
		test.log(Status.SKIP, result.getThrowable());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// execution will start here
		//configure the report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base-url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Akshatha");
		
		
	}

	public void onFinish(ITestContext context) {
		//consolidate all the parameters and generate the report
		report.flush();
		
	}
	

}
 