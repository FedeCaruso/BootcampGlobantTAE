package no_framework_tests.tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import no_framework_tests.pages.GoogleSearchPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;


/**
 * Simple google search test.
 */
public class GoogleSearchTestJunit {

	private WebDriver driver;

	@Before
	public void beforeSuite() {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test ()
	public void searchTest() {
		// Navigate to google home
		driver.get("http://www.google.com");
		// Instantiate google page
		GoogleSearchPage page = new GoogleSearchPage(driver);
        // And now do the search.
        page.searchFor("Cheese");
		// Perform assertions

        Assert.assertTrue("Result is not as expected", page.getLinksTitle().contains("Cheese - Wikipedia, la enciclopedia libre"));
   	}

	@After
	public void afterSuite() {
		if(null != driver) {
			driver.close();
			driver.quit();
		}
	}
}
