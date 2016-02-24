package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.Waiters;

public class CheckoutStep3 {
    private WebDriver driver;

    public CheckoutStep3(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@data-target='#paymentItemContent2']")
    public WebElement methodPayByPayPal;

    @FindBy(xpath = ".//*[@data-payment='2']")
    public WebElement buyNowButtonPayPal;

    @FindBy(id = "hdrContainer")
    public WebElement h2titlePayPal;

    @FindBy(xpath = ".//*[@data-target='#paymentItemContent19']")
    public WebElement methodPayByCard;

    @FindBy(xpath = ".//*[@data-payment='19']")
    public WebElement buyNowButtonPayByCard;

    @FindBy(id = "payments")
    public WebElement h2titlePayByCard;

    @FindBy(xpath = ".//*[contains(@class,'complete-order-btn')]")
    public WebElement completeOrder;

    public void clickOnMethodPayByPayPal(){
        Waiters.waitForClickAble(methodPayByPayPal, driver);
        methodPayByPayPal.click();
    }

    public void clickOnPayPalBuyNowButton(){
        Waiters.waitForClickAble(buyNowButtonPayPal, driver);
        buyNowButtonPayPal.click();
    }

    public void clickOnMethodPayByCard(){
        Waiters.waitForClickAble(methodPayByCard, driver);
        methodPayByCard.click();
    }

    public void clickOnPayByCardBuyNowButton(){
        Waiters.waitForClickAble(buyNowButtonPayByCard, driver);
        buyNowButtonPayByCard.click();
    }

    public void clickOnCompleteOrderButton(){
        Waiters.waitForClickAble(completeOrder, driver);
        completeOrder.click();
    }

    public void buyByPayPal() throws InterruptedException {
        clickOnMethodPayByPayPal();
        Thread.sleep(500);
        clickOnPayPalBuyNowButton();
    }

    public void buyByCard() throws InterruptedException {
        clickOnMethodPayByCard();
        Thread.sleep(500);
        clickOnPayByCardBuyNowButton();
    }
}
