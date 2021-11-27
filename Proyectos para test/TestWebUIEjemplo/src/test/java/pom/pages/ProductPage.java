package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    private By productLabel = By.className("title");
    private By backpack = By.id("item_4_title_link");
    private By addToCarButton = By.className("btn_inventory");

    public ProductPage(WebDriver driver){
        super(driver);
    }


    public Boolean isProductLabelDisplayed(){
        return isDisplayed(getProductLabel());

    }

    public void addBackPack(){
        find(backpack).click();
        click(addToCarButton);
    }

    public String getButtonName(){

        return find(addToCarButton).getText();
    }

    public By getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(By productLabel) {
        this.productLabel = productLabel;
    }
}
