package com.group12.repository.faculty;

import com.group12.entity.Faculty;
import com.group12.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Ebenezer Mathebula - 217301827
 * Desc: Repository Interface for Faculty Repository
 * Date: July 2020
 */

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {

}
