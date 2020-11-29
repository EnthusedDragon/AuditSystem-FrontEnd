package com.group12.factory;

import com.group12.entity.Login;
import org.junit.Test;

import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Factory test for Login
 * Date: 3 July 2020
 */
@Deprecated
public class LoginFactoryTest
{

    public static Login login = LoginFactory
            .createLogin("brianfinch@resorbedtwin.com", "forthelulz123");

    @Test
    public void createLogin()
    {
        assertNotNull(login.getLoginID());
    }
}