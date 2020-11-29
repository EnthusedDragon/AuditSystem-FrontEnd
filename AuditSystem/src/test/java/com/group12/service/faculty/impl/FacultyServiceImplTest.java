package com.group12.service.faculty.impl;

import com.group12.entity.Faculty;
import com.group12.factory.FacultyFactory;
import com.group12.service.faculty.FacultyService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**  Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 05-09-2020
 *   Description: Tests for the Faculty Service Implementation
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyServiceImplTest{

    @Autowired
    private static FacultyService service;

    // Instances to test with
    private static Faculty engineering = null;
    private static Faculty engineering2 = null;

    private static Faculty accounting = null;
    private static Faculty arts = null;

    @Test
    public void a_testCreate() {
        System.out.println("CREATE");
        try {
            engineering = FacultyFactory.createFaculty("Engineering");
            engineering2 = FacultyFactory.createFaculty("Engineering");

            accounting = FacultyFactory.createFaculty("Accounting");
            arts = FacultyFactory.createFaculty("Arts and Culture");

            service.create(engineering);
            service.create(engineering2);

            service.create(arts);

            Assert.assertEquals(accounting, service.create(accounting) );
        }
        catch (Exception e) {
            Assert.fail();
        }
        System.out.println("");
    }

    @Test
    public void b_testGetAll() {
        System.out.println("GET ALL");
        Set<Faculty> allFaculties = service.getAll();

        for (Faculty fac : allFaculties){
            System.out.println(fac.toString());
        }
        System.out.println("");
    }

    @Test
    public void c_testGetFacultyByName() {
        System.out.println("GET FACULTY BY NAME");

        Faculty engFac = service.getFacultyByName("engineering");
        System.out.println(engFac.toString());
        System.out.println("");

        Assert.assertEquals(engineering, engFac);
    }

    @Test
    public void d_testGetAllFacultyStartingWith() {
        System.out.println("GET ALL FACULTY STARTING WITH");
        Set<Faculty> all = service.getAllFacultyStartingWith("a");

        for(Faculty fac : all){
            System.out.println(fac.toString());
        }
        System.out.println("");
    }


    @Test
    public void e_testRead() {
        System.out.println("READ FACULTY");

        String endID = engineering.getFacultyId();
        Faculty read = service.read(endID);

        System.out.println(read.toString());
        Assert.assertEquals(engineering, read);
        System.out.println("");
    }

    @Test
    public void f_testUpdate() {
        System.out.println("UPDATE");

        Faculty finAccounting = new Faculty
                .Builder()
                .copy(accounting)
                .setFacultyName("Financial Accounting")
                .build();

        System.out.println(finAccounting.toString());
        Assert.assertEquals(finAccounting, service.update(finAccounting));
        System.out.println("");
    }

    @Test
    public void g_testDelete() {
        System.out.println("DELETE");
        String engID = engineering.getFacultyId();

        boolean deleted = service.delete(engID);
        System.out.println("DELETED: " + deleted);

        Assert.assertTrue(deleted);
    }

}