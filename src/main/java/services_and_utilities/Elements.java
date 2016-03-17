package services_and_utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {
    public static String getElementBorderColor(WebElement element, String elementName){
        try {
            switch (element.getCssValue("border-top-color")){
            case "rgba(222, 74, 74, 1)":
                Log.info("\"" + elementName + "\" border is red");
                return "red";
            case "rgba(38, 115, 180, 1)":
                Log.info("\"" + elementName +"\" border is blue");
                return "blue";
            case "rgba(160, 160, 160, 1)":
                Log.info("\"" + elementName +"\" border is grey");
                return "grey";
            case "rgba(130, 130, 130, 1)":
                    Log.info("\"" + elementName +"\" border is dark_grey");
                    return "dark_grey";
            default:
                Log.info("\"" + elementName +"\" border is "+element.getCssValue("border-top-color"));
                return "unknown";
            }
        }
    	catch (NoSuchElementException e){
    		ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    		return null;
    	}
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return null;
        }
    }

    public static boolean checkFocusOnElement(WebElement element, String elementName, WebDriver driver){
        int attempt_counter = 0;
        while (!element.equals(driver.switchTo().activeElement())){
            Waiters.sleep(1);
            attempt_counter++;
            if (attempt_counter == 5){
                Log.error("Break, element isn't focused by timeout.");
                break;
            }
        }
        //Check that field is focused.
        if(element.equals(driver.switchTo().activeElement())){
            Log.info("\"" + elementName + "\" field is focused.");
            return true;
        }
        else {
            Log.info("\"" + elementName + "\" field is NOT focused.");
            return false;
        }
    }

    public static boolean elementIsDisplayed(WebElement element, String elementName){
       try {
            element.isDisplayed();
            Log.info("\"" + elementName + "\" is displayed.");
            return true;
        }
        catch (NoSuchElementException e){
            Log.info("\"" + elementName + "\" is NOT displayed.");
            return false;
        }
       catch (ElementNotVisibleException e){
           ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
           return false;
       }
       catch (StaleElementReferenceException e){
           //ReportService.assertTrue(false, "\"" + elementName + "\" was not in the cache.");
           return false;
       }
    }

    public static boolean elementIsEnable(WebElement element, String elementName){
        if (element.isEnabled()){
            Log.info("\"" + elementName + "\" is enabled.");
            return true;
        }
        else {
            Log.info("\"" + elementName + "\" is disabled.");
            return false;
        }
    }

    public static void clickOnElement(WebDriver driver, WebElement element, String elementName){
    	try {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Log.info("Click on \"" + elementName +"\".");
    	}
    	catch (NoSuchElementException  e){
    		ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    	}
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
        }
        catch (TimeoutException e){
            //ReportService.assertTrue(false, "\"" + elementName + "\" is not clickable.");
            Log.info("\"" + elementName + "\" is not clickable.");
            element.click();
        }
    }

	public static boolean checkElementSelected(WebElement element, String elementName){
		//Check Elements is selected.
		Log.info("Verify \"" + elementName + "\" is selected.");
	    if(element.isSelected()){
	        Log.info("\"" + elementName + "\" is selected.");
	        return true;
	    }
	    else {
	        Log.info("\"" + elementName + "\" is NOT selected.");
	        return false;
	    }
	}

    public static String getElementValue(WebElement element, String elementName){
    	try {
    	//Get text in input field.
        String value = element.getAttribute("value");
        Log.info("\"" + elementName +"\" value in input field  - \"" + value + "\".");
        return value;
    	}
    	catch (NoSuchElementException e){
    		ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    		return null;
    	}
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return null;
        }
    }

    public static String getElementText(WebElement element, String elementName){
    	try {
        String text = element.getText();
        Log.info("\"" + elementName +"\" content on page  - \"" + text + "\".");
        return text;
    	}
    	catch (NoSuchElementException e){
    		ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    		return null;
    	}
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return null;
        }
    }

    public static void sendKeys(WebElement element, String elementName, String inputText){
    	try {
    	element.sendKeys(inputText);
        Log.info("\"" + elementName + "\" input text: \"" + inputText + "\".");
    	}
    	catch (NoSuchElementException e){
    		ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    	}
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
        }
    }

    public static void sendKeysClear(WebElement element, String elementName, String inputText){
    	try {
        element.clear();
        element.sendKeys(inputText);
        Log.info("\"" + elementName + "\" input text: \"" + inputText + "\".");
    	}
    	catch (NoSuchElementException e ){
    		ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    	}
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
        }
    }

    public static void moveToElement(WebElement element, String elementName, WebDriver driver) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            Waiters.sleep(1);
            Log.info("\"" + elementName + "\" is active.");
        }
        catch (NoSuchElementException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" not found.");
        }
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
        }
    }

    public static void selectDropBoxByText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
        Log.info("Select \""+text+"\".");
    }

    public static void verifyTextPresent (String text, WebDriver driver){
        ReportService.assertTrue(driver.getPageSource().contains(text), "\"" + text + "\" was not visible.");
        Log.info("\"" + text + "\" is present.");
    }

    public static String getBackgroundColor(WebElement element, String elementName){
        try {
            String color = element.getCssValue("background-color");
            Log.info("Grab color - \""+color+"\".");
            return color;
        }
        catch (NoSuchElementException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
            return null;
        }
    }

    public static String getBorderColor(WebElement element, String elementName){
        try {
            String color = element.getCssValue("border-top-color");
            Log.info("Grab color - \""+color+"\".");
            return color;
        }
        catch (NoSuchElementException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
            return null;
        }
    }

    public static String getElementFontColor(WebElement element, String elementName){
        try {
            switch (element.getCssValue("color")){
                case "rgba(222, 74, 74, 1)":
                    Log.info("\"" + elementName + "\" font is red");
                    return "red";
                case "rgba(38, 115, 180, 1)":
                    Log.info("\"" + elementName +"\" font is blue");
                    return "blue";
                case "rgba(160, 160, 160, 1)":
                    Log.info("\"" + elementName +"\" font is grey");
                    return "grey";
                default:
                    Log.info("\"" + elementName +"\" font is "+element.getCssValue("border-top-color"));
                    return "unknown";
            }
        }
        catch (NoSuchElementException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
            return null;
        }
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return null;
        }
    }

    public static WebElement getElement(By locator, WebDriver driver){
        WebElement element = null;
        boolean flag  = true;
        int attempt = 0;
        while (flag && attempt<10){
            attempt++;
            Waiters.sleep(1);
            try {
                element = driver.findElement(locator);
                flag = false;
            }
            catch (StaleElementReferenceException e){
                Log.warn("StaleElementReferenceException");
                flag = true;
            }
            catch (NoSuchElementException e){
                Log.warn("NoSuchElementException");
                flag = true;
            }
            catch (Exception e){
                ReportService.assertTrue(false, "Unknown exception.");
            }
        }
        return element;
    }

    public static WebElement getElement(By locator, WebElement webElement){
        WebElement element = null;
        boolean flag  = true;
        int attempt = 0;
        while (flag && attempt<10){
            attempt++;
            Waiters.sleep(1);
            try {
                element = webElement.findElement(locator);
                flag = false;
            }
            catch (StaleElementReferenceException e){
                flag = true;
                Log.warn("StaleElementReferenceException");
            }
            catch (NoSuchElementException e){
                flag = true;
                Log.warn("NoSuchElementException");
            }
            catch (Exception e){
                ReportService.assertTrue(false, "Unknown exception.");
            }
        }
        return element;
    }

    public static void clear(WebElement element, String elementName){
        element.clear();
        Log.info("\""+elementName+"\" field clear.");
    }
}
