package com.group12.service.account.impl;

/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 02-09-2020
 *   Description: An Implementation of a general Interface Service
 */

import com.group12.entity.UserAccount;
import com.group12.factory.UserAccountFactory;
import com.group12.service.account.UserAccountService;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.time.LocalDate;
import java.util.Set;

// test case for User Account Service Implementation
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserAccountServiceImplTest {

    static LocalDate date = LocalDate.now();
    //singleton which allows access to the service
    private static UserAccountService service;

    private static UserAccount userAccount;

    // the createUserAccount method expects try & catch in order to handle exceptions thrown
    // due to the above, this is not a test below @Before, it is
    // used for just setting up an User Account for the test to reference.
    @BeforeClass
    public static void setupTests()
    {
        try {
            userAccount = UserAccountFactory.createUserAccount("rachaelk.private@gmail.com",
                    "12345678rR1@!", true, date, "Rachael", "Klein", "0724569871");
        }catch(Exception e)
        {

        }
    }

    String userId = "";

    @After
    public void deleteUser()
    {
        // deletes created users after each test, if the userId was set
        service.delete(userId);
        userId = "";
    }

    //this test will create the account & check if the user account is successfully created
    @Test
    public void a_create() {
        try {
            // creates a userAccount in the repository, service calls it from the Repository
            UserAccount newUserAccount = service.create(userAccount);
            Assert.assertEquals(userAccount.getId(), newUserAccount.getId());
            System.out.println("Created: "+ newUserAccount);

        }catch(Exception e)
            {
            Assert.fail();
            }
    }

    //this test will read the account & check if the user account is successfully read
    @Test
    public void b_read() {
        try {
            Set<UserAccount> userAccounts = service.getAll();
            UserAccount read = service.read(userAccount.getId());
            System.out.println("Read: " + read);
            Assert.assertEquals(userAccount,read);

        }catch(Exception e)
        {
            Assert.fail();
        }

    }

    //this test will updated the email address & check if the user account is successfully updated
    @Test
    public void c_update() {
        try {
            UserAccount updated = new UserAccount.Builder().copy(userAccount).setEmail("RachaelJoubert@gmail.com").build();
            updated = service.update(updated);
            System.out.println("Updated: " + updated);
            Assert.assertEquals("RachaelJoubert@gmail.com",updated.getEmail());
        }catch(Exception e)
        {
            Assert.fail();
        }
    }


    //this test will delete the current account & check if the user account was successfully deleted
    @Test
    public void d_delete() {
        try {
            boolean deleted = service.delete(userAccount.getId());
            System.out.println("Deleted: "+deleted);
            Assert.assertTrue(deleted);
        }catch(Exception e)
        {
            Assert.fail();
        }

    }

    //this test will fail because one account was created initially, worked its way through
    // and then deleted before it reached the getAll method here.
    @Test
    public void e_getAll() {
        Set<UserAccount> userAccounts = service.getAll();
        Assert.assertEquals(0,userAccounts.size());
        System.out.println("All User Accounts: " + userAccounts);
    }

    @Test
    public void f_registerUserAccount_success()
    {
        try {
            // Register a new user
            UserAccount newUser = service.registerUserAccount("rachael@cput.ac.za", "rachael@cput.ac.za", "12345678rR1@!", "12345678rR1@!", "Rachael", "Klein", "0811234455");
            // Ensure that the new user was created with the correct details
            Assert.assertEquals("rachael@cput.ac.za", newUser.getEmail());
            Assert.assertEquals("12345678rR1@!", newUser.getPassword());
            userId = newUser.getId();
        }catch (Exception e)
        {
            Assert.fail();
        }
    }

    @Test
    public void g_registerUserAccount_invalidPassword()
    {
        try {
            // tries to register a new user with an invalid password
            service.registerUserAccount("rachael@cput.ac.za", "rachael@cput.ac.za", "1234", "1234", "Rachael", "Klein", "0815665542");
        }catch (Exception e)
        {
            Assert.assertEquals("This password is not valid.", e.getMessage());
        }
    }

    @Test
    public void h_changePassword_success()
    {
        // setup the test with a new user
        UserAccount user = service.create(userAccount);
        userId = user.getId();

        try {
            // changes the password of the existing user
            boolean success = service.changePassword(userAccount.getPassword(), "21345678rR1@!", "21345678rR1@!", userAccount.getEmail());
            Assert.assertTrue(success);
        }catch(Exception e)
        {
            Assert.fail();
        }
    }

    @Test
    public void i_changePassword_invalidCurrentPassword()
    {
        // setup the test with a new user
        UserAccount user = service.create(userAccount);
        userId = user.getId();

        try {
            // Fails to change the existing password, because the password supplied doesn't match the existing user's password
            service.changePassword("isWrongPassword", "21345678rR1@!", "21345678rR1@!", userAccount.getEmail());
        }catch (Exception e)
        {
            Assert.assertEquals("Incorrect password, user authorization failed.", e.getMessage());
        }
    }

    @Test
    public void j_changePassword_newPasswordDoesNotMatchValidateNewPassword()
    {
        // setup the test with a new user
        UserAccount user = service.create(userAccount);
        userId = user.getId();

        try {
            // Fails to change the password, the NewPassword and ValidateNewPassword doesn't match
            service.changePassword(userAccount.getPassword(), "21345678rR1@!", "31345678rR1@!", userAccount.getEmail());
        }catch (Exception e)
        {
            Assert.assertEquals("Passwords must match.", e.getMessage());
        }
    }

    @Test
    public void k_updateEmailAddress_success()
    {
        // setup the test with a new user
        UserAccount user = service.create(userAccount);
        userId = user.getId();

        try {
            // Updates the existing user's email address
            boolean success = service.updateEmailAddress(userAccount.getEmail(), "rachael@cput.ac.za", "rachael@cput.ac.za", userAccount.getPassword());
            Assert.assertTrue(success);
        }
        catch(Exception e)
        {
            Assert.fail();
        }
    }

    @Test
    public void l_updateEmailAddress_invalidCurrentPassword()
    {
        // setup the test with a new user
        UserAccount user = service.create(userAccount);
        userId = user.getId();

        try {
            // Fails to update the existing user's email address, because password supplied is incorrect
            service.updateEmailAddress(userAccount.getEmail(), "rachael@cput.ac.za", "rachael@cput.ac.za", "isWrongPassword");
        }catch (Exception e)
        {
            Assert.assertEquals("Incorrect password, user authorization failed.", e.getMessage());
        }
    }

    @Test
    public void m_updateEmailAddress_newEmailDoesNotMatchValidateNewEmail()
    {
        // setup the test with a new user
        UserAccount user = service.create(userAccount);
        userId = user.getId();

        try {
            // Fails to update the existing user's email address, because the NewEmail and ValidateNewEmail doesn't match
            service.updateEmailAddress(userAccount.getEmail(), "rachael@cput.ac.za", "rachael@cput.com", userAccount.getPassword());
        }catch (Exception e)
        {
            Assert.assertEquals("Emails must match.", e.getMessage());
        }
    }

    @Test
    public void n_forgotPassword_success()
    {
        // setup the test with a new user
        UserAccount user = service.create(userAccount);
        userId = user.getId();

        try {
            // Forgot password successfully sent "If the email functionality was implemented"
            boolean success = service.forgotPassword(userAccount.getEmail());
            Assert.assertTrue(success);
        }catch (Exception e)
        {
            Assert.fail();
        }
    }

    @Test
    public void n_forgotPassword_noUserFound()
    {
        try {
            // Forgot password fails, because there was no existing user found on the system
            service.forgotPassword(userAccount.getEmail());
        }catch (Exception e)
        {
            Assert.assertEquals("There are no users with email: "+userAccount.getEmail(), e.getMessage());
        }
    }

    @Test
    public void o_getUserAccountViaEmailAddress_success()
    {
        // setup the test with a new user
        UserAccount existingUser = service.create(userAccount);
        userId = existingUser.getId();

        // Successfully searched and returned an existing user via email address
        UserAccount user = service.getUserAccountViaEmailAddress(userAccount.getEmail());
        Assert.assertEquals(userAccount.getEmail(), user.getEmail());
    }

    @Test
    public void p_getUserAccountViaEmailAddress_noUserFound()
    {
        // Failed to find any existing users with the provided email address on the system
        UserAccount user = service.getUserAccountViaEmailAddress(userAccount.getEmail());
        Assert.assertNull(user);
    }

}