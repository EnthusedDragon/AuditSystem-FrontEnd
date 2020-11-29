package com.group12.service.report.impl;

import com.group12.entity.Report;
import com.group12.factory.ReportFactory;
import com.group12.service.report.ReportService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReportServiceImplTest
{
    @Autowired
    private ReportService service;

    private static Report report = ReportFactory.createReport("Brian");

    @Test
    public void a_create()
    {
        Report created = service.create(report);
        assertEquals(report.getReportId(), created.getReportId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read()
    {
        Report read = service.read(report.getReportId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update()
    {
        Report updated = new Report.Builder()
                .copy(report).setReportAuth("Rebecca")
                .build();
        updated = service.update(updated);
        assertEquals("Rebecca", service.read(report.getReportId()).getReportAuth());
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete()
    {
        boolean deleted = service.delete(report.getReportId());
        assertTrue(deleted);
    }

    @Test
    public void d_getAll()
    {
        Set<Report> reports = service.getAll();
        assertEquals(1, reports.size());
        System.out.println("All Logins: " + reports);
    }
}