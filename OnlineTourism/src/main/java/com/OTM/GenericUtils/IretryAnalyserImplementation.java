package com.OTM.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IretryAnalyserImplementation implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
	int i=0;
	int limitRetry=3;
	if (i<limitRetry) {
		i++;
		return true;
	}
		return false;
	}

	
}
