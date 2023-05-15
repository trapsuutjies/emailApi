package com.emailanz.emailapi.email;

// Simplified DTO class to allow creating objects with limited fields.
public class NewEmail {
    private String author;
    private String subject;
    private String[] to;

    public NewEmail() {}

    public NewEmail(String author, String subject, String to)
    {
        this(author, subject, new String[] {to});
    }

    public NewEmail(String author, String subject, String[] to)
    {
        this.author = author;
        this.subject = subject;
        int i = 0;
        for (String email : to) {
            if (Email.EmailAddressIsValid(email))
            this.to[i++] = email;
        }
    }
    
    public String getAuthor()
    {
        return author;
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
