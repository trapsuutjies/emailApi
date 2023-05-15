package com.emailanz.emailapi.email;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class EmailController {
    EmailRepository repo = new EmailRepository();//Replace with DI object.
    
    @GetMapping(value = "/emails")
    public ResponseEntity<List<Email>> getEmails(String author) {
        if (author == null || author.isEmpty())
            return new ResponseEntity<>(repo.getAllEmails(), HttpStatus.OK);
        else
            return new ResponseEntity<>(repo.getEmails(author), HttpStatus.OK);
    }
    @GetMapping(value = "/email")
    public ResponseEntity<Email> getEmail(@RequestParam UUID id) {
        var email = repo.getEmail(id);
        if (email == null)
            return new ResponseEntity<>(email, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(repo.getEmail(id), HttpStatus.OK);
    }

    @PostMapping(value = "/email")
    public ResponseEntity<Email> createEmail(@RequestBody NewEmail newEmail)
    {
        return new ResponseEntity<Email>(repo.createEmail(newEmail), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/email")
    public ResponseEntity<Email> updateEmail(@RequestBody UpdateEmail updateEmail)
    {
        var updatedEmail = repo.updateEmail(updateEmail);
        return new ResponseEntity<Email>(updatedEmail, updatedEmail == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @PutMapping(value = "/email")
    public ResponseEntity<Email> sendEmail(@RequestParam UUID id) {
        var sentEmail = repo.sendEmail(id);
        return new ResponseEntity<Email>(sentEmail, sentEmail == null ? HttpStatus.NOT_MODIFIED : HttpStatus.OK);
    }
}
