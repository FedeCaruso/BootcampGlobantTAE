package pom.test.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.pages.ProductPage;
import pom.test.base.BaseTest;

public class TestLockedOutUserLogin  extends BaseTest {

    @Test
    public void testLockedOutUserGetsErrorMessage(){
        loginPage.setUerName("locked_out_user");
        loginPage.setPassword("secret_sauce");
        //here we have a transition form login to productPage
        ProductPage productsPage = loginPage.clickLoginButton();
        System.out.println("error message:"+loginPage.getErrorMessage());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));

    }
}
