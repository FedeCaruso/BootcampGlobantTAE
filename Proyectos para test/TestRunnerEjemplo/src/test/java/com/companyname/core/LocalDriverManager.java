package com.companyname.core;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

public class LocalDriverManager {
	private static volatile LocalDriverManager instance = null;
	private long timeout = Integer.parseInt(Utils.loadProperty("waitImplicitTimeout"));

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private ITestContext context;
    
    public WebDriver getDriver() {
        return webDriver.get();
    }
 
    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
    
    public void setDriverImplicitTimeout(long seconds)
	{
		getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
    
	public ITestContext getContext() {
		return context;
	}    
	
	public void setUp(ITestContext context) throws IOException, InterruptedException {

		Capabilities caps = ((RemoteWebDriver) getDriver()).getCapabilities();

		this.context = context;
		// Disabled to use explicit waits
		// setDriverImplicitTimeout(timeout);
		if (caps.getBrowserName() != "") {
			getDriver().manage().window().maximize();
		}
	}
	
	public void tearDown(ITestContext context, ITestResult result) throws IOException, InterruptedException {
		Reporter.setCurrentTestResult(result);
	}
	
	public static LocalDriverManager getInstance(){
		if (instance == null) {
			synchronized(LocalDriverManager.class) {		
				if (instance == null) {				
					instance = new LocalDriverManager();
				}
			}
		}
		return instance;
	}
}