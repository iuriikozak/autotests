package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import service.*;

public class Test_004_PayByCard extends DefaultTestCase {
    @Test()
    public void test_004() throws InterruptedException {
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

        //Login.
        Log.info("Login");
        CheckoutStep1 checkoutStep1 = PageFactory.initElements(driver, CheckoutStep1.class);
        checkoutStep1.loginAsAReturningUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);

        //Check is user logged in.
        Log.info("Check is user logged in");
        CheckoutStep3 checkout3 = PageFactory.initElements(driver, CheckoutStep3.class);
        //Assert.assertEquals(Cookies.getValueOfCookieNamed("wac", driver),"1");

        //Buy by Card.
        Log.info("Buy by Card");
        checkout3.payBy("TransactPro");

        //Check bills page.
        Log.info("Check bills page");
        Waiters.waitForText(checkout3.h2titlePayByCard, driver);
        Assert.assertTrue(checkout3.h2titlePayByCard.getText().contains("Payments are performed by TransactionPro"));
    }
}
