package services_and_utilities;

import org.openqa.selenium.WebDriver;

public class Cookies {
    public static String getCookieValue(String cookieName, WebDriver driver){
        if (driver.manage().getCookieNamed(cookieName)!=null){
            String value = driver.manage().getCookieNamed(cookieName).getValue();
            Logs.info("Cookie: \"" + cookieName + "\" has value - \"" + value + "\".");
            return value;
        }
        else {
            Reports.assertTrue(false, "Cookie: \"" + cookieName + "\" was not found after timeout.");
            return null;
        }
    }

    public static void deleteCookie(String cookieName, WebDriver driver){
        if (driver.manage().getCookieNamed(cookieName)!=null){
            driver.manage().deleteCookieNamed(cookieName);
            Logs.info("Delete \""+cookieName+"\" cookie.");
        }
        else {
            Reports.assertTrue(false, "Couldn't find \""+cookieName+"\" cookie.");
        }
    }

    public static boolean verifyCookieIsSet(String cookieName, WebDriver driver){
        return driver.manage().getCookieNamed(cookieName) != null;
    }
}
