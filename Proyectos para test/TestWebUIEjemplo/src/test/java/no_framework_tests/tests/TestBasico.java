package no_framework_tests.tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import no_framework_tests.pages.GoogleSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/**
 * Simple google search test.
 */
public class TestBasico {
	private Assertion hardAssert = new Assertion();
	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test()
	public void correctLogin() {
		// Navigate to google home
		driver.get("https://www.saucedemo.com/");

		//Set userName
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//Set Password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//Clic login button
		driver.findElement(By.id("login-button")).click();

		//Assert the title of this welcome page
        hardAssert.assertTrue(driver.findElement(By.className("title")).getText().contains("PRODUCTS"), "Result is not as expected");
   	}

	@Test()
	public void invalidLogin() {
		// Navigate to google home
		driver.get("https://www.saucedemo.com/");

		//Set userName
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//Set Password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//Clic login button
		driver.findElement(By.id("login-button")).click();

		//Assert the title of this welcome page
		hardAssert.assertTrue(driver.findElement(By.className("title")).getText().contains("PRODUCTS"), "Result is not as expected");
	}

	@AfterSuite
	public void afterSuite() {
		if(null != driver) {
			driver.close();
			driver.quit();
		}
	}
}
