package com.group12.repository.login;

import com.group12.entity.Login;
import com.group12.repository.IRepository;

import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Repository Interface for login
 * Date: 24 August 2020
 */
@Deprecated
public interface LoginRepository extends IRepository<Login, String> {
    Set<Login> getAll();
}
