# email API

This is a showcase REST API without a mail server.
When instantiated, one dummy email is created so that Get All can show a result.
To list all emails by user, call /emails with the email address of the author. This is equivalent to a user's inbox.

To create a new draft email, use the Post endpoint. The required fields are Author, Subject, and To. The to field can be either a single email address, or an array of email addresses.
When you create a draft email, you receive the entire email object as a result - use the ID to modify or send the email.

To modify a draft email, use the ID and provide the fields you wish to update. All fields (except the ID) are optional. You can update the Author, Subject, To, or Body.
If no email exists with that ID, you will receive error 204 (No Content).

To send a draft email, use the ID. The email details will be written to the console.
