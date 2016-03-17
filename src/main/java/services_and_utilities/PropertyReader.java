package services_and_utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	public String getPropertyValue(String propertyFileName, String propertyName) throws IOException {
		Properties property = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
        if (inputStream != null) {
            property.load(inputStream);
        } else {
            throw new FileNotFoundException("Property file '" + propertyFileName + "'is not found in the testdata.");
        }
        return property.getProperty(propertyName);
    }
}
