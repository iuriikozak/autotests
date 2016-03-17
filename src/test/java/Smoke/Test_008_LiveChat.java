package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_008_LiveChat extends DefaultTestCase {
    @Test()
    public void test() throws InterruptedException {
        //Navigate to index page.
        Logs.info("Navigate to index page");
        Urls.getURL("", driver);

        //Start chat.
        Logs.info("Start chat");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.startChat(Constants.FULL_NAME, RandomEmail.randomEmail());

        Thread.sleep(10000);//очень плохо

        //Check url.
        Logs.info("Check url");
        Assert.assertEquals(driver.getCurrentUrl(), "http://chat.template-help.com/chat.jsp");

        //Check chat.
        Logs.info("Check chat");
        Assert.assertEquals(indexPage.liveChatHeader.getText(), "Welcome to Pre-sales Chat");
    }
}