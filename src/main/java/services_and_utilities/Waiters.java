package services_and_utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    public static void waitForCookie(String cookieName, WebDriver driver){
        int attempt_counter = 0;
        while (driver.manage().getCookieNamed(cookieName)==null){
            Waiters.sleep(1);
            attempt_counter++;
            if (attempt_counter == 20){
                Log.warn("Cookie: \"" + cookieName + "\" was NOT found, break by attempt counter.");
                break;}
        }
    }

    public static void waitForCookieUnset(String cookieName, WebDriver driver){
        int attempt_counter = 0;
        while (driver.manage().getCookieNamed(cookieName) != null){
            Waiters.sleep(1);
            attempt_counter++;
            if (attempt_counter == 20){
                Log.warn("Cookie: \"" + cookieName + "\" is still set.");
                break;}
        }
    }

    public static void waitPageLoader(String url, WebDriver driver){
        Log.info("Waiting for \"" + url + "\" page.");
        int attempt_counter = 0;
        while (!ManageUrl.validateStringInUrl(url, driver)){
            Waiters.sleep(1);
            attempt_counter++;
            if (attempt_counter == 30) {
            	Log.error("This is NOT an expected page.");
                ReportService.assertTrue(false,"Expected page hasn't loaded  by timeout.");
                break;
            }
        }
        Log.info("Waited for \"" + url + "\" page during " + attempt_counter + " seconds.");
        ReportService.assertTrue(ManageUrl.validateStringInUrl(url, driver), "\"" + url + "\" page was not loaded after 30 seconds.");
    }

    public static void waitElementBorderColor(org.openqa.selenium.WebElement element, String elementName, String color){
        int attempt_counter = 0;
        while (!Elements.getElementBorderColor(element, elementName).equals(color)){
            Log.info("Waiting for "+elementName+" has "+color+" color.");
            Waiters.sleep(1);
            attempt_counter++;
            if (attempt_counter == 5){
                Log.error("Break, element border hasn't an expected color.");
                break;
            }
        }
    }

    public static void waitForElementDisappear(org.openqa.selenium.WebElement element, String elementName){
        Log.info("Wait for element: \"" + elementName + "\" disappear.");
        int attempt_counter = 0;
        while (Elements.elementIsDisplayed(element,elementName)) {
            Waiters.sleep(1);
            attempt_counter++;
            if (attempt_counter == 5){
                ReportService.assertTrue(false, "\"" + elementName + "\" not disappeared after timeout.");
                break;
           }
	    }
    }

    public static void waitForTextVisible(String text, org.openqa.selenium.WebElement element, WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            Log.info("TEXT: \"" + text +"\" is present.");
        }
        catch (TimeoutException e){
            ReportService.assertTrue(false, "TEXT: \"" + text + "\" is not presents.");
        }
        catch (NoSuchElementException e){
            ReportService.assertTrue(false, "This element not found.");
        }
    }

    public  static void waitForTextIsEmpty(org.openqa.selenium.WebElement element){
        try {
            int attempt_counter = 0;
            while (!(element.getText().isEmpty())){
                Waiters.sleep(1);
                attempt_counter++;
                if (attempt_counter == 10){
                    ReportService.assertTrue(false,"Unnecessary string still present after "+attempt_counter+" seconds waiting "+element.getText());
                    break;
                }
            }
        }
        catch ( NoSuchElementException e){
            Log.error("Caught exception" + e);
        }
    }

    public  static void pageLoaderWait(WebDriver driver){
        try {
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>(){
                public Boolean apply(WebDriver driver){
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(pageLoadCondition);
        }
        catch (WebDriverException e){
            Log.warn("waiting for doc.body failed");
        }
    }

    public static void waitForElementVisible(org.openqa.selenium.WebElement element, WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Log.info("ELEMENT: \"" + element +"\" is present.");
        }
        catch (TimeoutException e){
            ReportService.assertTrue(false, "ELEMENT: \"" + element + "\" is not presents.");
        }
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void iFrameWait(int amount, WebDriver driver){
        int attempt = 0;
        while ((driver.findElements(By.tagName("iframe")).size())!=amount){
            Waiters.sleep(1);
            if (attempt==5){
                break;
            }
        }
    }

    public  static void waitForCookieValue(String cookie, String value, WebDriver driver){
        int attempt = 0;
        boolean flag = true;
        Log.info("Waiting for cookie \""+cookie+"\" became - "+value+".");
        while (flag && attempt<10){
            attempt++;
            Waiters.sleep(1);
            if (driver.manage().getCookieNamed(cookie).getValue().equals(value)){
                flag = false;
                Log.info("Cookie "+cookie+"\" became - "+value+".");
            }
        }
    }
}
