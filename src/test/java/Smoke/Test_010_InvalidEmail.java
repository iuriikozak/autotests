package Smoke;

import Default.DefaultTestCase;
import businessobjects.User;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_010_InvalidEmail extends DefaultTestCase {
    @Test(dataProvider = "InvalidEmail", dataProviderClass = DataProviders.class)
    public void test_010(User user) {
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
        checkoutStep1.loginAsAReturningUser(user.getUserName(), user.getPassword());

        //Click in password field.
        Logs.info("Click in password field");
        checkoutStep1.clickInPasswordField();

        //Check error message.
        Logs.info("Check error message");
        Assert.assertTrue(checkoutStep1.emailErrorMessage.getText().contains("Please specify a valid email"));
    }
}