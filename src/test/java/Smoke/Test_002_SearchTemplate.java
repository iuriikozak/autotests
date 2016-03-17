package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_002_SearchTemplate extends DefaultTestCase {
    @Test()
    public void test() {
        //Navigate to index page.
        Logs.info("Navigate to index page");
        Urls.getURL("", driver);

        //Search template.
        Logs.info("Search template");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.search("55555");

        //Check template number.
        Logs.info("Check template number");
        PreviewPage previewPagePage = PageFactory.initElements(driver, PreviewPage.class);
        Assert.assertTrue(previewPagePage.itemNumber.getText().contains("55555"));

        //Check search form.
        Logs.info("Check search form");
        Assert.assertTrue(indexPage.searchForm.getText().isEmpty());//во всех ассертах нужно писать месседж при ошибке

        //Check is element present.
        Logs.info("Check is element present");
        Assert.assertFalse(previewPagePage.isElementPresent());
    }
}