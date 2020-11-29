package com.group12.service.faculty;

import com.group12.entity.Faculty;
import com.group12.service.IService;

import java.util.Set;

/**  Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 05-09-2020
 *   Description: An Implementation of Faculty Interface that extends the IService
 */

public interface FacultyService extends IService<Faculty, String> {

    /**
     * Returns all the faculties in the database
     */
    Set<Faculty> getAll();


    /**
     * Returns a faculty with the given name
     * @param name The name of the faculty to return
     * @return Returns a Faculty instance
     */
    Faculty getFacultyByName(String name);


    /**
     * Returns all the faculties that starts with the given string
     * @param start The string that the faculties starts with
     * @return Returns a Set of Faculties
     */
    Set<Faculty> getAllFacultyStartingWith(String start);



}
