package com.group12.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/** Author: Rachael Klein
*   Student no: 218 057 377
*   Date: 01-07-2020
*   Description: Entity for UserAccount
 */

@Entity
public class UserAccount
{
    @Id
    private String id;
    private String firstName;
    private String surname;
    private String cellPhone;
    private String email;
    private String password;
    private boolean loginStatus;
    private LocalDate registerDate;

    protected UserAccount(){}

    //
    protected UserAccount(Builder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.surname = builder.surname;
        this.cellPhone = builder.cellPhone;
        this.email = builder.email;
        this.password = builder.password;
        this.loginStatus = builder.loginStatus;
        this.registerDate = builder.registerDate;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
       return  "UserAccount{" +
                "id=" + id +
               ", firstName='" + firstName +
               ", surname='" + surname +
               ", cellPhone=" + cellPhone +
                ", email=" + email +
                ", password=" + password +
               ", loginStatus=" + loginStatus +
               ", registerDate=" + registerDate +
                '}';
    }

    //
    public static class Builder {

        private String id;
        private String firstName;
        private String surname;
        private String cellPhone;
        private String email;
        private String password;
        private boolean loginStatus;
        private LocalDate registerDate;


        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setCellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setLoginStatus(boolean loginStatus) {
            this.loginStatus = loginStatus;
            return this;
        }

        public Builder setRegisterDate(LocalDate registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        public Builder copy(UserAccount useraccount)
        {
            this.id = useraccount.id;
            this.firstName = useraccount.firstName;
            this.surname = useraccount.surname;
            this.cellPhone = useraccount.cellPhone;
            this.email = useraccount.email;
            this.password = useraccount.password;
            this.loginStatus = useraccount.loginStatus;
            this.registerDate = useraccount.registerDate;
            return this;
        }

        //
        public UserAccount build(){
            return new UserAccount(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
