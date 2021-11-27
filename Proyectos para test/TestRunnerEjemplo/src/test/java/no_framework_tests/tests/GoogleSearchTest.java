package no_framework_tests.tests;

import com.companyname.core.Utils;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import no_framework_tests.pages.GoogleSearchPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Test not using a framework abstraction
 * Notice this is only for demonstration purposes
 */
public class GoogleSearchTest {
	private Assertion hardAssert = new Assertion();
	private WebDriver driver;

	@DataProvider(name = "test1")
	public Object[][] networkConditions() {
		return new Object[][] {
				{ 5000 , 5000 },
				{ 10000, 7000 },
				{ 15000, 9000 },
				{ 20000, 10000 },
				{ 23000, 11000 },
				{ 30000, 15000 },
				{ 40000, 20000 },
				{ 50000, 20000 },
				{ 75000, 20000 },
				{ 100000, 20000 }
		};
	}

	@BeforeSuite
	public void beforeSuite() {
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "networkConditions")
	public void searchTest(int downloadThroughput, int uploadThroughput) throws IOException {
		// Emulate network conditions
		Utils.networkThrotting(driver, downloadThroughput, uploadThroughput);
		// Navigate to google home
		driver.get("https://www.google.com");
		// Instantiate google page
		GoogleSearchPage page = new GoogleSearchPage(driver);
        // And now do the search.
        page.searchFor("Cheese");
		// Perform assertions
        hardAssert.assertTrue(page.getLinksTitle().contains("Cheese - Wikipedia, la enciclopedia libre"), "Result is not as expected");
   	}

	@AfterSuite
	public void afterSuite() {
		if(null != driver) {
			driver.close();
			driver.quit();
		}
	}
}
