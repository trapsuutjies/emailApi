package com.emailanz.emailapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.boot.test.context.SpringBootTest;

import com.emailanz.emailapi.email.Email;
import com.emailanz.emailapi.email.EmailRepository;

@SpringBootTest
class EmailapiApplicationTests {

	@Test
	void contextLoads() {
	}
    @Test
    public void TestValidEmail()
    {
        //Arrange
        //Act
        var valid = Email.EmailAddressIsValid("standarduser@anz.com");
        //Assert
		assertTrue(valid);
    }
    @Test
    public void TestInvalidEmail()
    {
        //Arrange
        //Act
        var valid = Email.EmailAddressIsValid("standarduser@anz@com");
        //Assert
		assertFalse(valid);
    }
    @Test
    public void NewEmailRepoShouldHaveOneEntry()
    {//Note this test is only for current demo setup and likely to change.
        //Arrange
		EmailRepository repo = new EmailRepository();
        //Act
        var size = repo.getAllEmails().size();
        //Assert
		assertEquals(1, size);
    }
}
