package service;

import org.openqa.selenium.WebDriver;

public class Cookies {
    public static String getValueOfCookieNamed(String name, WebDriver driver) {
        Waiters.waitForCookie(name, driver);
        return driver.manage().getCookieNamed(name).getValue();
    }
}
