package com.emailanz.emailapi.email;

import java.util.UUID;

// Simplified DTO class to allow updateing emails with any fields.
public class UpdateEmail {
    private String author = "";
    private String subject = "";
    private String[] to = new String[] {""};
    private String body = "";
    private UUID id;

    public UpdateEmail() {}
    
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
    
    public String getSubject()
    {
        return subject;
    }
    
    public String[] getTo()
    {
        return to;
    }
}
