package no_framework_tests.tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import no_framework_tests.pages.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

/**
 * Simple google search test.
 */
public class GoogleSearchTestFailed {
	//private Assertion hardAssert = new Assertion();
	private SoftAssert softAssert = new SoftAssert();
	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test()
	public void searchTestFailed() {
		// Navigate to google home
		driver.get("http://www.google.com");
		// Instantiate google page
		GoogleSearchPage page = new GoogleSearchPage(driver);
        // And now do the search.
        page.searchFor("Cheese");
		// Perform assertions

		//hardAssert.assertTrue(page.getLinksTitle().contains("Cheese - Wikipedia, la enciclopedia Privada!"), "Result is not as expected");
		softAssert.assertTrue(page.getLinksTitle().contains("Cheese - Wikipedia, la enciclopedia Privada!"), "Result is not as expected");
		System.out.println("Test Failed!!!");
   	}

	@AfterSuite
	public void afterSuite() {
		if(null != driver) {
			driver.close();
			driver.quit();
		}
	}
}
