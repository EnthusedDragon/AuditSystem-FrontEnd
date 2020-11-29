package com.group12.factory;

import com.group12.entity.Faculty;
import com.group12.entity.UserAccount;
import com.group12.util.GenerateID;
import com.group12.util.Validations;
import java.time.LocalDate;


/** Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 02-07-2020
 *   Description: Factory for Faculty
 */

public class FacultyFactory {

    public static Faculty createFaculty(String facultyName) throws Exception {

        String facultyId = GenerateID.generateID();

        Faculty faculty = new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyName(facultyName)
                .build();

        return faculty;
    }

}
