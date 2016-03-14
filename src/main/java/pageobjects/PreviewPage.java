package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import services.Waiters;

public class PreviewPage {
    private WebDriver driver;

    public PreviewPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[contains(@class,'js-button-add-to-cart')]")
    public WebElement addToCart;

    @FindBy(xpath = ".//*[contains(@class,'js-checkout-button')]")
    public WebElement checkoutNow;

    @FindBy(xpath = ".//*[@itemprop='productID']")
    public WebElement itemNumber;

    @FindBy(xpath = ".//*[contains(@class,'js-fake-social-btn')]")
    public WebElement shareAndDownload;

    @FindBy(xpath = ".//*[contains(@class,'onp-sl-feature-overlay')]")
    public WebElement tweetButton;

    @FindBy(xpath = ".//*[contains(@class,'js-button-download-sample')]")
    public WebElement downloadTemplate;

    public void clickOnAddToCart(){
        Waiters.waitForClickAble(addToCart, driver);
        addToCart.click();
    }

    public void clickOnCheckoutNow(){
        Waiters.waitForClickAble(checkoutNow, driver);
        checkoutNow.click();
    }

    public void clickOnTweet(){
        Waiters.waitForClickAble(tweetButton, driver);
        tweetButton.click();
    }

    public void clickOnDownloadTemplate(){
        Waiters.waitForClickAble(downloadTemplate, driver);
        downloadTemplate.click();
    }

    public void addToCart() {
        clickOnAddToCart();
        clickOnCheckoutNow();
    }

    public void downloadSample() {
        String winHandleBefore = driver.getWindowHandle();
        Actions actions = new Actions(driver);
        actions.moveToElement(shareAndDownload).build().perform();
        clickOnTweet();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.close();
        driver.switchTo().window(winHandleBefore);
        clickOnDownloadTemplate();
    }

    public boolean isElementPresent() {
        try {
            driver.findElement(By.id("search-properties-status"));
            return true;
        } catch (Exception e) {//Exception это слишком широко
            return false;
        }
    }

    public boolean isPicturePresent() {
        try {
            driver.findElement(By.xpath(".//*[@class='js-preview-lazy lazy' and contains(@src,'data:image/png;base64')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkLazyLoad(){
        Assert.assertTrue(isPicturePresent());
        while (isPicturePresent() == true) {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath(".//*[@class='js-preview-lazy lazy' and contains(@src,'data:image/png;base64')]"))).build().perform();
        }
    }
}
