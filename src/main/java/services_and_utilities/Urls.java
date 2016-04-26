package services_and_utilities;

import org.openqa.selenium.*;

import java.util.List;

public class Urls {
    public static void getURL(String url, WebDriver driver) {
        Logs.info("Navigate to \""+Constants.URL+url+"\".");
        try {
            driver.get(Constants.URL+url);
        }
        catch (TimeoutException e){
            driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
            Logs.info("Timeout on loading page \""+Constants.URL+url+"\".");
        }
    }

    public static void getDirectlyURL(String url, WebDriver driver) {
        Logs.info("Navigate to \""+url+"\".");
        try {
            driver.get(url);
        }
        catch (TimeoutException e){
            driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
            Logs.info("Timeout on loading page \""+url+"\".");
        }
    }

    public static boolean validateStringInUrl(String url, WebDriver driver){
        if ((driver.getCurrentUrl().contains(url))){
            Logs.info("This is an expected page.");
            return true;
        }
        else
        {
            Logs.info("This is NOT an expected page");
            return false;
        }
    }

    public static void signOut(WebDriver driver){
        driver.get(Constants.URL + Constants.SIGN_OUT_URL);
        driver.navigate().back();
        Logs.info("You sign out now.");
    }

    public static void signOutNoBack(WebDriver driver){
        driver.get(Constants.URL + Constants.SIGN_OUT_URL);
        Logs.info("You sign out now.");
    }

    public static boolean verifyTextPresentOnPage(String someText, WebDriver driver){
        if(driver.getPageSource().contains(someText)){
            Logs.info("\"" + someText + "\" is on the Page.");
            return true;
        }
        else {
            Logs.info("\"" + someText+ "\" is NOT on the Page.");
            return false;
        }
    }

    public  static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
        Logs.info("Page was refreshed.");
    }

    public  static String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public static void switchToFrame(String frameId, WebDriver driver){
        driver.switchTo().frame(frameId);
        Logs.info("Switched to \""+frameId+"\" frame.");
    }

    public static void switchToIframe(int frameIndex, WebDriver driver){
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        int attemptCounter = 0;
        while (frames.size()<=frameIndex){
            frames = driver.findElements(By.tagName("iframe"));
            Waiters.sleep(1);
            attemptCounter++;
            if (attemptCounter == 10){
                Reports.assertTrue(false,"Invalid index of iframe");
            }
        }
        driver.switchTo().frame(frames.get(frameIndex));
        Logs.info("Switch to "+frameIndex+"-index iframe.");
    }

    public static boolean verifyTextPresent(String text, WebDriver driver){
        try {
            driver.findElement(By.xpath(".//*[contains(text(),'"+text+"')]"));
            Logs.info("\""+text+"\" present on page.");
            return true;
        }
        catch (NoSuchElementException e){
            Logs.info("\""+text+"\" does NOT present on page.");
            return false;
        }
    }

    public static String getWindow(WebDriver driver){
        return driver.getWindowHandle();
    }

    public static void switchToWindow(String windowName, WebDriver driver){
        Logs.info("Switch to \""+windowName+"\" window.");
        driver.switchTo().window(windowName);
    }

    public static void switchToWindow(WebDriver driver){
        for (String win:driver.getWindowHandles()){
            driver.switchTo().window(win);
        }
        Logs.info("Switch to another window.");
    }

    public static void closeWindow(WebDriver driver){
        driver.close();
        Logs.info("Close current window.");
    }

    public  static void openNewWindow(WebDriver driver){
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.CONTROL, "n");
        Logs.info("Open new window.");
    }

    public static void navigateBack (WebDriver driver){
        driver.navigate().back();
        Logs.info("Returned to the previous page.");
    }

    public static void skipModalWindow(WebDriver driver){
        Alert alt=driver.switchTo().alert();
        alt.accept();
        Logs.info("Skip modal window.");
    }

    public static String getModalWindowText(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        Logs.info("Modal window text is \""+alert.getText()+"\".");
        return alert.getText();
    }
}
