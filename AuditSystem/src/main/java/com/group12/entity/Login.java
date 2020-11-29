package com.group12.entity;

import java.time.LocalDate;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Value object for login
 * Date: 3 July 2020
 */
public class Login
{
    private String loginID;
    private String emailAddress;
    private String password;

    public Login() {
    }

    private Login(Builder builder)
    {
        this.loginID = builder.loginID;
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
    }

    public String getLoginID() {
        return loginID;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginID='" + loginID + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder
    {
        private String loginID;
        private String emailAddress;
        private String password;

        public Builder setLoginID(String loginID)
        {
            this.loginID = loginID;
            return this;
        }

        public Builder setEmailAddress(String emailAddress)
        {
            this.emailAddress = emailAddress;
            return this;
        }
        public Builder setPassword(String password)
        {
            this.password = password;
            return this;
        }

        public Builder copy(Login login)
        {
            this.loginID = login.loginID;
            this.emailAddress = login.emailAddress;
            this.password = login.password;
            return this;
        }

        public Login build()
        {
            return new Login(this);
        }
    }
}
