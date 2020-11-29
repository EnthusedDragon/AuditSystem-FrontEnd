package com.group12.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/** Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 02-07-2020
 *   Description: Entity for Faculty, using Builder pattern
 */


@Entity
public class Faculty {

    @Id
    private String facultyId;
    private String facultyName;

    protected Faculty() {}

    private Faculty(Builder builder){
        this.facultyId = builder.facultyId;
        this.facultyName = builder.facultyName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId='" + facultyId + '\'' +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }

    // Inner Class
    public static class Builder {

        private String facultyId;
        private String facultyName;

        public Builder setFacultyId(String facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder copy(Faculty faculty) {
            this.facultyId = faculty.facultyId;
            this.facultyName = faculty.facultyName;
            return this;
        }

        public Faculty build(){
            return new Faculty(this);
        }

    }       // end inner class


}       // end class