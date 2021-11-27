package no_framework_tests.pages;

import com.companyname.core.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Test not using a framework abstraction
 * Notice this is only for demonstration purposes
 */
public class GoogleSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    By searchBox = By.name("q");
    By linksLocator = By.cssSelector(".LC20lb");
    By linkNext = By.id("pnnext");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver,  Integer.parseInt(Utils.loadProperty("waitExplicitTimeout")));
    }
    /**
     * Searches using a given criteria
     * @param text criteria for searching
     */
    public void searchFor(String text) {
        // Waits for the element to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).isDisplayed();
        WebElement element = driver.findElement(searchBox);

        // Perform actions
        element.sendKeys(text);
        element.submit();
    }

    /**
     * Obtains the list of links
     * @return list of links found at the first page results
     */
    public List<String> getLinksTitle()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated((linkNext)));
    	List<WebElement> links = driver.findElements(linksLocator);
        List<String> collect = links.stream().map(x -> x.getText()).collect(Collectors.toList());
        return collect;
    }
}