package Smoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import service.*;

public class Test_007_DeleteFromCart extends Test_001_LogIn {
    @Test()
    public void test_007() {
        //Clear shopping cart.
        Log.info("Clear shopping cart");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        Urls.getUrl(Constants.CLEAR_CART_URL, driver);

        //Add templates to cart.
        Log.info("Add templates to cart");
        driver.get("http://www.templatemonster.com/cart.php?add=55555,53370,51241");
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.get("http://www.templatemonster.com/cart.php?add=51840,51191");

        //Checkout now.
        Log.info("Checkout now");
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        shoppingCart.clickOnCheckoutNow();

        //Login.
        Log.info("Login");
        CheckoutStep1 checkoutStep1 = PageFactory.initElements(driver, CheckoutStep1.class);
        checkoutStep1.loginAsAReturningUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
        //Waiters.waitForCookie("wac", driver);

        //Sopping cart.
        Log.info("Sopping cart");
        indexPage.clickOnShoppingCart();

        //Delete templates.
        Log.info("Delete templates");
        shoppingCart.deleteTemplateNumber(51241);
        shoppingCart.deleteTemplateNumber(53370);
        driver.navigate().refresh();

        //Check count products.
        Log.info("Check count products");
        Assert.assertEquals(shoppingCart.countProducts(), 3);

        //Check list of templates.
        Log.info("Check list of templates");
        int originalNumbers[] = {51191,51840,55555};
        int takenNumbers[] = shoppingCart.takeNumbersOfTemplates();
        Assert.assertEquals(originalNumbers, takenNumbers);

        //Check subtotal & order total.
        Log.info("Check subtotal & order total");
        Assert.assertEquals(shoppingCart.takeSubtotal(), shoppingCart.takeTotalPriceOfTemplates());
        Assert.assertEquals(shoppingCart.takeOrderTotal(), shoppingCart.takeTotalPriceOfTemplates());
    }
}
