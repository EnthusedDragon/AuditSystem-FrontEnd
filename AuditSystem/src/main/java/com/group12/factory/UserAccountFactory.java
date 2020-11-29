package com.group12.factory;

import com.group12.entity.UserAccount;
import com.group12.util.GenerateID;
import com.group12.util.Validations;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 21-09-2020
 *   Description: Factory for UserAccountFactory
 */

public class UserAccountFactory {

    // Factory pattern below will be used to create an object in a more secure way,
    // without exposing the logic to our client
    public static UserAccount createUserAccount(String email, String password, boolean loginStatus, LocalDate registerDate, String firstname, String surname, String cellPhone ) throws Exception {

        //generates an randomID for the user, when an account is created
        String userId = GenerateID.generateID();

        //if email textbox is empty, the system will inform the user to fill in an email address
        if(email.isEmpty()){
            System.out.println("Please fill in your email address");
        }

        //checks if email is valid from Validations class, calling isEmailValid method
        if (!Validations.isEmailValid(email))
        {
            throw new Exception("This email is not valid.");
        }

        //if password is empty, user will be prompted to fill in password.
        if(password.isEmpty()){
            System.out.println("Please fill in your password");
            throw new Exception("The password is empty.");
        }

        //checks if password is valid from Validations class, calling isPasswordValid method
        if (!Validations.isPasswordValid(password))
        {
            throw new Exception("This password is not valid.");
        }

        if(registerDate == null)
        {
            registerDate = LocalDate.now();
        }

        // checks if all values are in
        if (firstname.isEmpty() || surname.isEmpty() || cellPhone.isEmpty())
        {
            System.out.println("Please fill in all required information.");
            throw new Exception("Please fill in all required information.");
        }


        // checks that name and surname does not contain numbers
        if (!firstname.matches("[a-zA-Z_]+"))
        {
            System.out.println("Invalid name");
            throw new Exception("Invalid name");
        }

        if (!surname.matches("[a-zA-Z_]+"))
        {
            System.out.println("Invalid surname");
            throw new Exception("Invalid surname");
        }

        // checks if numbers are 10 in length and start with 0
        String numberOfDigits = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(numberOfDigits);
        Matcher matcher = pattern.matcher(cellPhone);

        if (!matcher.matches())
        {
            System.out.println("Please check phone number and fill in again, correctly.");
            throw new Exception("Please check phone number and fill in again, correctly.");
        }

        //sets the user with the values
        UserAccount userAccount = new UserAccount.Builder()
                .setId(userId)
                .setFirstName(firstname)
                .setSurname(surname)
                .setCellPhone(cellPhone)
                .setEmail(email)
                .setPassword(password)
                .setLoginStatus(loginStatus)
                .setRegisterDate(registerDate)
                .build();

        return userAccount;
    }
}
