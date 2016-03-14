package services;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider (name = "InvalidEmail")
    public static Object[][] InvalidEmail(){
        return new Object[][]{
                {"tester.test"},
                {"tester"},
                {"test"}
        };
    }
}
