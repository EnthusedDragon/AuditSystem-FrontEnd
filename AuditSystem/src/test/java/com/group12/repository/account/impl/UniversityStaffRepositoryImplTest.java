//package com.group12.repository.account.impl;
///**  Author: Limpho Ranamane
// *   Date: 26-08-2020
// *   Description: Accessing UniversityStaff Repository using TDD
// */
//import com.group12.entity.UniversityStaff;
//import com.group12.factory.UniversityStaffFactory;
//import com.group12.repository.account.UniversityStaffRepository;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) // sorts method in ascending form
//public class UniversityStaffRepositoryImplTest {
//
//    private static UniversityStaffRepository universityStaffRepoDB = UniversityStaffRepositoryImpl.getUniversityStaffRepository();
//    private static UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff("Masi", "Tshabalala", "0814569823");// passes values as per sequence in the UniversityStaffFactory
//
//    //the following methods implements manipulation to the DB (universityStaffRepoDB) by adding, reading, updating, getting all that's in the database and deleting the value/s added
//    @Test
//    public void a_create() {
//        UniversityStaff created = universityStaffRepoDB.create(universityStaff);
//        assertEquals(universityStaff.getUniversityStaffID(), created.getUniversityStaffID());
//        System.out.println("Expected: " + universityStaff.getUniversityStaffID()+ " Actual: " + universityStaff.getUniversityStaffID() + "Created Auditor: "+ created);
//
//    }
//
//    @Test
//    public void b_read() {
//        UniversityStaff reading = universityStaffRepoDB.read(universityStaff.getUniversityStaffID());
//        assertEquals(universityStaff, reading);
//        System.out.println("Read " + reading);
//    }
//
//    @Test
//    public void c_update() {
//        UniversityStaff updated = new UniversityStaff.Builder().copy(universityStaff).setUniversityStaffFirstName("Azuri").build();
//        updated = universityStaffRepoDB.update(updated);
//        assertEquals(universityStaff.getUniversityStaffID(), updated.getUniversityStaffID());
//        assertNotEquals(universityStaff.getUniversityStaffFirstName(),updated.getUniversityStaffFirstName());
//        System.out.println("Updated to: " + updated);
//    }
//
//    @Test
//    public void e_delete() {
//        boolean removed =  universityStaffRepoDB.delete(universityStaff.getUniversityStaffID());
//        assertTrue(removed);
//    }
//
//
//    @Test
//    public void d_getAll() {
//        Set<UniversityStaff> universityStaffs = universityStaffRepoDB.getAll();
//        assertEquals(1,universityStaffs.size());
//        System.out.println("Returned results " + universityStaffRepoDB.getAll());
//    }
//}