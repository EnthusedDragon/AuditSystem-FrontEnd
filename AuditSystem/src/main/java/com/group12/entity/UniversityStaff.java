package com.group12.entity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;

/**  Author: Limpho Ranamane
 *   Date: 02-07-2020
 *   Description: UniversityStaff entity using Builder pattern
 */

@Entity
public class UniversityStaff extends  UserAccount {

    protected UniversityStaff(){}

    private UniversityStaff(Builder builder) {
        super(new UserAccount.Builder()
                .setId(builder.id)
                .setFirstName(builder.firstName)
                .setSurname(builder.surname)
                .setEmail(builder.email)
                .setCellPhone(builder.cellPhone)
                .setLoginStatus(builder.loginStatus)
                .setPassword(builder.password)
                .setRegisterDate(builder.registerDate));

        this.department = builder.department;
    }

    @ManyToOne
    private Department department;

    public Department getDepartment() {
        return department;
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
        private Department department;


        public UniversityStaff.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public UniversityStaff.Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UniversityStaff.Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UniversityStaff.Builder setCellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
            return this;
        }

        public UniversityStaff.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UniversityStaff.Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UniversityStaff.Builder setLoginStatus(boolean loginStatus) {
            this.loginStatus = loginStatus;
            return this;
        }

        public UniversityStaff.Builder setRegisterDate(LocalDate registerDate) {
            this.registerDate = registerDate;
            return this;
        }
        public UniversityStaff.Builder setDepartment(Department department) {
            this.department = department;
            return this;
        }

        public UniversityStaff.Builder copy(UniversityStaff universityStaffAccount)
        {
            this.id = universityStaffAccount.getId();
            this.firstName = universityStaffAccount.getFirstName();
            this.surname = universityStaffAccount.getSurname();
            this.cellPhone = universityStaffAccount.getCellPhone();
            this.email = universityStaffAccount.getEmail();
            this.password = universityStaffAccount.getPassword();
            this.loginStatus = universityStaffAccount.isLoginStatus();
            this.registerDate = universityStaffAccount.getRegisterDate();
            this.department = universityStaffAccount.department;
            return this;
        }

        //
        public UniversityStaff build(){
            return new UniversityStaff(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityStaff that = (UniversityStaff) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}



