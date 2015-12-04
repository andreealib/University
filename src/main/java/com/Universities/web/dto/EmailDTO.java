package com.Universities.web.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.mail.MailSender;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by andreealibotean on 12/3/2015.
 */
public class EmailDTO implements Serializable {

    @NotBlank(message = "Cannot be empty.")
    @Email(message = "Not a valid email address.")
    private String email;

    @NotBlank(message = "Cannot be empty.")
    @Size(max = 40,message = "Subject is too long.")
    private String subject;

    @NotBlank(message = "Cannot be empty.")
    private String text;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
