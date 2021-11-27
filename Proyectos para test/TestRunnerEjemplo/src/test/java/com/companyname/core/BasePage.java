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
	 * @return the {@link WebElement}
	 */
	protected WebElement findElementBy(By by) {
		return LocalDriverManager.getInstance().getDriver().findElement(by);
	}

	/**
	 * Finds elements by locator until they are located
	 * @param by locator
	 * @return the list of elements
	 */
	protected List<WebElement> findElementsBy(By by) {
		return areLocated(by);
	}

	/**
	 * Finds elements by locator until they are visible
	 * @param elements List if webElements
	 * @return boolean true if elements are visible, otherwise false
	 */
	protected boolean findElementsBy(List<WebElement> elements) {
		return areVisible(elements);
	}

	/**
	 * Clicks on the element.
	 *
	 * @param element the {@link WebElement}
	 */
	protected void click(WebElement element) {
		isClickable(element);
		element.click();
	}

	/**
	 * Gets the text from the web element.
	 *
	 * @param element the {@link WebElement}
	 * @return the text
	 */
	protected String getText(WebElement element) {
		isVisible(element);
		return element.getText();
	}
}
