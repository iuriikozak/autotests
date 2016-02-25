package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.Waiters;

public class IndexPage {
    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "signin-link")
    public WebElement signInLink;

    @FindBy(id = "signout-link")
    public WebElement signOutLink;

    @FindBy(id = "signin-form-email")
    public WebElement emailField;

    @FindBy(id = "signin-form-password")
    public WebElement passwordField;

    @FindBy(id = "signin-form-submit")
    public WebElement signInButton;

    @FindBy(name = "keywords")
    public WebElement searchForm;

    @FindBy(id = "searchFormSubmit")
    public WebElement searchFormSubmit;

    @FindBy(xpath = ".//*[@class='shop-cart js-btn link-click']")//не стабильный
    public WebElement shoppingCart;

    @FindBy(xpath = ".//*[@class='block live-chat live-chat-out ']")//не стабильный
    public WebElement liveChat;

    @FindBy(id = "live-chat-form-name")
    public WebElement liveChatName;

    @FindBy(id = "live-chat-form-email")
    public WebElement liveChatEmail;

    @FindBy(id = "live-chat-form-submit")
    public WebElement liveChatStart;

    @FindBy(xpath = ".//*[@class='header-panel']")
    public WebElement liveChatHeader;

    public void clickOnSignIn(){
        Waiters.waitForClickAble(signInLink, driver);
        signInLink.click();
    }

    public void clickOnSignOut(){
        Waiters.waitForClickAble(signOutLink, driver);
        signOutLink.click();
    }

    public void fillInEmail(String email){
        Waiters.waitForClickAble(emailField, driver);
        emailField.sendKeys(email);
    }

    public void fillInPassword(String pass){
        Waiters.waitForClickAble(passwordField, driver);
        passwordField.sendKeys(pass);
    }

    public void clickOnSubmit(){
        Waiters.waitForClickAble(signInButton, driver);
        signInButton.click();
    }

    public void fillInSearchForm(String template){
        Waiters.waitForClickAble(searchForm, driver);//линее
        searchForm.sendKeys(template);
    }

    public void clickOnSearchFormSubmit(){
        Waiters.waitForClickAble(searchFormSubmit, driver);
        searchFormSubmit.click();
    }

    public void clickOnShoppingCart(){
        Waiters.waitForClickAble(shoppingCart, driver);
        shoppingCart.click();
    }

    public void clickOnLiveChat(){
        Waiters.waitForClickAble(liveChat, driver);
        liveChat.click();
    }

    public void fillInLiveChatName(String name){
        Waiters.waitForClickAble(liveChatName, driver);
        liveChatName.sendKeys(name);
    }

    public void fillInLiveChatEmail(String email){
        Waiters.waitForClickAble(liveChatEmail, driver);
        liveChatEmail.sendKeys(email);
    }

    public void clickOnLiveChatStart(){
        Waiters.waitForClickAble(liveChatStart, driver);
        liveChatStart.click();
    }

    public void login(String email, String pass){
        clickOnSignIn();
        fillInEmail(email);
        fillInPassword(pass);
        clickOnSubmit();
    }

    public void search(String template){
        fillInSearchForm(template);
        clickOnSearchFormSubmit();
    }

    public void startChat(String name, String email){
        clickOnLiveChat();
        fillInLiveChatName(name);
        fillInLiveChatEmail(email);
        clickOnLiveChatStart();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}
