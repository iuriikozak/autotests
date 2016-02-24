package service;

import java.util.Properties;
import javax.mail.*;

public class GmailInbox {

    public static Session authorization() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
            }
        });
        return session;
    }

    public static void clear() {
        Session session = authorization();
        try {
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", Constants.EMAIL_ADDRESS, Constants.PASSWORD);

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_WRITE);

            Message[] messages = inbox.getMessages();
            inbox.setFlags(messages, new Flags(Flags.Flag.DELETED), true);

            inbox.close(true);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read() {
        Session session = authorization();
        String s = null;
        try {
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", Constants.EMAIL_ADDRESS, Constants.PASSWORD);

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_WRITE);

            try {
                Message[] messages = inbox.getMessages();
                int i = messages.length - 1;
                s = messages[i].getSubject();

                inbox.close(true);
                store.close();

            } catch (Exception e) {
                return "error";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public static String check() throws InterruptedException {
        for (int i = 0; i < 60; i++) {
            if (GmailInbox.read() != "error") {
                break;
            }
            Thread.sleep(5000);
        }
        return GmailInbox.read();
    }
}