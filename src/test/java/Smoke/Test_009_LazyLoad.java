package Smoke;

import Default.DefaultTestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobjects.*;
import services_and_utilities.*;

public class Test_009_LazyLoad extends DefaultTestCase {
    @Test()
    public void test_009() {
        //Navigate to index page.
        Log.info("Navigate to index page");
        Urls.getUrl("", driver);

        //Search template.
        Log.info("Search template");
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.search("52112");

        //Check lazy load.
        Log.info("Check lazy load");
        PreviewPage previewPage = PageFactory.initElements(driver, PreviewPage.class);
        previewPage.checkLazyLoad();
    }
}