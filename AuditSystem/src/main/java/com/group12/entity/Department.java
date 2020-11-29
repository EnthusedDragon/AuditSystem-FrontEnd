package com.group12.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Department {


    @Id
    private String depid;
    private String depName;

    @ManyToOne
    private Faculty faculty;

    protected Department(){}

    private Department(Builder builder) {
        this.depid = builder.depid;
        this.depName = builder.depName;
        this.faculty = builder.faculty;
    }

    public String getDepName() {
        return depName;
    }

    public String getDepid() {
        return depid;
    }

    public Faculty getFaculty(){return faculty;}

    public static class Builder {

        private String depid;
        private String depName;
        private Faculty faculty;




        public Builder setDepid(String depid) {
            this.depid = depid;
            return this;
        }

        public Builder setDepName(String depName) {
            this.depName = depName;
            return this;
        }

        public Builder setFaculty(Faculty faculty) {
            this.faculty = faculty;
            return this;
        }


        public Builder copy(Department department)
        {

            this.depid = department.depid;
            this.depName = department.depName;
            this.faculty = department.faculty;


            return this;

        }


        public Department build()
        {

            return new Department(this);

        }


    }



}