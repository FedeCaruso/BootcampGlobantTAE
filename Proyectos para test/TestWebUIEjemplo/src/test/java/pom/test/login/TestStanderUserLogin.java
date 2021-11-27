package pom.test.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.pages.ProductPage;
import pom.test.base.BaseTest;

public class TestStanderUserLogin extends BaseTest {

    @Test
    public void testStanderUserCanLogin(){
        ProductPage productsPage = loginPage.loginWith("standard_user","secret_sauce");
        Assert.assertTrue(productsPage.isProductLabelDisplayed());
    }
}
