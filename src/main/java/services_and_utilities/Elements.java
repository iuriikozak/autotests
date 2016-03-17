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
                Logs.info("\"" + elementName + "\" border is red");
                return "red";
            case "rgba(38, 115, 180, 1)":
                Logs.info("\"" + elementName +"\" border is blue");
                return "blue";
            case "rgba(160, 160, 160, 1)":
                Logs.info("\"" + elementName +"\" border is grey");
                return "grey";
            case "rgba(130, 130, 130, 1)":
                    Logs.info("\"" + elementName +"\" border is dark_grey");
                    return "dark_grey";
            default:
                Logs.info("\"" + elementName +"\" border is "+element.getCssValue("border-top-color"));
                return "unknown";
            }
        }
    	catch (NoSuchElementException e){
    		Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    		return null;
    	}
        catch (ElementNotVisibleException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return null;
        }
    }

    public static boolean checkFocusOnElement(WebElement element, String elementName, WebDriver driver){
        int attempt_counter = 0;
        while (!element.equals(driver.switchTo().activeElement())){
            Waiters.sleep(1);
            attempt_counter++;
            if (attempt_counter == 5){
                Logs.error("Break, element isn't focused by timeout.");
                break;
            }
        }
        //Check that field is focused.
        if(element.equals(driver.switchTo().activeElement())){
            Logs.info("\"" + elementName + "\" field is focused.");
            return true;
        }
        else {
            Logs.info("\"" + elementName + "\" field is NOT focused.");
            return false;
        }
    }

    public static boolean elementIsDisplayed(WebElement element, String elementName){
       try {
            element.isDisplayed();
            Logs.info("\"" + elementName + "\" is displayed.");
            return true;
        }
        catch (NoSuchElementException e){
            Logs.info("\"" + elementName + "\" is NOT displayed.");
            return false;
        }
       catch (ElementNotVisibleException e){
           Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
           return false;
       }
       catch (StaleElementReferenceException e){
           //Reports.assertTrue(false, "\"" + elementName + "\" was not in the cache.");
           return false;
       }
    }

    public static boolean elementIsEnable(WebElement element, String elementName){
        if (element.isEnabled()){
            Logs.info("\"" + elementName + "\" is enabled.");
            return true;
        }
        else {
            Logs.info("\"" + elementName + "\" is disabled.");
            return false;
        }
    }

    public static void clickOnElement(WebDriver driver, WebElement element, String elementName){
    	try {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Logs.info("Click on \"" + elementName +"\".");
    	}
    	catch (NoSuchElementException  e){
    		Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    	}
        catch (ElementNotVisibleException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
        }
        catch (TimeoutException e){
            //Reports.assertTrue(false, "\"" + elementName + "\" is not clickable.");
            Logs.info("\"" + elementName + "\" is not clickable.");
            element.click();
        }
    }

	public static boolean checkElementSelected(WebElement element, String elementName){
		//Check Elements is selected.
		Logs.info("Verify \"" + elementName + "\" is selected.");
	    if(element.isSelected()){
	        Logs.info("\"" + elementName + "\" is selected.");
	        return true;
	    }
	    else {
	        Logs.info("\"" + elementName + "\" is NOT selected.");
	        return false;
	    }
	}

    public static String getElementValue(WebElement element, String elementName){
    	try {
    	//Get text in input field.
        String value = element.getAttribute("value");
        Logs.info("\"" + elementName +"\" value in input field  - \"" + value + "\".");
        return value;
    	}
    	catch (NoSuchElementException e){
    		Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    		return null;
    	}
        catch (ElementNotVisibleException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return null;
        }
    }

    public static String getElementText(WebElement element, String elementName){
    	try {
        String text = element.getText();
        Logs.info("\"" + elementName +"\" content on page  - \"" + text + "\".");
        return text;
    	}
    	catch (NoSuchElementException e){
    		Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    		return null;
    	}
        catch (ElementNotVisibleException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return null;
        }
    }

    public static void sendKeys(WebElement element, String elementName, String inputText){
    	try {
    	element.sendKeys(inputText);
        Logs.info("\"" + elementName + "\" input text: \"" + inputText + "\".");
    	}
    	catch (NoSuchElementException e){
    		Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    	}
        catch (ElementNotVisibleException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
        }
    }

    public static void sendKeysClear(WebElement element, String elementName, String inputText){
    	try {
        element.clear();
        element.sendKeys(inputText);
        Logs.info("\"" + elementName + "\" input text: \"" + inputText + "\".");
    	}
    	catch (NoSuchElementException e ){
    		Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
    	}
        catch (ElementNotVisibleException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
        }
    }

    public static void moveToElement(WebElement element, String elementName, WebDriver driver) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            Waiters.sleep(1);
            Logs.info("\"" + elementName + "\" is active.");
        }
        catch (NoSuchElementException e){
            Reports.assertTrue(false, "\"" + elementName + "\" not found.");
        }
        catch (ElementNotVisibleException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
        }
    }

    public static void selectDropBoxByText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
        Logs.info("Select \""+text+"\".");
    }

    public static void verifyTextPresent (String text, WebDriver driver){
        Reports.assertTrue(driver.getPageSource().contains(text), "\"" + text + "\" was not visible.");
        Logs.info("\"" + text + "\" is present.");
    }

    public static String getBackgroundColor(WebElement element, String elementName){
        try {
            String color = element.getCssValue("background-color");
            Logs.info("Grab color - \""+color+"\".");
            return color;
        }
        catch (NoSuchElementException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
            return null;
        }
    }

    public static String getBorderColor(WebElement element, String elementName){
        try {
            String color = element.getCssValue("border-top-color");
            Logs.info("Grab color - \""+color+"\".");
            return color;
        }
        catch (NoSuchElementException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
            return null;
        }
    }

    public static String getElementFontColor(WebElement element, String elementName){
        try {
            switch (element.getCssValue("color")){
                case "rgba(222, 74, 74, 1)":
                    Logs.info("\"" + elementName + "\" font is red");
                    return "red";
                case "rgba(38, 115, 180, 1)":
                    Logs.info("\"" + elementName +"\" font is blue");
                    return "blue";
                case "rgba(160, 160, 160, 1)":
                    Logs.info("\"" + elementName +"\" font is grey");
                    return "grey";
                default:
                    Logs.info("\"" + elementName +"\" font is "+element.getCssValue("border-top-color"));
                    return "unknown";
            }
        }
        catch (NoSuchElementException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
            return null;
        }
        catch (ElementNotVisibleException e){
            Reports.assertTrue(false, "\"" + elementName + "\" was not visible.");
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
                Logs.warn("StaleElementReferenceException");
                flag = true;
            }
            catch (NoSuchElementException e){
                Logs.warn("NoSuchElementException");
                flag = true;
            }
            catch (Exception e){
                Reports.assertTrue(false, "Unknown exception.");
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
                Logs.warn("StaleElementReferenceException");
            }
            catch (NoSuchElementException e){
                flag = true;
                Logs.warn("NoSuchElementException");
            }
            catch (Exception e){
                Reports.assertTrue(false, "Unknown exception.");
            }
        }
        return element;
    }

    public static void clear(WebElement element, String elementName){
        element.clear();
        Logs.info("\""+elementName+"\" field clear.");
    }
}
