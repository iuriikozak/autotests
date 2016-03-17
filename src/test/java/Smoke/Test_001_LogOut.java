package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import services_and_utilities.*;

public class Test_001_LogOut extends DefaultTestCase {
    @Test()
    public void test_001() {
        //Navigate to index page.
        Logs.info("Navigate to index page");
        Urls.getURL("", driver);

        //LogIn.
        Logs.info("LogIn");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.login(Constants.EMAIL_ADDRESS, Constants.PASSWORD);

        //Get cookie.
        Logs.info("Get cookie");
        Waiters.waitForCookie("wac", driver);
        Assert.assertEquals(Cookies.getCookieValue("wac", driver), "1");

        //LogOut.
        Logs.info("LogOut");
        indexPage.clickOnSignOut();
    }
}