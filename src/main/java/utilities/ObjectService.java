package utilities;

import TestAutomation.TemplateMonster.utility.Log;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class ObjectService {
    public static int getPrice(WebElement element, String elementName) {

        try {
            String price = element.getText();
            //Log.info("\"" + elementName + "\" content on page  - \"" + price + "\".");

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(price);
            List<String> arrayPrice = new ArrayList<>();

            while (matcher.find()){
                arrayPrice.add(matcher.group());
            }

            if(arrayPrice.size()==1)
            {
                Log.info("Price - " + "\"" + arrayPrice.get(0) + "\"");
                return parseInt(arrayPrice.get(0));
            }
            else
            {
                Log.info("Price - " + "\"" + arrayPrice.get(1) + "\"");
                return parseInt(arrayPrice.get(1));
            }

        }

        catch (NoSuchElementException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
            return 0;
        }
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return 0;
        }
    }

    public static int getPercentPromoDiscount(int price, int percent) {

        //Returns discount.
        float result = (price - Math.round(price - (price * ((float)percent/100))));
        Log.info("\"" + percent + "% from " + price + "$ = " + (int)result + "$\".");
        return (int) result;

    }

    public static int getTotalPriceWithDiscount(int price, int percent) {

        //Returns discount price.
        float result =  Math.round(price - (price * ((float)percent/100)));
        Log.info("\"Total price with discount - " + (int) result + "$\".");
        return (int) result;

    }

    public static boolean verifyDiscountOnPrice(WebElement element, String elementName) {

        try {
            String price = element.getText();
            //Log.info("\"" + elementName + "\" content on page  - \"" + price + "\".");

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(price);
            List<String> arrayPrice = new ArrayList<>();

            while (matcher.find()){
                arrayPrice.add(matcher.group());
            }

            if (arrayPrice.size()>0){
                if(arrayPrice.size()==1)
                {
                    Log.info("No discount, for \""+elementName+"\".");
                    return false;
                }
                else
                {
                    Log.info("\""+elementName+"\" have some discount.");
                    return true;
                }
            }
            else {
                ReportService.assertTrue(false,"Could find any digital price.");
                return false;
            }

        }

        catch (NoSuchElementException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not found on page after timeout.");
            return false;
        }
        catch (ElementNotVisibleException e){
            ReportService.assertTrue(false, "\"" + elementName + "\" was not visible.");
            return false;
        }
    }

    public static String getName(WebElement element,String elementName){
        String name = element.getText();
        //Delete unnecessary chars.
        name = name.replaceAll("\\d+","").replace("$","").replace("+","").trim();
        Log.info(elementName+" has name value - "+name);
        return name;

    }


}
