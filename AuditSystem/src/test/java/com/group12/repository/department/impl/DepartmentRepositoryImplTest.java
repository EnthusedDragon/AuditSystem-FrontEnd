/*
package com.group12.repository.department.impl;

import com.group12.factory.DepartmentFactory;

import com.group12.repository.department.DepartmentRepository;


import com.group12.entity.Department;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

*/
/**
 * @author Enver Human - 216174929
 * Desc: Repository Implementation Test for Department
 * Date: 28 August 2020
 *//*


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DepartmentRepositoryImplTest {


    private static DepartmentRepository repository = DepartmentRepositoryImpl.getRepository();
    private static Department department = DepartmentFactory.createDepartment("Phinancial Aid");

    
    
    //Tests object creation in the repository
    @Test
    public void a_create()
    {

        Department created = repository.create(department);
        assertEquals(department.getDepid(), created.getDepid());
        System.out.println("Created: " + created);


    }
    
    
    //Test displays specific deparment object after being found
    @Test
    public  void b_read()
    {

        Department read = repository.read(department.getDepid());

        System.out.println("Read: " + read);
    }
    
    
    //Test checks to if department name has been changed.
    @Test
    public void c_update()
    {
        Department updated = new Department.Builder().copy(department).setDepName("Financial Aid")
                .build();
        updated = repository.update(updated);
        assertEquals(updated.getDepName(), repository.read(department.getDepid()).getDepName());

        System.out.println(" Updated " + updated );



    }
    

    //Test checks to see if departement has been deleted from the repository
    @Test
    public  void e_delete()
    {
        boolean deleted = repository.delete(department.getDepid());

        assertTrue(deleted);
    }
    
    
    //Test checks to see if all departments in the repository has actually been returned
    @Test
    public void d_getAll()
    {

        System.out.println("All Departments:" + department.getDepid());
    }


}
*/
