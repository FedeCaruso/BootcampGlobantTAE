package com.companyname.core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;
 
public class WebDriverListener implements IInvokedMethodListener2  {
	@Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver;
			try {
				driver = LocalDriverFactory.createInstance(browserName);
	            LocalDriverManager.setWebDriver(driver);
	            LocalDriverManager.getInstance().setUp(context);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				Utils.writeToLog(e.getMessage());
			}
        }
    }
 
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult,
			ITestContext context) {
        if (method.isTestMethod()) {
            WebDriver driver = LocalDriverManager.getInstance().getDriver();
            try {
				LocalDriverManager.getInstance().tearDown(context, testResult);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				Utils.writeToLog(e.getMessage());
			}
            if (driver != null) {
                driver.quit();
            }
        }
	}
}