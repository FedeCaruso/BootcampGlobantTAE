package com.companyname.tests;

import org.testng.annotations.Test;
import com.companyname.core.BasePage;
import com.companyname.pages.GoogleSearchPage;
import org.testng.asserts.Assertion;

/**
 * Simple google search test.
 */
public class GoogleSearchTest extends BasePage {
	private Assertion hardAssert = new Assertion();

	@Test()
	public void searchTest() {
		// Navigate to google home
		gotoUrl("http://www.google.com");
		// Instantiate google page
		GoogleSearchPage page = new GoogleSearchPage();
        // And now do the search.
        page.searchFor("Cheese");
		// Perform assertions
        hardAssert.assertTrue(page.getLinksTitle().contains("Cheese - Wikipedia, la enciclopedia libre"), "Result is not as expected");
   	}
}
