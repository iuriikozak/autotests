package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStep1 {
    private WebDriver driver;

    public CheckoutStep1(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "new-customer-radio")
    public WebElement iAmANewCustomer;

    @FindBy(xpath = ".//*[@class='js-customer-new-from customer-new-from']/form/div/div/button")
    public WebElement continueAsAGuest;

    @FindBy(id = "returning-customer-radio")
    public WebElement iAmAReturningCustomer;

    @FindBy(id = "signin-form-email")
    public WebElement emailField;

    @FindBy(id = "signin-form-password")
    public WebElement passwordField;

    @FindBy(id = "signin-form-submit")
    public WebElement signInButton;

    @FindBy(xpath = ".//*[@class='popover-content']")
    public WebElement emailErrorMessage;

    public void clickOnIAmANewCustomer(){
        iAmANewCustomer.click();
    }

    public void clickOnContinueAsAGuest(){
        continueAsAGuest.click();
    }

    public void clickOnIAmAReturningCustomer(){
        iAmAReturningCustomer.click();
    }

    public void fillInEmailField (String email){
        emailField.sendKeys(email);
    }

    public void fillInPasswordField (String password){
        passwordField.sendKeys(password);
    }

    public void clickInPasswordField(){
        passwordField.click();
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void continueAsAGuestUser() {
        clickOnIAmANewCustomer();
        clickOnContinueAsAGuest();
    }

    public void loginAsAReturningUser(String email, String pass) {
        clickOnIAmAReturningCustomer();
        fillInEmailField(email);
        fillInPasswordField(pass);
        clickOnSignInButton();
    }
}
