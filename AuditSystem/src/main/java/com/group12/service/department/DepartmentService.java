package com.group12.service.department;

import com.group12.entity.Department;

import com.group12.service.IService;

import java.util.Set;
/**
 * @author Enver Human - 216174929
 * Desc: Service Implementation for department
 * Date: 06 September 2020
 */
public interface DepartmentService extends IService<Department, String>
{
    Set<Department> getAll();
}