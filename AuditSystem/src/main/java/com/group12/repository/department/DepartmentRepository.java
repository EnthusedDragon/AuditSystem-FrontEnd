package com.group12.repository.department;

import com.group12.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Enver Human - 216174929
 * Desc: Repository Interface for department
 * Date: 28 August 2020
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {


}
