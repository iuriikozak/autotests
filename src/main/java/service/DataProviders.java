package service;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider (name = "InvalidEmail")
    public static Object[][] InvalidEmail(){
        return new Object[][]{
                {"tester.test"},
                {"tester@test"},
                {"tester"},
                {"tester.test@"},
                {"@tester.test"},
                {"test.test"},
                {"test@test"},
                {"test"},
                {"test.test@"},
                {"@test.test"}
        };
    }
}
