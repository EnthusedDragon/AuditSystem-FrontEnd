package com.group12.factory;

import com.group12.entity.Department;
import com.group12.entity.Department.Builder;
import com.group12.entity.Faculty;
import com.group12.util.GenerateID;

public class DepartmentFactory {


    public static Department createDepartment(String depName, String facultyId )
    {
        String depId = GenerateID.generateID();

        Department department = new Department.Builder()
                .setDepid(depId)
                .setDepName(depName)
                .setFaculty(new Faculty.Builder().setFacultyId(facultyId).build())
                .build();

        return  department;




    }






    }



