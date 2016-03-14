package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services.*;

public class Test_011_FreeTemplate extends DefaultTestCase {
    @Test()
    public void test_011() throws InterruptedException {
        //Navigate to index page.
        Log.info("Navigate to index page");
        Urls.getUrl("", driver);

        //Login.
        Log.info("Login");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.login(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
        Assert.assertEquals(Cookies.getCookieValue("wac", driver),"1");

        //Clear shopping cart.
        Log.info("Clear shopping cart");
        Urls.getUrl(Constants.CLEAR_CART_URL, driver);

        //Clear email.
        Log.info("Clear email");
        GmailInbox.clear();

        //Search template.
        Log.info("Search template");
        indexPage.search("51682");

        //Add to cart.
        Log.info("Add to cart");
        PreviewPage previewPage = PageFactory.initElements(driver, PreviewPage.class);
        previewPage.downloadSample();

        //Complete order.
        Log.info("Complete order");
        CheckoutStep3 checkoutStep3 = PageFactory.initElements(driver, CheckoutStep3.class);
        checkoutStep3.clickOnCompleteOrderButton();

        //Check letter.
        Log.info("Check letter");
        Assert.assertEquals(GmailInbox.check(), "Your Free Template from TemplateMonster");
    }
}
