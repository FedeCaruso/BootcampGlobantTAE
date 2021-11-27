package others.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class exampleWaitsExplicitWaits {

    WebDriver driver;

    @BeforeClass
    public void setUP() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @Test
    public void exampleExplicitWait() {
        WebElement dynamicLoadingLink, exampleTwoLink, startButton, textToAssertText;


        driver.get("http://the-internet.herokuapp.com/");

        WebDriverWait wait = new WebDriverWait(driver,5);


        dynamicLoadingLink = driver.findElement(By.linkText("Dynamic Loading"));
        dynamicLoadingLink.click();
        exampleTwoLink = driver.findElement(By.partialLinkText("Example 2"));
        exampleTwoLink.click();
        startButton = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));

        textToAssertText = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));


        String messageHelloWorldText = textToAssertText.getText();

        System.out.println("Message !!!  : " + messageHelloWorldText);

    }


    @AfterClass
    public void tearDown() {

        //driver.quit();
    }
}
