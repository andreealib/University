package com.Universities.web.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by andreealibotean on 12/7/2015.
 */
public class ReplyDTO implements Serializable{
    @NotBlank(message = "Cannot be empty.")
    @Size(max = 40,message = "Subject is too long.")
    private String subject;

    @NotBlank(message = "Cannot be empty.")
    private String text;

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
