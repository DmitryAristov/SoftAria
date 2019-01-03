package SoftAria;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EmailSender {

    private StringBuilder email;

    public boolean Send() {

        Properties properties = new Properties();
        File file = new File("src/main/resources/mail");
        try {
            FileReader reader = new FileReader(file);
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(properties.getProperty("mail.smtps.from")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(properties.getProperty("mail.smtps.to")));
            message.setSubject("SoftAria");
            message.setText(email.toString());

            Transport transport = session.getTransport();
            transport.connect(null, "fromemailpasssword");
            transport.sendMessage(message, message.getAllRecipients());

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public EmailSender(StringBuilder email) {
        this.email = email;
    }
}

