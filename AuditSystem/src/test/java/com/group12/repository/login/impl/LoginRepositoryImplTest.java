/*
package com.group12.repository.login.impl;

import com.group12.entity.Login;
import com.group12.factory.LoginFactory;
import com.group12.repository.login.LoginRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
*/
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Repository Implementation Test for login
 * Date: 24 August 2020
 *//*

@Deprecated
public class LoginRepositoryImplTest
{

    private static LoginRepository repository = LoginRepositoryImpl.getRepository();
    private static Login login = LoginFactory
            .createLogin("brianfinch@resorbedtwin.com", "forthelulz12345");

    @Test
    public void a_create()
    {
        Login created = repository.create(login);
        assertEquals(login.getLoginID(), created.getLoginID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read()
    {
        Login read = repository.read(login.getLoginID());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update()
    {
        Login updated = new Login.Builder()
                .copy(login).setPassword("forthesmarties12345")
                .build();
        updated = repository.update(updated);
        assertEquals(updated.getPassword(), repository.read(login.getLoginID()).getPassword());
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete()
    {
        boolean deleted = repository.delete(login.getLoginID());
        assertTrue(deleted);
    }

    @Test
    public void d_getAll()
    {
        System.out.println("All: " + repository.getAll());
        assertEquals(1, repository.getAll().size());
    }
}*/
