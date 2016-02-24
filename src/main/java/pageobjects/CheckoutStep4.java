package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStep4 {
    private WebDriver driver;

    public CheckoutStep4(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@class='block-heading']/p")
    public WebElement orderStatus;

    @FindBy(xpath = ".//*[contains(@class,'js-step-link-step1')]/i")
    public WebElement iconSignin;

    @FindBy(xpath = ".//*[contains(@class,'js-step-link-step2')]/i")
    public WebElement iconUserDetails;

    @FindBy(xpath = ".//*[contains(@class,'js-step-link-step3')]/i")
    public WebElement iconConfirm;

    @FindBy(xpath = ".//*[contains(@class,'js-step-link-step4')]/i")
    public WebElement iconDelivery;

    @FindBy(xpath = ".//*[contains(@class,'js-step-link-step4')]")
    public WebElement iconDeliveryText;
}
