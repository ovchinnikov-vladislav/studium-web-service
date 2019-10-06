package ru.kamchatgtu.studium.engine;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Объект класса {@code EmailSender} реализует отправку сообщения на электронную почту через gmail.com
 * @author Овчинников В.А.
 */
public class EmailSender {

    private String userName;
    private String password;
    private Properties properties;

    /**
     * Конструктор для создания объекта {@code EmailSender}
     * @param userName имя пользователя (email) от аккаунта gmail.com
     * @param password пароль от аккаунта gmail.com
     */
    public EmailSender(String userName, String password) {
        this.userName = userName;
        this.password = password;

        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }

    /**
     * Метод отправки сообщения
     * @param subject тема сообщения
     * @param text текст сообщения
     * @param toEmail e-mail, куда надо отправить сообщения
     */
    public void send(String subject, String text, String toEmail) {
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException exc) {
            exc.printStackTrace();
        }
    }

    public void send(String subject, Multipart text, String toEmail) {
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setContent(text);
            Transport.send(message);
        } catch (MessagingException exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String... args) {
        EmailSender email = new EmailSender("testaccaunt170797@gmail.com", "1f12kjghqlfdkj");
        MimeMultipart multipart = new MimeMultipart("related");

// HTML-текст
        try {
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<image src=\"cid:image\">"; // См. ниже.
            messageBodyPart.setContent(htmlText, "text/html");
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("D:/Projects/IntelliJProjects/StudiumWebService/src/main/java/ru/kamchatgtu/studium/engine/putin.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds));
// Строчка необходима для возможности сослаться на изображение в HTML. См. выше.
// Если ссылаться на картинку нет необходимости, строчку можно убрать.
            messageBodyPart.setHeader("Content-ID", "image");
            multipart.addBodyPart(messageBodyPart);

        } catch (MessagingException exc) {
            exc.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            email.send("Срочная новость", multipart, "lovanillalaaa@gmail.com");
        }
    }
}
