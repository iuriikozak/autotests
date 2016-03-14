package template_monster.utility;

import TestAutomation.TemplateMonster.utility.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Created by victorp on 09.04.15.
 */
public class PressKeysService {
    public static void pressEnter(WebElement element){
        element.sendKeys(Keys.ENTER);
        Log.info("Press \"Enter\" key.");
    }

    public static void copyAndCut(WebElement element){
        element.sendKeys(Keys.CONTROL, Keys.chord("a"));
        element.sendKeys(Keys.CONTROL, Keys.chord("x"));

    }

    public static void paste(WebElement element){
        element.sendKeys(Keys.CONTROL, Keys.chord("v"));

    }

    public static void pressTab(WebElement element){
        element.sendKeys(Keys.TAB);

    }

    public static void pressShiftTab(WebElement element){
        element.sendKeys(Keys.SHIFT, Keys.TAB);

    }

    public static void pressHome(WebElement element){
        element.sendKeys(Keys.HOME);
        Log.info("Press \"Home\" key.");
    }
}
