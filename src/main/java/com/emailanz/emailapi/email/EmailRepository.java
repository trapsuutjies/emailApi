package com.emailanz.emailapi.email;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmailRepository {
    private Set<Email> emails;

    public EmailRepository(){
        this.emails = new HashSet<>();
        var email = new Email("standarduser@anz.com", "Default email", "", null, "0edd99e6-27fb-4e42-a7ee-eff5c33bf17c");
        this.emails.add(email);
    }
    public java.util.List<Email> getEmails(String author)
    {
        return this.emails.stream()
            .filter(email -> email.getAuthor().toLowerCase().contains(author))
            .collect(Collectors.toList());
    }
    public java.util.List<Email> getAllEmails()
    {
        return this.emails.stream()
            .collect(Collectors.toList());
    }
    public Email getEmail(UUID id)
    {
        for (Email email : emails) {
            if (email.getId().equals(id))
                return email;
        }
        return null;
    }
    public Email createEmail(NewEmail newEmail)
    {
        var email = new Email(newEmail.getAuthor(), newEmail.getSubject(), newEmail.getTo(), null, null);
        this.emails.add(email);
        return email;
    }
    public Email sendEmail(UUID id)
    {
        var existingEmail = getEmail(id);
        if (existingEmail != null)
            existingEmail.Send();
        return existingEmail;
    }
    public Email updateEmail(UpdateEmail updateEmail)
    {
        var existingEmail = getEmail(updateEmail.getId());
        if (existingEmail == null)
            return null;

        if (updateEmail.getAuthor() != null && !updateEmail.getAuthor().isBlank())
        {
            if (!updateEmail.getAuthor().equals(existingEmail.getAuthor()))
                existingEmail.setAuthor(updateEmail.getAuthor());
        }
        if (updateEmail.getBody() != null && !updateEmail.getBody().isBlank())
        {
            if (!updateEmail.getBody().equals(existingEmail.getBody()))
                existingEmail.setBody(updateEmail.getBody());
        }
        if (updateEmail.getSubject() != null && !updateEmail.getSubject().isBlank())
        {
            if (!updateEmail.getSubject().equals(existingEmail.getSubject()))
                existingEmail.setSubject(updateEmail.getSubject());
        }
        if (updateEmail.getTo() != null && updateEmail.getTo().length > 0)
        {
            existingEmail.setTo(updateEmail.getTo());
        }
        return existingEmail;
    }
}
