package com.group12.service.account.impl;

/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 02-09-2020
 *   Description: An Implementation of UserAccountServiceImpl class that implements the UserAccountService interface
 */

import com.group12.entity.UserAccount;
import com.group12.factory.UserAccountFactory;
import com.group12.repository.account.UserAccountRepository;
import com.group12.service.account.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.time.LocalDate;
import java.util.stream.Collectors;

// this service will not have access to the database, it will link to my repository
// this service is a layer that gives you access to the repository
// this service class is used to call the operations that i need

//Service - telling Spring framework that this is a service that i am trying to expose
@Service
public class UserAccountServiceImpl implements UserAccountService {


    @Autowired
    private UserAccountRepository repository;


    @Override
    public String login(String email, String password){
        Set<UserAccount> users = getAll();

        for (UserAccount user: users) {
            if(user.getEmail().equals(email))
            {
                if(user.getPassword().equals(password))
                {
                    return  user.getId();
                }else
                {
                    return null;
                }
            }
        }

        return null;
    }

    @Override
    public Set<UserAccount> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


    //Business Logic 1 - I can check if the email address already exist, if so, user account cant be created again.
    @Override
    public UserAccount registerUserAccount(String email, String verifyEmail, String password, String verifyPassword, String firstname, String surname, String cellPhone) throws Exception{
        //ensures that correct email is provided
        if(!email.equals(verifyEmail)){
            throw new Exception("Email Addresses must match.");
        }
        // ensure correct password is provided
        if(!password.equals(verifyPassword)){
            throw new Exception("Passwords must match.");
        }
        try{
            UserAccount existingUser = getUserAccountViaEmailAddress(email);

            if(existingUser != null)
            {
                throw new Exception("A user with this email address already exists.");
            }

            UserAccount newUser = UserAccountFactory.createUserAccount(email,
                    password, false, LocalDate.now(), firstname, surname, cellPhone);
           return create(newUser);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    //Business Logic 2 -  change password, should be allowed for a password to be changed.
    @Override
    public boolean changePassword(String existingPassword, String newPassword, String verifyNewPassword, String emailAddress) throws Exception {
        // Ensure that new password provided is correct
        if(!newPassword.equals(verifyNewPassword))
        {
            throw new Exception("Passwords must match.");
        }

        // fetch the existing user via email address
        UserAccount user = getUserAccountViaEmailAddress(emailAddress);

        // Ensure that the existing password matches the user's current password, to allow password change
        if(!user.getPassword().equals(existingPassword))
        {
            throw new Exception("Incorrect password, user authorization failed.");
        }

        // update the user entity with the new password
        user = new UserAccount.Builder()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setLoginStatus(user.isLoginStatus())
                .setRegisterDate(user.getRegisterDate())
                .setPassword(newPassword)
                .build();

        // update the user in the database
        UserAccount updatedUser = update(user);

        // ensure that the new password was set
        if(!updatedUser.getPassword().equals(newPassword))
        {
            throw new Exception("Change password failed.");
        }

        return true;
    }

    //Business Logic 3 - update email address to new email address.
    @Override
    public boolean updateEmailAddress(String emailAddress,String newEmailAddress, String verifyNewEmailAddress, String password) throws Exception {
        // Ensure that new email address provided is correct
        if(!newEmailAddress.equals(verifyNewEmailAddress))
        {
            throw new Exception("Emails must match.");
        }

        // fetch the existing user via email address
        UserAccount user = getUserAccountViaEmailAddress(emailAddress);

        // Ensure that the password matches the user's current password, to allow email address change
        if(!user.getPassword().equals(password))
        {
            throw new Exception("Incorrect password, user authorization failed.");
        }

        // update the user entity with the new email address
        user = new UserAccount.Builder()
                .setId(user.getId())
                .setEmail(newEmailAddress)
                .setLoginStatus(user.isLoginStatus())
                .setRegisterDate(user.getRegisterDate())
                .setPassword(user.getPassword())
                .build();

        // update the user in the database
        UserAccount updatedUser = update(user);

        // ensure that the new email address was set
        if(!updatedUser.getEmail().equals(newEmailAddress))
        {
            throw new Exception("Update email address failed.");
        }

        return true;
    }

    //Business Logic 4 - forgot password, account reset to new password
    @Override
    public boolean forgotPassword(String emailAddress) throws Exception{
        UserAccount user = getUserAccountViaEmailAddress(emailAddress);

        if(user == null)
        {
            throw new Exception("There are no users with email: " + emailAddress);
        }

        // This method should send the user a email that will contain his password

        return true;
    }

    //Business Logic 5 - gets UserAccount via email address
    @Override
    public UserAccount getUserAccountViaEmailAddress(String email) {
       Set<UserAccount> users = getAll();
       //search for a user with the requested email address
        // and then return that user
        for (UserAccount user: users) {
            if(user.getEmail().equals(email))
            {
                return user;
            }
        }

        return null;
    }


    //CRUD methods
    @Override
    public UserAccount create(UserAccount userAccount) {
        return this.repository.save(userAccount);
    }

    @Override
    public UserAccount read(String id) {
        return this.repository.findById(id).orElseGet(null);
    }

    @Override
    public UserAccount update(UserAccount userAccountUpdate) {
        return this.repository.save(userAccountUpdate);
    }

    @Override
    public boolean delete(String entity) {
        this.repository.deleteById(entity);
        if (this.repository.existsById(entity)) return  false;
            else return  true;

    }


}
