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
            inbox.open(Folder.READ_WRITE);
            msg = inbox.getMessages();

            //need to comment this, otherwise it will not display the emails'content in jsp(checkEmails)

            /*inbox.close(true);
            store.close();*/

            return msg;
        } catch (Exception mex) {
            mex.printStackTrace();
        }
        return msg;
    }

    public Message getEmail(Integer messageNumber){
        Message[] messages=this.readInbox();
        for(Message m:messages){
            if (m.getMessageNumber()==messageNumber){
                return m;

            }
        }
        return null;
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
