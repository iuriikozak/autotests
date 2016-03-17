package services_and_utilities;

public class RandomEmail {
    public static String randomEmail() {
        String email = "yuriy-" + System.currentTimeMillis() + "@templatemonster.me";
        return email;
    }
}
