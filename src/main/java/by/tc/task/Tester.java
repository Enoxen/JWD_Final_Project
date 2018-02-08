package by.tc.task;




import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * Created by Y50-70 on 11.01.2018.
 */
public class Tester {
    private static final String ENCODING = "UTF-8";
    public static void main(String[] args) {
        String subject = "Восстановление пароля";
        String content = "465354";
        String smtpHost="smtp.rambler.ru";
        String from="c.score@rambler.ru";
        String to = "kuzmich798@mail.ru";
        String login="c.score@rambler.ru";
        String password="1522122Rbh";
        String smtpPort="25";
        try {
            sendMessage (login, password, from, to, content, subject, smtpPort, smtpHost);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    public static void sendMessage(String login, String password, String from, String to,
                                   String content, String subject, String smtpPort, String smtpHost) throws MessagingException {
        Authenticator authenticator = new MyAuthenticator(login, password);
        Properties props = System.getProperties();
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.mime.charset",ENCODING);
        Session session = Session.getDefaultInstance(props, authenticator);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setText(content);
        Transport.send(msg);
    }
}










