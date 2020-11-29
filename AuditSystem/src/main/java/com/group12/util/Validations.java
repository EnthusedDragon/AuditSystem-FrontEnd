package com.group12.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**  Author: Rachael Klein
 *   Created methods: isPasswordValid and isEmailValid
 *   Student no: 218 057 377
 *   Date: 01-07-2020
 *   Description: auto generateID
 */

public class Validations {

    // Checking is password is valid : created by Rachael Klein 218 057 377,
    // method can be through to Login Entity and UserAccount Entity
    // to check if password filled in by user is valid
    public static boolean isPasswordValid(String password)
    {
        // password can take: At least 8 characters long, One lowercase, one uppercase, one
        // number and one special character, No whitespaces.
        String passwordValidation = "^(?=.*[\\w])(?=.*[\\W])[\\w\\W]{8,}$";
        Pattern pat = Pattern.compile(passwordValidation);
        Matcher mat = pat.matcher(password);

        if (!mat.matches()){
            System.out.println("please type in a valid password");
            return false;
        }
        return true;
    }


    // Checking is email is valid : created by Rachael Klein 218 057 377,
    // method can be through to Login Entity and UserAccount Entity
    // to check if password filled in by user is valid
    public static boolean isEmailValid(String email)
    {
        //Validation: This checks if the email address is valid.
        //domain name must include at least 1 dot, domain name after the last dot can only consist of letters.
        String emailValidation = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailValidation);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches())
        {
            System.out.println("please type in a valid email");
            return false;
        }
        return true;
    }




}
