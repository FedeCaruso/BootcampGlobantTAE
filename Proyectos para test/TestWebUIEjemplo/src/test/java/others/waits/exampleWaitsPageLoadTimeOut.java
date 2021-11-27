package others.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class exampleWaitsPageLoadTimeOut {

    WebDriver driver;

    @BeforeClass
    public void setUP() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @Test
    public void examplePageLoadTimeOutWithMilliseconds() {
        //with driver.manage().timeouts() will see 3 of waits
        //timeUnit allow to set different times

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);//fail

        driver.get("https://opencource-demo.orangehrmlive.com");
        System.out.println("Title Page: " + driver.getTitle());

    }

    @Test
    public void examplePageLoadTimeOutWithSeconds() {
        //with driver.manage().timeouts() will see 3 of waits
        //timeUnit allow to set different times

        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);//pass

        driver.get("https://opencource-demo.orangehrmlive.com");
        System.out.println("Title Page: " + driver.getTitle());

    }

    @Test
    public void examplePageLoadTimeOutWithTheradSleep() throws InterruptedException {

        Thread.sleep(30000);// static wait so, don't use!!!!

        driver.get("https://opencource-demo.orangehrmlive.com");
        System.out.println("Title Page: " + driver.getTitle());

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
