/*package com.group12.repository.department.impl;



import com.group12.entity.Department;
import com.group12.repository.department.DepartmentRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Enver Human - 216174929
 * Desc: Repository Implementation class for department
 * Date: 28 August 2020
 *//*




public class DepartmentRepositoryImpl implements DepartmentRepository {

    public static DepartmentRepository repository = null;
    private Set<Department> departmentDB;

    private DepartmentRepositoryImpl()
    {
        this.departmentDB = new HashSet<>();
    }

    //Returns the repository you want to work on
    public static DepartmentRepository getRepository()
    {
        if (repository == null) repository = new com.group12.repository.department.impl.DepartmentRepositoryImpl();
        return repository;
    }

    //This method creates a Department object it and gets added to the repository
    @Override
    public Department create(Department department)
    {
        this.departmentDB.add(department);
        return department;
    }

    //This method finds by id and deletes department object from repository
    @Override
    public Department read(String id)
    {
        Department department = this.departmentDB.stream().filter(l -> l.getDepid().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
        return department;
    }

    //This method finds a department object ,deletes the old , adds and returns the newly modified one
    @Override
    public Department update(Department department)
    {
        boolean deleteDepartment = delete(department.getDepid());
        if (deleteDepartment)
        {
            this.departmentDB.add(department);
            return department;
        }
        return null;
    }

    //This method finds by id and deletes department object from repository
    @Override
    public boolean delete(String id)
    {
        Department department = read(id);
        if (department != null)
        {
            this.departmentDB.remove(department);
            return true;
        }
        return false;
    }

   // This method returns all department objects from the repository
    @Override
    public Set<Department> getAll()
    {
        return this.departmentDB;
    }
}
*/
