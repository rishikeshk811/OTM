package com.OTM.GenericUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {

		
		
		
		
		   String methodName=result.getMethod().getMethodName();
		   test=report.createTest(methodName);
		   Reporter.log(methodName+"   Test Script Execution Starts from here ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		  String mName=result.getMethod().getMethodName();
test.log(Status.PASS, mName+" --->> PASSED ");
Reporter.log(mName+"  -->Test Script Executed Successfully ",true);
	
	
	}
	@Override
	public void onTestFailure(ITestResult result) {
		   String methodName=result.getMethod().getMethodName();
		String    methodNameWithTime=  methodName+new JavaUtils().systemDateinFormat();
		test.addScreenCaptureFromPath(methodNameWithTime);
		   
	     try {
			WebDriverUtils.getScreenShot(BaseClass.ssDriver, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     test.log(Status.FAIL, result.getThrowable());
	     test.log(Status.FAIL, methodName+" -->failed");
	     Reporter.log(methodNameWithTime+" TestScript Execution Failed ",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	    String methodName=	result.getMethod().getMethodName();
	    test.log(Status.SKIP, methodName+" -->SKIPPED ");
	   test.log(Status.SKIP, result.getThrowable());
	   Reporter.log(methodName+" TestScript Execution Skipped ",true);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		JavaUtils jlib =new JavaUtils();
	    String sysDate=	jlib.systemDateinFormat();
	ExtentSparkReporter htmlReport= new ExtentSparkReporter("./ExtentReports/repot+"+sysDate+".html");
	htmlReport.config().setDocumentTitle("TYSS-OTM");
	htmlReport.config().setTheme(Theme.STANDARD);
	htmlReport.config().setReportName("Online Tourism Management");
	
	 report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("Base-Browser", "chrome ");
	report.setSystemInfo("url", "http://rmgserver/domain/Online-Tourisṃ-Management/");
	report.setSystemInfo("Reporter-Name", "Rishikesh Singh Rajput ");


	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();	
		}

}
