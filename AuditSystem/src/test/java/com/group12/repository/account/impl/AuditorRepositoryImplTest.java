//package com.group12.repository.account.impl;
///**  Author: Limpho Ranamane
// *   Date: 25-08-2020
// *   Description: Accessing Auditor Repository using TDD
// */
//import com.group12.entity.Auditor;
//import com.group12.factory.AuditorFactory;
//import com.group12.repository.account.AuditorRepository;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) //fixes methods to run in a sequence
//public class AuditorRepositoryImplTest {
//
//    private static AuditorRepository auditorRepoDB = AuditorRepositoryImpl.getAuditorRepository();
//    private static Auditor auditor = AuditorFactory.createAuditor("Jacob", "Liebenberg", "0674568902"); // passes values as per sequence in the AuditorFactory
//
//    //the following methods implements manipulation to the DB (auditorRepoDB) by adding, reading, updating, getting all that's in the database and deleting the value/s added
//    @Test
//    public void a_create() {
//        Auditor created = auditorRepoDB.create(auditor);
//        assertEquals(auditor.getAuditorID(), created.getAuditorID());
//        System.out.println("Expected: " + auditor.getAuditorID()+ " Actual: " + created.getAuditorID() + "Created Auditor: "+ created);
//    }
//
//    @Test
//    public void b_read() {
//        Auditor reading = auditorRepoDB.read(auditor.getAuditorID());
//        assertEquals(auditor, reading);
//        System.out.println("Read " + reading);
//    }
//
//    @Test
//    public void c_update() {
//        Auditor updated = new Auditor.Builder().copy(auditor).setAuditorFirstName("Phora").build();
//        updated = auditorRepoDB.update(updated);
//        assertEquals(auditor.getAuditorID(), updated.getAuditorID());
//        assertNotEquals(auditor.getAuditorFirstName(),updated.getAuditorFirstName());
//        System.out.println("Updated to: " + updated);
//    }
//
//    @Test
//    public void e_delete() {
//        boolean removed =  auditorRepoDB.delete(auditor.getAuditorID());
//        assertTrue(removed);
//    }
//
//    @Test
//    public void d_getAll() {
//        Set<Auditor> auditors = auditorRepoDB.getAll();
//        assertEquals(1,auditors.size());
//        System.out.println("Returned results " + auditorRepoDB.getAll());
//    }
//}