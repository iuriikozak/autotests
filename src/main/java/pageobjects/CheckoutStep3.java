package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services_and_utilities.Elements;
import services_and_utilities.Log;

import java.util.List;

public class CheckoutStep3 {
    private WebDriver driver;

    public CheckoutStep3(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "hdrContainer")
    public WebElement h2titlePayPal;

    @FindBy(id = "payments")
    public WebElement h2titlePayByCard;

    @FindBy(xpath = ".//*[contains(@class,'complete-order-btn')]")
    public WebElement completeOrder;

    @FindBy(xpath = ".//*[contains(@class,'btn-buy-now')]")
    public WebElement buyNowButton;

    public void clickOnCompleteOrderButton(){
        Elements.clickOnElement(driver, completeOrder, "completeOrder");
    }

    public void clickOnBuyNowButton(){
        Elements.clickOnElement(driver, buyNowButton, "buyNowButton");
    }

    String paymentMethodXpath = ".//*[@class='row js-radio-collapse collapsed']/div[@class='method-col2']//img";

    public void payBy(String paymentMethod){
        List<WebElement> list = driver.findElements(By.xpath(paymentMethodXpath));
        for (WebElement method : list){
            Log.info("method " + list);
            if (method.getAttribute("title").contains(paymentMethod)){
                method.click();
                clickOnBuyNowButton();
            }
        }
    }
}