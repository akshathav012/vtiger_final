package com.crm.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count = 0;
	int retryCount = 3;
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}
	

}
