package services_and_utilities;

import businessobjects.User;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

	@DataProvider (name = "Credentials")
    public static Object[][] Credentials() throws IOException {
		return new Object[][] { { new User("properties/user/user.properties") }};
    }

    @DataProvider (name = "UnconfirmedUser")
    public static Object[][] UnconfirmedUser() throws IOException {
        return new Object[][] { { new User("properties/user/unconfirmedUser.properties") }};
    }
	
	@DataProvider (name = "InvalidEmail")
    public static Object[][] InvalidEmail() throws IOException {
        return new Object[][] { { new User("properties/negativeLoginIncorrectEmail.properties") }};
    }

    @DataProvider (name = "InvalidPassword")
    public static Object[][] InvalidPassword() throws IOException {
        return new Object[][] { { new User("properties/user/negativeLoginIncorrectPassword.properties") }};
    }

    @DataProvider (name = "EmptyParams")
    public static Object[][] EmptyParams() throws IOException {
        return new Object[][] { { new User("properties/user/negativeLoginNoPasswordEmail.properties") }};
    }

    @DataProvider (name = "EmptyPassword")
    public static Object[][] EmptyPassword() throws IOException {
        return new Object[][] { { new User("properties/user/negativeLoginNoPassword.properties") }};
    }

    @DataProvider (name = "EmptyEmail")
    public static Object[][] EmptyEmail() throws IOException {
        return new Object[][] { { new User("properties/user/negativeLoginNoEmail.properties") }};
    }

    @DataProvider (name = "GuestCredentials")
    public static Object[][] GuestCredentials() throws IOException {
        return new Object[][] { { new User("properties/user/guest.properties") }};
    }

    @DataProvider (name = "UkrainianGuest")
    public static Object[][] UkrainianGuest() throws IOException {
        return new Object[][] { { new User("properties/user/ukrainianGuest.properties") }};
    }

    @DataProvider (name = "GuestContactPhoneCredentials")
    public static Object[][] GuestContactPhoneCredentials() throws IOException {
        return new Object[][] { { new User("properties/user/guestContactPhone.properties") }};
    }

    @DataProvider (name = "CyrillicUser")
    public static Object[][] CyrillicUser() throws IOException {
        return new Object[][] { { new User("properties/user/userCyrillic.properties") }};
    }

    @DataProvider (name = "UkrainianUser")
    public static Object[][] UkrainianUser() throws IOException {
        return new Object[][] { { new User("properties/user/ukrainianUser.properties") }};
    }

    @DataProvider (name = "UkrainianUserWithExclamation")
    public static Object[][] UkrainianUserWithExclamation() throws IOException {
        return new Object[][] { { new User("properties/user/ukrainianExclamationUser.properties.properties") }};
    }

    @DataProvider (name = "ConfirmedUsers")
    public static Object[][] ConfirmedUsers() throws IOException {
        return new Object[][] {
                { new User("properties/user/without_confirm_user.properties") },
                { new User("properties/user/userCyrillic.properties") },
                { new User("properties/user/userWithSpacesInPassword.properties") },
                { new User("properties/user/user.properties") },
                { new User("properties/user/userWithSpecialCharsInPassword.properties") },
                { new User("properties/user/userWithSecondLevelDomain.properties") }
        };
    }

    @DataProvider (name = "SpacesInPassword")
    public static Object[][] SpacesInPassword() throws IOException {
        return new Object[][] {
                { new User("properties/user/userWithSpacesInPassword.properties") }};
    }

    @DataProvider (name = "ErrorUsers")
    public static Object[][] ErrorUsers() throws IOException {
        return new Object[][] {
                { new User("properties/user/unconfirmedUser.properties") },
                { new User("properties/user/negativeLoginIncorrectPassword.properties") }
        };
    }

    @DataProvider (name = "WithOutConfirmedUser")
    public static Object[][] WithOutConfirmedUser() throws IOException {
        return new Object[][] {
                { new User("properties/user/without_confirm_user.properties") }};
    }

    @DataProvider (name = "ScriptCredentials")
    public static Object[][] ScriptCredentials() throws IOException {
        return new Object[][] { { new User("properties/billingDetails/script.properties") }};
    }

    @DataProvider (name = "ConfirmedUsersShort")
    public static Object[][] ConfirmedUsersShort() throws IOException {
        return new Object[][] {
                { new User("properties/user/without_confirm_user.properties") },
                { new User("properties/user/user.properties") }
        };
    }

    @DataProvider (name = "UserMail")
    public static Object[][] UserMail() throws IOException {
        return new Object[][] { { new User("properties/user/userMail.properties") }};
    }

    @DataProvider (name = "BonusUser")
    public static Object[][] BonusUser() throws IOException {
        return new Object[][] { { new User("properties/user/bonusUser.properties") }};
    }

    @DataProvider (name = "EditBillingInfoUser")
    public static Object[][] EditBillingInfoUser() throws IOException {
        return new Object[][] { { new User("properties/user/userEditBillingInfo.properties") }};
    }
}
