package com.group12.factory;

import com.group12.entity.Login;
import com.group12.util.GenerateID;

import java.time.LocalDate;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Factory for login
 * Date: 3 July 2020
 */
public class LoginFactory
{
    public static Login createLogin(String emailAddress, String password)
    {
        String loginID = GenerateID.generateID();
        return new Login.Builder()
                .setLoginID(loginID)
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .build();
    }
}
