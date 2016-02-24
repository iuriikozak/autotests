package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import service.Waiters;

import java.util.Arrays;
import java.util.List;

public class ShoppingCart {
    private WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "cart-count")
    public WebElement cartCount;

    @FindBy(xpath = ".//*[@class='checkout-button']")
    public WebElement checkoutNow;

    public void clickOnCheckoutNow(){
        Waiters.waitForClickAble(checkoutNow, driver);
        checkoutNow.click();
    }

    public int countProducts(){
        Waiters.waitForText(cartCount, driver);
        return Integer.parseInt(cartCount.getText());
    }

    public int takeNumbersOfTemplates()[]{
        List<WebElement> numbersOfTemplates = driver.findElements(By.xpath(".//*[contains(@class,'js-license-default')]"));
        int takenNumbers[] = new int[numbersOfTemplates.size()];
        int i = 0;
        for (WebElement element: numbersOfTemplates) {
            takenNumbers[i] = Integer.valueOf(element.getAttribute("data-template_id"));
            i++;
        }
        Arrays.sort(takenNumbers);
        return takenNumbers;
    }

    public int takeTotalPriceOfTemplates(){
        List<WebElement> priceOfTemplates = driver.findElements(By.xpath(".//*[contains(@class,'js-license-default')]"));
        int total = 0;
        for (WebElement element: priceOfTemplates) {
            total += Integer.valueOf(element.getAttribute("data-price"));
        }
        return total;
    }

    public int takeSubtotal(){
        Waiters.waitForElement(".//*[@class='price  js-price']", driver);
        int subtotal = Integer.valueOf(driver.findElement(By.xpath(".//*[@class='price  js-price']")).getAttribute("data-price"));
        return subtotal;
    }

    public int takeOrderTotal(){
        Waiters.waitForElement(".//*[@class='template-price js-total-price']", driver);
        int orderTotal = Integer.valueOf(driver.findElement(By.xpath(".//*[@class='template-price js-total-price']")).getAttribute("data-price"));
        return orderTotal;
    }

    public void deleteTemplateNumber(int number){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(".//*[@class='del-template js-dell-template' and @data-product='"+number+"']/i"))).click().build().perform();
        driver.navigate().refresh();
    }
}
