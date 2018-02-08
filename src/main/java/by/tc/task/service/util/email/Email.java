package by.tc.task.service.util.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Y50-70 on 08.02.2018.
 */
public class Email {
    private static Authenticator authenticator = new EmailAuthenticator(EmailConst.LOGIN, EmailConst.PASSWORD);
    private static Properties props = System.getProperties();
    static {
        props.put(EmailConst.SMTP_PROP_PORT, EmailConst.SMTP_PORT);
        props.put(EmailConst.SMTP_PROP_HOST, EmailConst.SMTP_HOST);
        props.put(EmailConst.SMTP_PROP_AUTH, EmailConst.AUTH_TRUE);
        props.put(EmailConst.SMTP_PROP_CHARSET, EmailConst.ENCODING);
    }
    public static void sendEmail(String email, String code){
        try {
            Session session = Session.getDefaultInstance(props, authenticator);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(EmailConst.FROM));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            msg.setSubject(EmailConst.SUBJECT);
            msg.setText(code);
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
