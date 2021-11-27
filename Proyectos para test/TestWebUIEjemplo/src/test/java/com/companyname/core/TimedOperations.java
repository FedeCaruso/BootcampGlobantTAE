package com.companyname.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class TimedOperations {

    /**
     * Wait until the element becomes visible
     *
     * @param element element
     */
    protected boolean isVisible(final WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf((element))).isDisplayed();
    }

    /**
     * Wait until the element is clickable
     *
     * @param element element
     */
    protected boolean isClickable(final WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }

    /**
     * Wait until a given text is present
     *
     * @param element element
     * @param text string text
     */
    protected boolean textIsPresent(final WebElement element, String text) {
        return getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Wait until all elements are located and returns the list
     *
     * @param locator By locator
     * @returns list of WebElements
     */
    protected List<WebElement> waitForElementsLocatedBy(final By locator) {
        return getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    private int getTimeout() {
        return Integer.parseInt(Utils.loadProperty("waitExplicitTimeout"));
    }

    private WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(LocalDriverManager.getInstance().getDriver(), getTimeout());
        return wait;
    }
}
