package com.companyname.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public abstract class BasePage extends TimedOperations {
	/**
	 * Navigate to a given url
	 * @param url string
	 */
	protected void gotoUrl(String url) {
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getInstance().getDriver().hashCode());
		LocalDriverManager.getInstance().getDriver().get(url);
	}

	/**
	 * Gets the current browser name
	 * @return a string
	 */
	protected String getBrowserName() {
		Capabilities caps = ((RemoteWebDriver) LocalDriverManager.getInstance().getDriver()).getCapabilities();
		return caps.getBrowserName();
	}

	/**
	 * Finds an element by locator
	 * @param by locator
	 * @return a webElement
	 */
	protected WebElement findElementBy(By by) {
		return LocalDriverManager.getInstance().getDriver().findElement(by);
	}

	/**
	 * Finds elements by locator
	 * @param by locator
	 * @return a list of webElements
	 */
	protected List<WebElement> findElementsBy(By by) {
		return waitForElementsLocatedBy(by);
	}

	/**
	 * Clicks on the element.
	 *
	 * @param webElement the {@link WebElement}
	 */
	protected void click(WebElement webElement) {
		isClickable(webElement);
		webElement.click();
	}

	/**
	 * Gets the text from the web element.
	 *
	 * @param webElement the {@link WebElement}
	 * @return the text
	 */
	protected String getText(WebElement webElement) {
		isVisible(webElement);
		return webElement.getText();
	}
}
