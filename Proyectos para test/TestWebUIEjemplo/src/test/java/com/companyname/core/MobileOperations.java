package com.companyname.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public abstract class MobileOperations extends BasePage {
    protected AppiumDriver<MobileElement> driver;

    public MobileOperations() {
        this.driver = (AppiumDriver) LocalDriverManager.getInstance().getDriver();
    }

    /**
     * Tap to an element for 250 milliseconds
     * @param element a given Mobile Element
     */
    public void tapByElement (MobileElement element) {
        new TouchAction(driver)
                .tap(tapOptions().withElement(element(element)))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    /**
     * Sets a value in an element
     * @param element a given Mobile Element
     * @param value a given value to set
     */
    public void type (MobileElement element, String value) {
        element.setValue(value);
    }

    /**
     * Tap by coordinates
     * @param x a given x axis
     * @param y a given y axis
     */
    public void tapByCoordinates (int x,  int y) {
        new TouchAction(driver)
                .tap(point(x,y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    /**
     * Press by element
     * @param mobileElement a given Mobile Element
     * @param seconds time in seconds to keep pressing
     */
    public void pressByElement (MobileElement mobileElement, long seconds) {
        new TouchAction(driver)
                .press(element(mobileElement))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }
}