package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_004_PayByCard extends DefaultTestCase {
    @Test()
    public void test() throws InterruptedException {
        //Navigate to index page.
        Logs.info("Navigate to index page");
        Urls.getURL("", driver);

        //Search template.
        Logs.info("Search template");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.search("55555");

        //Add to cart.
        Logs.info("Add to cart");
        PreviewPage previewPage = PageFactory.initElements(driver, PreviewPage.class);
        previewPage.addToCart();

        //Login.
        Logs.info("Login");
        CheckoutStep1 checkoutStep1 = PageFactory.initElements(driver, CheckoutStep1.class);
        checkoutStep1.loginAsAReturningUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);

        //Check is user logged in.
        Logs.info("Check is user logged in");
        CheckoutStep3 checkout3 = PageFactory.initElements(driver, CheckoutStep3.class);
        //Assert.assertEquals(Cookies.getCookieValue("wac", driver),"1");

        //Buy by Card.
        Logs.info("Buy by Card");
        checkout3.payBy("TransactPro");

        //Check bills page.
        Logs.info("Check bills page");
        Waiters.waitForTextVisible("Payments are performed by TransactionPro", checkout3.h2titlePayByCard, driver);
        Assert.assertTrue(checkout3.h2titlePayByCard.getText().contains("Payments are performed by TransactionPro"));
    }
}
