package com.companyname.pages;

import com.companyname.core.BasePage;
import com.companyname.core.LocalDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchPage extends BasePage {
    // The element is now looked up using the name attribute
    @FindBy(how = How.NAME, using = "q")
    private WebElement searchBox;

    public GoogleSearchPage() {
        // Initialize elements using page factory
        PageFactory.initElements(LocalDriverManager.getInstance().getDriver(), this);
    }
    /**
     * Searches using a given criteria
     * @param text criteria for searching
     */
    public void searchFor(String text) {
        // Waits for the element to be visible
        isVisible(searchBox);
        // Perform actions
        searchBox.sendKeys(text);
        searchBox.submit();
    }

    /**
     * Obtains the list of links
     * @return list of links found at the first page results
     */
    public List<String> getLinksTitle()
    {
        List<WebElement> links = findElementsBy(By.cssSelector(".LC20lb"));
        List<String> collect = links.stream().map(x -> x.getText()).collect(Collectors.toList());
        return collect;
    }
} 