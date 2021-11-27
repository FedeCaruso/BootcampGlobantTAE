package pom.test.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.pages.ProductPage;
import pom.test.base.BaseTest;

public class TestBackPack extends BaseTest {

    @Test
    public void testAddBackPack(){
        ProductPage productsPage = loginPage.loginWith("standard_user","secret_sauce");
        productsPage.addBackPack();
        Assert.assertEquals(productsPage.getButtonName(),"REMOVE");
    }
}
