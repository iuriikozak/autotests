package Smoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_006_MergeCart extends Test_001_LogIn {
    @Test()
    public void test() {
        //Clear shopping cart.
        Logs.info("Clear shopping cart");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        Urls.getURL(Constants.CLEAR_CART_URL, driver);

        //Add templates to cart.
        Logs.info("Add templates to cart");
        driver.get("http://www.templatemonster.com/cart.php?add=55555,53370,51241");
        driver.manage().deleteAllCookies();// зачем?
        driver.navigate().refresh();
        driver.get("http://www.templatemonster.com/cart.php?add=51840,51191");

        //Login.
        Logs.info("Login");
        indexPage.login(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
        Waiters.waitForCookie("wac", driver);

        //Go to shopping cart.
        Logs.info("Go to shopping cart");
        indexPage.clickOnShoppingCart();

        //Check count products.
        Logs.info("Check count products");
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        Assert.assertEquals(shoppingCart.countProducts(), 5);

        //Check list of templates.
        Logs.info("Check list of templates");
        int originalNumbers[] = {51191,51241,51840,53370,55555};
        int takenNumbers[] = shoppingCart.takeNumbersOfTemplates();
        Assert.assertEquals(originalNumbers, takenNumbers);

        //Check subtotal & order total.
        Logs.info("Check subtotal & order total");
        Assert.assertEquals(shoppingCart.takeSubtotal(), shoppingCart.takeTotalPriceOfTemplates());
        Assert.assertEquals(shoppingCart.takeOrderTotal(), shoppingCart.takeTotalPriceOfTemplates());
    }
}
