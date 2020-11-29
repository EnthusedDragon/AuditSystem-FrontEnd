package com.group12.controller.login;

import com.group12.entity.Login;
import com.group12.entity.UserAccount;
import com.group12.factory.LoginFactory;
import com.group12.service.account.impl.UserAccountServiceImpl;
import com.group12.service.login.LoginService;
import com.group12.service.login.impl.LoginServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Controller for login
 * Date: 22 September 2020
 */
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController
{
    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private UserAccountServiceImpl userAccountService;

    @PostMapping("/create")
    public Login create(@RequestBody Login login)
    {
       return loginService.create(login);
    }

    @GetMapping("/read/{id}")
    public Login read(@PathVariable String id)
    {
        return loginService.read(id);
    }

    @PostMapping("/update")
    public Login update(@RequestBody Login login)
    {
        return loginService.update(login);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return loginService.delete(id);
    }

    @GetMapping("/all")
    public Set<Login> getAll()
    {
        return loginService.getAll();
    }
}
