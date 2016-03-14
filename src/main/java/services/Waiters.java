package services;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Waiters {
    public static void waitForClickAble(WebElement element, WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (NoSuchElementException e) {
            Assert.assertFalse(true, "Not clickable");
        }
    }

    public static void waitForCookie(String cookieName, WebDriver driver){
        try {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver driver){
                return (driver.manage().getCookieNamed(cookieName)!=null);
            }
        });
    }
        catch (TimeoutException e){
            Assert.assertFalse(true, "No cookie");
        }
    }

    public static void waitForElement(String locator, WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        }
        catch (NoSuchElementException e) {
            Assert.assertFalse(true, "No such element");
        }
    }

    public static void waitForText(WebElement element, WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.textToBePresentInElement(element, element.getText()));
        }
        catch (NoSuchElementException e) {
            Assert.assertFalse(true, "No such text");
        }
    }
}