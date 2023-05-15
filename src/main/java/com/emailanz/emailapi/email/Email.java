package com.emailanz.emailapi.email;

import java.util.UUID;
import java.util.regex.Pattern;

public class Email {
    private UUID id;
    private String subject;
    private String[] to;
    private String author;
    private String body;
    private boolean sent = false;

    public Email(String author, String subject, String to, String body, String id)
    {
        this(author, subject, new String[] {to}, body, id);
    }

    public Email(String author, String subject, String[] to, String body, String id)
    {
        if (id != null && !id.isEmpty())
        {//This only for presentation. Fixed UUID as provided.            
            this.id = UUID.fromString(id);
        }
        else
        {
            this.id = UUID.randomUUID();
        }
        this.author = author;
        this.subject = subject;
        this.body = body;
        if (to.length > 0)
        {
            this.to = new String[to.length];
            int i = 0;
            for (String email : to) {
                if (EmailAddressIsValid(email))
                this.to[i++] = email;
            }
        }
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getBody()
    {
        return body;
    }

    public UUID getId()
    {
        return id;
    }

    public boolean getSent()
    {
        return sent;
    }
    
    public String getSubject()
    {
        return subject;
    }
    
    public String[] getTo()
    {
        return to;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public void setBody(String body)
    {
        this.body = body;
    }
    
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    //Careful with this method - replaces all emails in 'to' with this one.
    public void setTo(String to)
    {
        this.to = new String[]{to};
    }
    public void setTo(String[] to)
    {
        this.to = to;
    }

    public void Send()
    {
        System.out.println("Email sent: " + toString());
        sent = true;
    }

    public static boolean EmailAddressIsValid(String address)
    {
        String emailPattern = "^.+@.+\\..+$";//simple email checker. Ideally checked by input validation on frontend.
        Pattern p = Pattern.compile(emailPattern);
        java.util.regex.Matcher m = p.matcher(address);
        return m.matches();
    }

    @Override
    public String toString()
    {
        String recipients = to[0];
        for (int i = 1; i < to.length; i++)
        {
            recipients += ";" + to[i];
        }
        return "Author: " + author + "; Subject: " + subject + ";\nTo: " + recipients + ";\nBody: " + body;
    }
}
