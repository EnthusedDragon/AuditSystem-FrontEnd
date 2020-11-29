package com.group12.factory;

import com.group12.entity.Report;
import com.group12.util.GenerateDate;
import com.group12.util.GenerateID;

import java.time.LocalDate;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Factory for report
 * Date: 3 July 2020
 */

public class ReportFactory
{
    public static Report createReport(String reportAuth)
    {
        String reportId = GenerateID.generateID();
        LocalDate date = GenerateDate.generateDate();
        return new Report.Builder()
                .setReportId(reportId)
                .setReportAuth(reportAuth)
                .setReportDate(date)
                .build();
    }
}
