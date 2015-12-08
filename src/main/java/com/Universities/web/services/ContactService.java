
package com.Universities.web.services;

import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


@Service
public class ContactService {


    public void sendContactEmail(String from, String subject, String message) {

        final String to = "testingmandarine@gmail.com";
        String host = "smtp.gmail.com";

        Properties props = new Properties();

        props.put("mail.smtp.host", host);
        props.put("mail.debug", "true");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth","true");


        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(to, "mandarine");
            }
        };


        Session session = Session.getInstance(props,auth);

        try {

            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());

            msg.setText(from+ "\r\n"+message);

            Transport.send(msg);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
