package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.Waiters;

public class CheckoutStep2 {
    private WebDriver driver;

    public CheckoutStep2(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "billinginfo-form-fullname")
    public WebElement fullName;

    @FindBy(id = "billinginfo-form-email")
    public WebElement emailAddress;

    @FindBy(id = "billinginfo-form-address")
    public WebElement addressField;

    @FindBy(id = "billinginfo-form-cityname")
    public WebElement cityField;

    @FindBy(id = "billinginfo-form-postalcode")
    public WebElement postalCodeField;

    @FindBy(id = "billinginfo-form-phone")
    public WebElement phoneNumberField;

    @FindBy(id = "billinginfo-form-submit")
    public WebElement continueButton;

    @FindBy(id = "freeinfo-form-name")
    public WebElement freeInfoFullName;

    @FindBy(id = "freeinfo-form-email")
    public WebElement freeInfoEmailAddress;

    @FindBy(id = "freeinfo-form-contactphone")
    public WebElement freeInfoPhoneNumberField;

    @FindBy(id = "freeinfo-form-submit")
    public WebElement downloadButton;

    public void fillInFullNameField(String name){
        Waiters.waitForClickAble(fullName, driver);
        fullName.sendKeys(name);
    }

    public void fillInEmailField(String email){
        Waiters.waitForClickAble(emailAddress, driver);
        emailAddress.sendKeys(email);
    }

    public void fillInAddressField(String address){
        Waiters.waitForClickAble(addressField, driver);
        addressField.sendKeys(address);
    }

    public void fillInCityField(String city){
        Waiters.waitForClickAble(cityField, driver);
        cityField.sendKeys(city);
    }

    public void fillInPostalCodeField(String code){
        Waiters.waitForClickAble(postalCodeField, driver);
        postalCodeField.sendKeys(code);
    }

    public void fillInPhoneNumberField(String number){
        Waiters.waitForClickAble(phoneNumberField, driver);
        phoneNumberField.sendKeys(number);
    }

    public void clickOnContinueButton(){
        Waiters.waitForClickAble(continueButton, driver);
        continueButton.click();
    }

    public void fillInFreeInfoFullNameField(String name){
        Waiters.waitForClickAble(freeInfoFullName, driver);
        freeInfoFullName.sendKeys(name);
    }

    public void fillInFreeInfoEmailField(String email){
        Waiters.waitForClickAble(freeInfoEmailAddress, driver);
        freeInfoEmailAddress.sendKeys(email);
    }

    public void fillInFreeInfoPhoneNumberField(String number){
        Waiters.waitForClickAble(freeInfoPhoneNumberField, driver);
        freeInfoPhoneNumberField.sendKeys(number);
    }

    public void clickOnDownloadButton(){
        Waiters.waitForClickAble(downloadButton, driver);
        downloadButton.click();
    }

    public void register(String name, String email, String address, String city, String code, String number) {
        fillInFullNameField(name);
        fillInEmailField(email);
        fillInAddressField(address);
        fillInCityField(city);
        fillInPostalCodeField(code);
        fillInPhoneNumberField(number);
        clickOnContinueButton();
    }

    public void freeInfo(String name, String email, String number) {
        fillInFreeInfoFullNameField(name);
        fillInFreeInfoEmailField(email);
        fillInFreeInfoPhoneNumberField(number);
        clickOnDownloadButton();
    }
}
