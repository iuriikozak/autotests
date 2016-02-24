package service;

import org.openqa.selenium.WebDriver;

public class Urls {
    public static void getUrl(String url, WebDriver driver) {
        driver.get(Constants.URL+url);
    }
}
