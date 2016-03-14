package services;

public class RandomEmail {
    public static String randomEmail() {
        String email = "yuriy-" + System.currentTimeMillis() + "@templatemonster.me";
        return email;
    }
}
