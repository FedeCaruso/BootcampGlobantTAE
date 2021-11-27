package others.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class exampleWaitsImplicitWaits {

    WebDriver driver;

    @BeforeClass
    public void setUP() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @Test
    public void exampleImplicitWait() {
        WebElement dynamicLoadingLink, exampleTwoLink, startButton, textToAssertText;

        driver.get("http://the-internet.herokuapp.com/");


        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        dynamicLoadingLink = driver.findElement(By.linkText("Dynamic Loading"));
        dynamicLoadingLink.click();
        exampleTwoLink = driver.findElement(By.partialLinkText("Example 2"));
        exampleTwoLink.click();
        startButton = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startButton.click();
        textToAssertText = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));


        String messageHelloWorldText = textToAssertText.getText();


        System.out.println("Message !!!  : " + messageHelloWorldText);

    }


    @AfterClass
    public void tearDown() {

        //driver.quit();
    }
}
