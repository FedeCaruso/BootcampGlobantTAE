package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private By usernameField= By.id("user-name");
    private By passwordField=By.id("password");
    private By loginButton=By.id("login-button");
    private By errorMessage=By.cssSelector("#login_button_container h3");

    public LoginPage(WebDriver driver){
        super(driver);

    }

    //Set methods allows to interact with different elements
    public void setUerName(String username){

        type (username,usernameField);
    }

    public void setPassword(String password){

        type(password,passwordField);
    }

    //Transition Method
    public ProductPage clickLoginButton(){
        click(loginButton);
        return new ProductPage(driver);
    }

    //convince methods combination of multiple methods "helper"
    public ProductPage loginWith (String username,String password){
        setUerName(username);
        setPassword(password);
        return clickLoginButton();
    }
    //get methdos returns state of data
    public String getErrorMessage(){
        return find(errorMessage).getText();

    }

}
