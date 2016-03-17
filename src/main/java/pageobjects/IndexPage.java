package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services_and_utilities.Elements;
import services_and_utilities.Waiters;

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
        Elements.clickOnElement(driver, signInLink, "signInLink");
    }

    public void clickOnSignOut(){
        Elements.clickOnElement(driver, signOutLink, "signOutLink");
    }

    public void fillInEmail(String email){
        Elements.sendKeys(emailField, "emailField", email);
    }

    public void fillInPassword(String pass){
        Elements.sendKeys(passwordField, "passwordField", pass);
    }

    public void clickOnSubmit(){
        Elements.clickOnElement(driver, signInButton, "signInButton");
    }

    public void fillInSearchForm(String template){
        Elements.sendKeys(searchForm, "searchForm", template);
    }

    public void clickOnSearchFormSubmit(){
        Elements.clickOnElement(driver, searchFormSubmit, "searchFormSubmit");
    }

    public void clickOnShoppingCart(){
        Elements.clickOnElement(driver, shoppingCart, "shoppingCart");
    }

    public void clickOnLiveChat(){
        Elements.clickOnElement(driver, liveChat, "liveChat");
    }

    public void fillInLiveChatName(String name){
        Elements.sendKeys(liveChatName, "liveChatName", name);
    }

    public void fillInLiveChatEmail(String email){
        Elements.clickOnElement(driver, liveChatEmail, "liveChatEmail");
    }

    public void clickOnLiveChatStart(){
        Elements.clickOnElement(driver, liveChatStart, "liveChatStart");
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
