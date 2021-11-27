package com.companyname.tests;

import com.companyname.pages.MobileLoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/**
 * Simple mobile login test
 * Use Android Studio to create a template project login activity and build your apk for testing
 */
public class MobileLoginTest {
	private Assertion hardAssert = new Assertion();

	@Test()
	public void loginTest() {
		MobileLoginPage page = new MobileLoginPage();
		page.enterCredentials("bootcamp@company.com", "pepe1234");
		hardAssert.assertEquals(page.getToastMessage(), "Welcome ! Jane Doe", "Toast message is not as expected");
   	}
}
