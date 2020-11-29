package com.group12.repository.login.impl;

import com.group12.entity.Login;
import com.group12.repository.login.LoginRepository;

import java.util.HashSet;
import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Repository Implementation for login
 * Date: 24 August 2020
 */
@Deprecated
public class LoginRepositoryImpl implements LoginRepository {

    public static LoginRepository repository = null;
    private Set<Login> loginDB;

    private LoginRepositoryImpl()
    {
        this.loginDB = new HashSet<>();
    }

    public static LoginRepository getRepository()
    {
        if (repository == null) repository = new LoginRepositoryImpl();
        return repository;
    }

    // This method creates and adds a Login object to the repository
    @Override
    public Login create(Login login)
    {
        this.loginDB.add(login);
        return login;
    }

    // This method finds a specific Login object using a unique identifier
    @Override
    public Login read(String id)
    {
        Login login = this.loginDB.stream().filter(l -> l.getLoginID().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
        return login;
    }

    // This method modifies details about a specific Login object
    @Override
    public Login update(Login login)
    {
        boolean deleteLogin = delete(login.getLoginID());
        if (deleteLogin)
        {
            this.loginDB.add(login);
            return login;
        }
        return null;
    }

    // This method deletes a specified Login object
    @Override
    public boolean delete(String id)
    {
        Login login = read(id);
        if (login != null)
        {
            this.loginDB.remove(login);
            return true;
        }
        return false;
    }

    // This method returns all Login objects in the repository
    @Override
    public Set<Login> getAll()
    {
        return this.loginDB;
    }
}

