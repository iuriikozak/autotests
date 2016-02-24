package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import service.*;

public class Test_002_SearchTemplate extends DefaultTestCase {
    @Test()
    public void test_002() {
        //Navigate to index page.
        Log.info("Navigate to index page");
        Urls.getUrl("", driver);

        //Search template.
        Log.info("Search template");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.search("55555");

        //Check template number.
        Log.info("Check template number");
        PreviewPage previewPagePage = PageFactory.initElements(driver, PreviewPage.class);
        Assert.assertTrue(previewPagePage.itemNumber.getText().contains("55555"));

        //Check search form.
        Log.info("Check search form");
        Assert.assertTrue(indexPage.searchForm.getText().isEmpty());//во всех ассертах нужно писать месседж при ошибке

        //Check is element present.
        Log.info("Check is element present");
        Assert.assertFalse(previewPagePage.isElementPresent());
    }
}