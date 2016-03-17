package services_and_utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReportService {
	public static void takeScreenshot(String testCaseName, String message, WebDriver driver) throws IOException {
		String screenshotName = testCaseName + "ScreenShot.png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		final BufferedImage image = ImageIO.read(scrFile);
		Graphics g = image.getGraphics();
	    g.setFont(new Font("Arial Black", Font.PLAIN, 20));
	    g.setColor(Color.DARK_GRAY);
	    g.drawString("URL: " + message, 50, 100);
	    g.dispose();
	    ImageIO.write(image, "png", new File("target/screenshots/" + screenshotName));
	    Log.info("");
	    Log.warn("Screenshot captured.");
		Log.warn("Screenshot name: \"" + screenshotName + "\".");
	}
	
	public static void assertTrue(Boolean condition, String errorMessage ) {
		if (condition == false){
			Log.info("");
			Log.error("ACTUAL RESULT:");
			Log.error(errorMessage);
		}
		Assert.assertTrue(condition);
	}
	
	public static void assertFalse(Boolean condition, String errorMessage ) {
		if (condition == true){
			Log.info("");
			Log.error("ACTUAL RESULT:");
			Log.error(errorMessage);
		}
		Assert.assertFalse(condition);
	}

	public static void assertEquals(String condition1, String condition2, String errorMessage) {
		if (!condition1.equalsIgnoreCase(condition2)){
			Log.info("");
			Log.error("ACTUAL RESULT:");
			Log.error(errorMessage);
			Log.error("Expected: \"" + condition2 + "\", but found: \"" + condition1 + "\".");
		}
		Assert.assertEquals(condition1, condition2);
	}

    public static void assertEquals(Integer condition1, Integer condition2, String errorMessage) {
        if (!condition1.equals(condition2)){
            Log.info("");
            Log.error("ACTUAL RESULT:");
            Log.error(errorMessage);
            Log.error("Expected: \"" + condition2 + "\", but found: \"" + condition1 + "\".");
        }
        Assert.assertEquals(condition1, condition2);
    }
}
