package com.Universities.web.services;

/**
 * Created by andreealibotean on 12/7/2015.
 */

import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.search.FlagTerm;

@Service

public class ReadingInboxService {

    public Message[] readInbox() {

        Message[] msg = null;
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "testingmandarine@gmail.com", "mandarine");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            msg = inbox.getMessages();
            for (int i = 0, n = msg.length; i < n; i++) {
                Message message = msg[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + message.getMessageNumber());
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());


            }
            //need to comment this, otherwise it wil not display the emails'content in jsp(checkEmails)
            /*inbox.close(false);
            store.close();*/
            return msg;
        } catch (Exception mex) {
            mex.printStackTrace();
        }
        return msg;
    }

   public String userEmail(String emailBody){
       String[] lines=emailBody.split("\r\n");
       String userEmail=lines[0];
       return userEmail;
   }

    //removes the standard first-line containing the sender's address
    public String getContentWithoutEmail(String content){
       String cleanContent=content.substring(content.indexOf("\r\n")+1);
        return cleanContent;
    }

}
