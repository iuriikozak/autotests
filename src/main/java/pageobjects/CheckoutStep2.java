package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services_and_utilities.Elements;

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
        Elements.sendKeys(fullName, "fullName", name);
    }

    public void fillInEmailField(String email){
        Elements.sendKeys(emailAddress, "emailAddress", email);
    }

    public void fillInAddressField(String address){
        Elements.sendKeys(addressField, "addressField", address);
    }

    public void fillInCityField(String city){
        Elements.sendKeys(cityField, "cityField", city);
    }

    public void fillInPostalCodeField(String code){
        Elements.sendKeys(postalCodeField, "postalCodeField", code);
    }

    public void fillInPhoneNumberField(String number){
        Elements.sendKeys(phoneNumberField, "phoneNumberField", number);
    }

    public void clickOnContinueButton(){
        Elements.clickOnElement(driver, continueButton, "continueButton");
    }

    public void fillInFreeInfoFullNameField(String name){
        Elements.sendKeys(freeInfoFullName, "freeInfoFullName", name);
    }

    public void fillInFreeInfoEmailField(String email){
        Elements.sendKeys(freeInfoEmailAddress, "freeInfoEmailAddress", email);
    }

    public void fillInFreeInfoPhoneNumberField(String number){
        Elements.sendKeys(freeInfoPhoneNumberField, "freeInfoPhoneNumberField", number);
    }

    public void clickOnDownloadButton(){
        Elements.clickOnElement(driver, downloadButton, "downloadButton");
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
