package no_framework_tests.tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import no_framework_tests.pages.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/**
 * Simple google search test.
 */
public class GoogleSearchTest {
	private Assertion hardAssert = new Assertion();
	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test()
	public void searchTest() {
		// Navigate to google home
		driver.get("http://www.google.com");
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
