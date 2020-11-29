package com.group12.factory;

import com.group12.entity.Report;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Factory test for report
 * Date: 3 July 2020
 */

public class ReportFactoryTest {

    @Test
    public void createReport() {
        Report report = ReportFactory.createReport("Brian Finch");
        Assert.assertNotNull(report.getReportId());
    }

    @Test
    public void reportDate(){
        Report report = ReportFactory.createReport("Brian Finch");
        Assert.assertEquals(java.time.LocalDate.now(), report.getReportDate());
    }

    @Test
    public void reportAuthor() {
        Report report = ReportFactory.createReport("Brian Finch");
        Assert.assertEquals("Brian Finch", report.getReportAuth());
    }
}