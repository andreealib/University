package com.Universities.web.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by andreealibotean on 12/4/2015.
 */
public class ContactDTO {

    @NotBlank(message = "Cannot be empty.")
    @Email(message = "Not a valid email address.")
    private String from;

    @NotBlank(message = "Cannot be empty.")
    @Size(max = 40,message = "Subject is too long.")
    private String subject;

    @NotBlank(message = "Cannot be empty.")
    private String message;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
