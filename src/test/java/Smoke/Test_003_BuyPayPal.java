package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_003_BuyPayPal extends DefaultTestCase {
    @Test()
    public void test_003() throws InterruptedException {
        //Navigate to index page.
        Log.info("Navigate to index page");
        Urls.getUrl("", driver);

        //Search template.
        Log.info("Search template");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.search("55555");

        //Add to cart.
        Log.info("Add to cart");
        PreviewPage previewPage = PageFactory.initElements(driver, PreviewPage.class);
        previewPage.addToCart();

        //Continue as a guest.
        Log.info("Continue as a guest");
        CheckoutStep1 checkout1 = PageFactory.initElements(driver, CheckoutStep1.class);
        checkout1.continueAsAGuestUser();

        //Register.
        Log.info("Register");
        CheckoutStep2 checkout2 = PageFactory.initElements(driver, CheckoutStep2.class);
        checkout2.register(Constants.FULL_NAME, RandomEmail.randomEmail(), Constants.ADDRESS, Constants.CITY, Constants.ZIP_POSTAL_CODE, Constants.BILLING_PHONE_NUMBER);

        //Check is user logged in.
        //Log.info("Check is user logged in");
        CheckoutStep3 checkout3 = PageFactory.initElements(driver, CheckoutStep3.class);
        //Assert.assertEquals(Cookies.getCookieValue("wac", driver),"1");

        //Buy by PayPal.
        Log.info("Buy by PayPal");
        checkout3.payBy("PayPal");

        //Check bills page.
        Log.info("Check bills page");
        Waiters.waitForText(checkout3.h2titlePayPal, driver);
        Assert.assertTrue(checkout3.h2titlePayPal.getText().contains("Choose a way to pay"));
    }
}
