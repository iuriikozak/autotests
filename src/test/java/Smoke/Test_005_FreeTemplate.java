package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_005_FreeTemplate extends DefaultTestCase {
    @Test()
    public void test_005() {
        //Navigate to index page.
        Log.info("Navigate to index page");
        Urls.getUrl("", driver);

        //Search template.
        Log.info("Search template");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.search("51682");

        //Add to cart.
        Log.info("Add to cart");
        PreviewPage previewPage = PageFactory.initElements(driver, PreviewPage.class);
        previewPage.downloadSample();

        //Continue as a guest.
        Log.info("Continue as a guest");
        CheckoutStep1 checkout1 = PageFactory.initElements(driver, CheckoutStep1.class);
        checkout1.continueAsAGuestUser();

        //Free info.
        Log.info("Free info");
        CheckoutStep2 checkout2 = PageFactory.initElements(driver, CheckoutStep2.class);
        String email = RandomEmail.randomEmail();
        checkout2.freeInfo(Constants.FULL_NAME, email, Constants.BILLING_PHONE_NUMBER);

        //Check is user logged in.
        Log.info("Check is user logged in");
        CheckoutStep4 checkout4 = PageFactory.initElements(driver, CheckoutStep4.class);
        //Assert.assertEquals(Cookies.getCookieValue("wac", driver),"1");

        //Check email.
        Log.info("Check email");
        Assert.assertTrue(checkout4.orderStatus.getText().contains(email));

        //Check breadcrumb.
        Log.info("Check breadcrumb");
        Assert.assertEquals(checkout4.iconSignin.isDisplayed(), true);
        Assert.assertEquals(checkout4.iconUserDetails.isDisplayed(), true);
        Assert.assertEquals(checkout4.iconConfirm.isDisplayed(), true);
        Assert.assertEquals(checkout4.iconDelivery.isDisplayed(), false);

        //Check text color.
        Log.info("Check text color");
        Assert.assertTrue(checkout4.iconDeliveryText.getCssValue("color").contains("rgba(94, 86, 82, 1)"));
    }
}
