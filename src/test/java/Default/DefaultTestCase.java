package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import service.Log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DefaultTestCase {
    public static WebDriver driver;

    @BeforeSuite
    public void startSuite(){
        Log.info("Start suite");
    }

    @BeforeTest
    public void startTest() throws MalformedURLException {
        Log.info("Start test");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        URL hostURL = new URL("http://192.168.51.80:4444/wd/hub");
        driver = new RemoteWebDriver(hostURL, capabilities);
        //driver = new FirefoxDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        Log.info("Stop test");
    }

    @AfterSuite
    public void afterSuite(){
        Log.info("Stop suite");
    }
}
