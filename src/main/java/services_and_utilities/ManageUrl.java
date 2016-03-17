package services_and_utilities;

import org.openqa.selenium.*;

import java.util.List;

public class ManageUrl {
    public static void getURL(String url, WebDriver driver) {
        Log.info("Navigate to \""+Constants.URL+url+"\".");
        try {
            driver.get(Constants.URL+url);
        }
        catch (TimeoutException e){
            driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
            Log.info("Timeout on loading page \""+Constants.URL+url+"\".");
        }
    }

    public static void getDirectlyURL(String url, WebDriver driver) {
        Log.info("Navigate to \""+url+"\".");
        try {
            driver.get(url);
        }
        catch (TimeoutException e){
            driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
            Log.info("Timeout on loading page \""+url+"\".");
        }
    }

    public static boolean validateStringInUrl(String url, WebDriver driver){
        if ((driver.getCurrentUrl().contains(url))){
            Log.info("This is an expected page.");
            return true;
        }
        else
        {
            //Log.info("This is NOT an expected page");
            return false;
        }
    }

    public static void signOut(WebDriver driver){
        driver.get(Constants.URL + Constants.SIGN_OUT_URL);
        driver.navigate().back();
        Log.info("You sign out now.");
    }

    public static void signOutNoBack(WebDriver driver){
        driver.get(Constants.URL + Constants.SIGN_OUT_URL);
        Log.info("You sign out now.");
    }

    public static boolean verifyTextPresentOnPage(String someText, WebDriver driver){
        if(driver.getPageSource().contains(someText)){
            Log.info("\"" + someText + "\" is on the Page.");
            return true;
        }
        else {
            Log.info("\"" + someText+ "\" is NOT on the Page.");
            return false;
        }
    }

    public  static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
        Log.info("Page was refreshed.");
    }

    public  static String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public static void switchToFrame(String frameId, WebDriver driver){
        driver.switchTo().frame(frameId);
        Log.info("Switched to \""+frameId+"\" frame.");
    }

    public static void switchToIframe(int frameIndex, WebDriver driver){
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        int attemptCounter = 0;
        while (frames.size()<=frameIndex){
            frames = driver.findElements(By.tagName("iframe"));
            Waiters.sleep(1);
            attemptCounter++;
            if (attemptCounter == 10){
                ReportService.assertTrue(false,"Invalid index of iframe");
            }
        }
        driver.switchTo().frame(frames.get(frameIndex));
        Log.info("Switch to "+frameIndex+"-index iframe.");
    }

    public static boolean verifyTextPresent(String text, WebDriver driver){
        try {
            driver.findElement(By.xpath(".//*[contains(text(),'"+text+"')]"));
            Log.info("\""+text+"\" present on page.");
            return true;
        }
        catch (NoSuchElementException e){
            Log.info("\""+text+"\" does NOT present on page.");
            return false;
        }
    }

    public static String getWindow(WebDriver driver){
        return driver.getWindowHandle();
    }

    public static void switchToWindow(String windowName, WebDriver driver){
        Log.info("Switch to \""+windowName+"\" window.");
        driver.switchTo().window(windowName);
    }

    public static void switchToWindow(WebDriver driver){
        for (String win:driver.getWindowHandles()){
            driver.switchTo().window(win);
        }
        Log.info("Switch to another window.");
    }

    public static void closeWindow(WebDriver driver){
        driver.close();
        Log.info("Close current window.");
    }

    public  static void openNewWindow(WebDriver driver){
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.CONTROL, "n");
        Log.info("Open new window.");
    }

    public static void navigateBack (WebDriver driver){
        driver.navigate().back();
        Log.info("Returned to the previous page.");
    }

    public static void skipModalWindow(WebDriver driver){
        Alert alt=driver.switchTo().alert();
        alt.accept();
        Log.info("Skip modal window.");
    }

    public static String getModalWindowText(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        Log.info("Modal window text is \""+alert.getText()+"\".");
        return alert.getText();
    }
}
