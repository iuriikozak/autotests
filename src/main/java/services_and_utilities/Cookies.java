package services_and_utilities;

import org.openqa.selenium.WebDriver;

public class Cookies {
    public static String getCookieValue(String cookieName, WebDriver driver){
        if (driver.manage().getCookieNamed(cookieName)!=null){
            String value = driver.manage().getCookieNamed(cookieName).getValue();
            Log.info("Cookie: \"" + cookieName + "\" has value - \"" + value + "\".");
            return value;
        }
        else {
            ReportService.assertTrue(false, "Cookie: \"" + cookieName + "\" was not found after timeout.");
            return null;
        }
    }

    public static void deleteCookie(String cookieName, WebDriver driver){
        if (driver.manage().getCookieNamed(cookieName)!=null){
            driver.manage().deleteCookieNamed(cookieName);
            Log.info("Delete \""+cookieName+"\" cookie.");
        }
        else {
            ReportService.assertTrue(false, "Couldn't find \""+cookieName+"\" cookie.");
        }
    }

    public static boolean verifyCookieIsSet(String cookieName, WebDriver driver){
        return driver.manage().getCookieNamed(cookieName) != null;
    }
}
