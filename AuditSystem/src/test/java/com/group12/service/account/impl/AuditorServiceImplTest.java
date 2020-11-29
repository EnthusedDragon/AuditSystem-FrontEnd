package com.group12.service.account.impl;

import com.group12.entity.Auditor;
import com.group12.factory.AuditorFactory;
import com.group12.service.account.AuditorService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;
/**  Author: Limpho Ranamane
 *   Date: 25-08-2020
 *   Description: Accessing Auditor Repository using TDD for AuditorService
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//fixes methods to run in a sequence
public class AuditorServiceImplTest {

    @Autowired
    private static AuditorService auditorService;
    private static Auditor auditor = AuditorFactory.createAuditor("Lungz@gmail.com", "P@ssword123", false, LocalDate.now(), "Lungz", "Kwana", "0656708902"); // passes values as per sequence in the AuditorFactory

    //the following methods are CRUD methods which all communicate with the repository which in tern communicates with the DB
    @Test
    public void a_create() {
        Auditor created = auditorService.create(auditor);
        assertEquals(auditor.getId(), created.getId());
        System.out.println("Expected: " + auditor.getId()+ " Actual: " + created.getId() + "Created Auditor: "+ created);
    }

    @Test
    public void b_read() {
        Auditor reading = auditorService.read(auditor.getId());
        assertEquals(auditor, reading);
        System.out.println("Read " + reading);
    }

    @Test
    public void c_update() {
        Auditor updated = new Auditor.Builder().copy(auditor).setFirstName("Kun").build();
        updated = auditorService.update(updated);
        assertEquals(auditor.getId(), updated.getId());
        assertNotEquals(auditor.getFirstName(),updated.getFirstName());
        System.out.println("Updated to: " + updated);
    }

    @Test
    public void e_delete() {
        boolean removed =  auditorService.delete(auditor.getId());
        assertTrue(removed);
    }

    @Test
    public void d_getAll() {
        Set<Auditor> auditors = auditorService.getAll();
        assertEquals(1,auditors.size());
        System.out.println("Returned results " + auditorService.getAll());
    }
}