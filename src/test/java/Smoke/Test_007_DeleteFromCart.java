package Smoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_007_DeleteFromCart extends Test_001_LogIn {
    @Test()
    public void test() {
        //Clear shopping cart.
        Logs.info("Clear shopping cart");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        Urls.getURL(Constants.CLEAR_CART_URL, driver);

        //Add templates to cart.
        Logs.info("Add templates to cart");
        driver.get("http://www.templatemonster.com/cart.php?add=55555,53370,51241");
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.get("http://www.templatemonster.com/cart.php?add=51840,51191");

        //Checkout now.
        Logs.info("Checkout now");
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        shoppingCart.clickOnCheckoutNow();

        //Login.
        Logs.info("Login");
        CheckoutStep1 checkoutStep1 = PageFactory.initElements(driver, CheckoutStep1.class);
        checkoutStep1.loginAsAReturningUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
        //Waiters.waitForCookie("wac", driver);

        //Sopping cart.
        Logs.info("Sopping cart");
        indexPage.clickOnShoppingCart();

        //Delete templates.
        Logs.info("Delete templates");
        shoppingCart.deleteTemplateNumber(51241);
        shoppingCart.deleteTemplateNumber(53370);
        driver.navigate().refresh();

        //Check count products.
        Logs.info("Check count products");
        Assert.assertEquals(shoppingCart.countProducts(), 3);

        //Check list of templates.
        Logs.info("Check list of templates");
        int originalNumbers[] = {51191,51840,55555};
        int takenNumbers[] = shoppingCart.takeNumbersOfTemplates();
        Assert.assertEquals(originalNumbers, takenNumbers);

        //Check subtotal & order total.
        Logs.info("Check subtotal & order total");
        Assert.assertEquals(shoppingCart.takeSubtotal(), shoppingCart.takeTotalPriceOfTemplates());
        Assert.assertEquals(shoppingCart.takeOrderTotal(), shoppingCart.takeTotalPriceOfTemplates());
    }
}
