package com.group12.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

/**  Author: Limpho Ranamane
 *   Date: 02-07-2020
 *   Description: Auditor entity using Builder pattern
 */

//change to class, noted as entity, constructor modified to 'protected', map to make PK--make equals() and hashcode()
@Entity
public class Auditor extends UserAccount{

    protected Auditor() {
    }

    private Auditor(Builder builder) {
        super(new UserAccount.Builder()
                .setId(builder.id)
                .setFirstName(builder.firstName)
                .setSurname(builder.surname)
                .setEmail(builder.email)
                .setCellPhone(builder.cellPhone)
                .setLoginStatus(builder.loginStatus)
                .setPassword(builder.password)
                .setRegisterDate(builder.registerDate));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static class Builder {

        private String id;
        private String firstName;
        private String surname;
        private String cellPhone;
        private String email;
        private String password;
        private boolean loginStatus;
        private LocalDate registerDate;


        public Auditor.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Auditor.Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Auditor.Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Auditor.Builder setCellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
            return this;
        }

        public Auditor.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Auditor.Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Auditor.Builder setLoginStatus(boolean loginStatus) {
            this.loginStatus = loginStatus;
            return this;
        }

        public Auditor.Builder setRegisterDate(LocalDate registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        public Auditor.Builder copy(Auditor auditorAccount)
        {
            this.id = auditorAccount.getId();
            this.firstName = auditorAccount.getFirstName();
            this.surname = auditorAccount.getSurname();
            this.cellPhone = auditorAccount.getCellPhone();
            this.email = auditorAccount.getEmail();
            this.password = auditorAccount.getPassword();
            this.loginStatus = auditorAccount.isLoginStatus();
            this.registerDate = auditorAccount.getRegisterDate();
            return this;
        }

        //
        public Auditor build(){
            return new Auditor(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.group12.entity.Auditor auditor = (com.group12.entity.Auditor) o;
        return getId().equals(auditor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}



