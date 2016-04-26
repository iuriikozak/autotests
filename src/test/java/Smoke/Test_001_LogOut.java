package Smoke;

import Default.DefaultTestCase;
import businessobjects.User;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import services_and_utilities.*;

public class Test_001_LogOut extends DefaultTestCase {
    @Test(dataProvider = "UserLogin", dataProviderClass = DataProviders.class)
    public void test_001(User user) {
        //Navigate to index page.
        Logs.info("Navigate to index page");
        Urls.getURL("", driver);

        //LogIn.
        Logs.info("LogIn");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.login(user.getUserName(), user.getPassword());

        //Get cookie.
        Logs.info("Get cookie");
        Waiters.waitForCookie("wac", driver);
        Assert.assertEquals(Cookies.getCookieValue("wac", driver), "1");

        //LogOut.
        Logs.info("LogOut");
        indexPage.clickOnSignOut();
    }
}