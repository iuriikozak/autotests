package services_and_utilities;

import businessobjects.User;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

	@DataProvider (name = "Credentials")
    public static java.lang.Object[][] Credentials() throws IOException {
		return new java.lang.Object[][] { { new User("properties/user/user.properties") }};
    }

    @DataProvider (name = "UnconfirmedUser")
    public static java.lang.Object[][] UnconfirmedUser() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/unconfirmedUser.properties") }};
    }
	
	@DataProvider (name = "InvalidEmail")
    public static java.lang.Object[][] InvalidEmail() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/negativeLoginIncorrectEmail.properties") }};
    }

    @DataProvider (name = "InvalidPassword")
    public static java.lang.Object[][] InvalidPassword() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/negativeLoginIncorrectPassword.properties") }};
    }

    @DataProvider (name = "EmptyParams")
    public static java.lang.Object[][] EmptyParams() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/negativeLoginNoPasswordEmail.properties") }};
    }

    @DataProvider (name = "EmptyPassword")
    public static java.lang.Object[][] EmptyPassword() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/negativeLoginNoPassword.properties") }};
    }

    @DataProvider (name = "EmptyEmail")
    public static java.lang.Object[][] EmptyEmail() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/negativeLoginNoEmail.properties") }};
    }

    @DataProvider (name = "GuestCredentials")
    public static java.lang.Object[][] GuestCredentials() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/guest.properties") }};
    }

    @DataProvider (name = "UkrainianGuest")

    public static java.lang.Object[][] UkrainianGuest() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/ukrainianGuest.properties") }};
    }

    @DataProvider (name = "GuestContactPhoneCredentials")
    public static java.lang.Object[][] GuestContactPhoneCredentials() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/guestContactPhone.properties") }};
    }

    @DataProvider (name = "CyrillicUser")
    public static java.lang.Object[][] CyrillicUser() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/userCyrillic.properties") }};
    }

    @DataProvider (name = "UkrainianUser")
    public static java.lang.Object[][] UkrainianUser() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/ukrainianUser.properties") }};
    }

    @DataProvider (name = "UkrainianUserWithExclamation")
    public static java.lang.Object[][] UkrainianUserWithExclamation() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/ukrainianExclamationUser.properties.properties") }};
    }

    @DataProvider (name = "ConfirmedUsers")
    public static java.lang.Object[][] ConfirmedUsers() throws IOException {
        return new java.lang.Object[][] {
                { new User("properties/user/without_confirm_user.properties") },
                { new User("properties/user/userCyrillic.properties") },
                { new User("properties/user/userWithSpacesInPassword.properties") },
                { new User("properties/user/user.properties") },
                { new User("properties/user/userWithSpecialCharsInPassword.properties") },
                { new User("properties/user/userWithSecondLevelDomain.properties") }
        };
    }

    @DataProvider (name = "SpacesInPassword")
    public static java.lang.Object[][] SpacesInPassword() throws IOException {
        return new java.lang.Object[][] {
                { new User("properties/user/userWithSpacesInPassword.properties") }};
    }

    @DataProvider (name = "ErrorUsers")
    public static java.lang.Object[][] ErrorUsers() throws IOException {
        return new java.lang.Object[][] {
                { new User("properties/user/unconfirmedUser.properties") },
                { new User("properties/user/negativeLoginIncorrectPassword.properties") }
        };
    }

    @DataProvider (name = "WithOutConfirmedUser")
    public static java.lang.Object[][] WithOutConfirmedUser() throws IOException {
        return new java.lang.Object[][] {
                { new User("properties/user/without_confirm_user.properties") }};
    }



    @DataProvider (name = "ScriptCredentials")
    public static java.lang.Object[][] ScriptCredentials() throws IOException {
        return new java.lang.Object[][] { { new User("properties/billingDetails/script.properties") }};
    }

    @DataProvider (name = "ConfirmedUsersShort")
    public static java.lang.Object[][] ConfirmedUsersShort() throws IOException {
        return new java.lang.Object[][] {
                { new User("properties/user/without_confirm_user.properties") },
                { new User("properties/user/user.properties") }

        };
    }

    @DataProvider (name = "UserMail")
    public static java.lang.Object[][] UserMail() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/userMail.properties") }};
    }

    @DataProvider (name = "BonusUser")
    public static java.lang.Object[][] BonusUser() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/bonusUser.properties") }};
    }

    @DataProvider (name = "EditBillingInfoUser")
    public static java.lang.Object[][] EditBillingInfoUser() throws IOException {
        return new java.lang.Object[][] { { new User("properties/user/userEditBillingInfo.properties") }};
    }
}
