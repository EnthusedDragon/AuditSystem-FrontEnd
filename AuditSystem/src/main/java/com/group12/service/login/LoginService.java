package com.group12.service.login;

import com.group12.entity.Login;
import com.group12.entity.UserAccount;
import com.group12.service.IService;

import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Service Interface for login
 * Date: 28 August 2020
 */
@Deprecated
public interface LoginService extends IService<Login, String>
{
    Set<Login> getAll();
}
