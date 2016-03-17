package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_010_InvalidEmail extends DefaultTestCase {
    @Test(dataProvider = "InvalidEmail2", dataProviderClass = DataProviders.class)
    public void test(String email) {
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
        checkoutStep1.loginAsAReturningUser(email, Constants.PASSWORD);

        //Click in password field.
        Logs.info("Click in password field");
        checkoutStep1.clickInPasswordField();

        //Check error message.
        Logs.info("Check error message");//нужно подождать тест
        Assert.assertTrue(checkoutStep1.emailErrorMessage.getText().contains("Please specify a valid email"));
    }
}