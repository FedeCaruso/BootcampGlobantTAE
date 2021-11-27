package others.webdrivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExampleWebDriverManager {
    @Test
    public void exampleWebDriverManagerLastVersion(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        System.out.println("Page Title: "+driver.getTitle());
        driver.quit();

    }

    @Test
    public void exampleWebDriverManagerPerVersion(){

        WebDriverManager.chromedriver().driverVersion("2.34").setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        System.out.println("Page Title: "+driver.getTitle());
        driver.quit();

    }
}
