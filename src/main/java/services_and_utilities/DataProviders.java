package services_and_utilities;

import businessobjects.User;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider (name = "UserLogin")
    public static Object[][] UserLogin() throws IOException {
        return new Object[][] { { new User("properties/UserData.properties") }};
    }
	
	@DataProvider (name = "InvalidEmail")
    public static Object[][] InvalidEmail() throws IOException {
        return new Object[][] { { new User("properties/IncorrectEmail.properties") }};
    }
}
