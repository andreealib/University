/*
package com.Universities.web.services;

import org.apache.tools.ant.BuildException;


import org.apache.tools.ant.taskdefs.email.Mailer;
import org.apache.tools.ant.taskdefs.email.Message;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

*/
/**
 * Created by andreealibotean on 12/4/2015.
 *//*

@Service
public class ContactService {

    final private String to = "andreea.libotean31@gmail.com";
    private String from;
    private String username;
    private String password;

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String host = "smtp.gmail.com";
    Properties properties = new Properties();

    public void send(String to, String from, String username, final String password) {
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        javax.mail.Session mailSession = javax.mail.Session.getInstance
                (properties,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        }
                );


        try {
            Message message = new MimeMessage();
        }
    }

            */
/*<property name="host" value="smtp.gmail.com" />
    <property name="port" value="587" />
    <property name="username" value="andreea.libotean31@gmail.com" />
    <property name="password" value="@ndr33@10@ndr33@" />*//*

}
*/
