package others.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@SuppressWarnings("ALL")
public class exampleFluentWait {


    WebDriver driver;

    @BeforeClass
    public void setUP() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @Test
    public void demoFluentWait() {
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");

        // Waiting 41 seconds for an element to be present on the page
        // checking for its presence once every 1 second.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(41, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                WebElement timer = driver.findElement(By.xpath("//*[@id=\"clock\"]"));
                String messageTimer = timer.getText();

                if (messageTimer.equals("Buzz Buzz")) {
                    System.out.println("The Sound Of An Opportunity Clock Is " + messageTimer);
                    return timer;
                } else {
                    System.out.println(messageTimer);
                    return null;
                }

            }
        });

    }

    @AfterClass
    public void tearDown () {

        //driver.quit();
    }


}
