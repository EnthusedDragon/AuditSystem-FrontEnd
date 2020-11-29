package com.group12.service.department.impl;

import com.group12.entity.Department;
import com.group12.repository.department.DepartmentRepository;

import com.group12.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Enver Human - 216174929
 * Desc: Service Implementation for Department
 * Date: 06 September 2020
 */

@Service
public class DepartmentServiceImpl implements DepartmentService
{

   @Autowired
    private DepartmentRepository repository;




    // This method returns a department object using department repository
    @Override
    public Department create(Department department)
    {
        return this.repository.save(department);
    }

    // This method searches for the specified department object using id
    @Override
    public Department read(String id)
    {
        return this.repository.findById(id).orElseGet(null);
    }

    // This method changes and updates specific department object
    @Override
    public Department update(Department departmentUpdate)
    {
        return this.repository.save(departmentUpdate);
    }

    // This method deletes a department object in repository using id
    @Override
    public boolean delete(String entity)
    {
         this.repository.deleteById(entity);
        if (this.repository.existsById(entity)) return  false;
        else return  true;

    }

    // This method retrieves all the department objects in the repository
    @Override
    public Set<Department> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}