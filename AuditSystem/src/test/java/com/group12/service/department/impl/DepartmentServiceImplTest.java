package com.group12.service.department.impl;

import  com.group12.entity.Department;
import  com.group12.factory.DepartmentFactory;
import com.group12.service.department.DepartmentService;
import  com.group12.service.department.DepartmentService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


/**
 * @author Enver Human - 216174929
 * Desc: Testing of depmartment service implementation
 * Date: 06 September 2020
 *
 */


import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DepartmentServiceImplTest {

    private static DepartmentService service;
    private static Department department = DepartmentFactory.createDepartment("Multimedia Technology", "1234-1234");

    @Test
    public void a_create()
    {
        Department created = service.create(department);
        assertEquals(department.getDepid(), created.getDepid());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read()
    {
        Department read = service.read(department.getDepid());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update()
    {
        Department updated = new Department.Builder()
                .copy(department).setDepName("Information Technology")
                .build();
        updated = service.update(updated);
        assertEquals("Information Technology", service.read(department.getDepid()).getDepName());
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete()
    {
        boolean deleted = service.delete(department.getDepid());
        assertTrue(deleted);
    }

    @Test
    public void d_getAll()
    {
        Set<Department> departments = service.getAll();
        assertEquals(1, departments.size());
        System.out.println("All Departments " + departments);
    }







}
