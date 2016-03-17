package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import services_and_utilities.*;

public class Test_002_LogOut extends DefaultTestCase {
    @Test()
    public void test_002() {
        //Navigate to index page.
        Log.info("Navigate to index page");
        Urls.getUrl("", driver);

        //LogIn.
        Log.info("LogIn");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.login(Constants.EMAIL_ADDRESS, Constants.PASSWORD);

        //Get cookie.
        Log.info("Get cookie");
        Waiters.waitForCookie("wac", driver);
        Assert.assertEquals(Cookies.getCookieValue("wac", driver), "1");

        //LogOut.
        Log.info("LogOut");
        indexPage.clickOnSignOut();
    }
}