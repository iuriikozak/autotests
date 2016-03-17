package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_011_FreeTemplate extends DefaultTestCase {
    @Test()
    public void test() throws InterruptedException {
        //Navigate to index page.
        Logs.info("Navigate to index page");
        Urls.getURL("", driver);

        //Login.
        Logs.info("Login");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.login(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
        Assert.assertEquals(Cookies.getCookieValue("wac", driver),"1");

        //Clear shopping cart.
        Logs.info("Clear shopping cart");
        Urls.getURL(Constants.CLEAR_CART_URL, driver);

        //Clear email.
        Logs.info("Clear email");
        GmailInbox.clear();

        //Search template.
        Logs.info("Search template");
        indexPage.search("51682");

        //Add to cart.
        Logs.info("Add to cart");
        PreviewPage previewPage = PageFactory.initElements(driver, PreviewPage.class);
        previewPage.downloadSample();

        //Complete order.
        Logs.info("Complete order");
        CheckoutStep3 checkoutStep3 = PageFactory.initElements(driver, CheckoutStep3.class);
        checkoutStep3.clickOnCompleteOrderButton();

        //Check letter.
        Logs.info("Check letter");
        Assert.assertEquals(GmailInbox.check(), "Your Free businessobjects.Template from TemplateMonster");
    }
}
