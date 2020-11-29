//package com.group12.repository.report.impl;
//
//import com.group12.entity.Report;
//import com.group12.repository.report.ReportRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
///**
// * @author Bradley van der Westhuizen - 217218903
// * Desc: Repository Implementation for report
// * Date: 24 August 2020
// */
//@Deprecated
//public class ReportRepositoryImpl implements ReportRepository
//{
//
//    public static ReportRepository repository = null;
//    private Set<Report> reportDB;
//
//    private ReportRepositoryImpl()
//    {
//        this.reportDB = new HashSet<>();
//    }
//
//    public static ReportRepository getRepository()
//    {
//        if (repository == null) repository = new ReportRepositoryImpl();
//        return repository;
//    }
//
//    // This method creates and adds a Report object to the repository
//    @Override
//    public Report create(Report report)
//    {
//        this.reportDB.add(report);
//        return report;
//    }
//
//    // This method finds a specific Report using a unique identifier
//    @Override
//    public Report read(String id)
//    {
//        Report report = this.reportDB.stream()
//                .filter(r -> r.getReportId().trim().equalsIgnoreCase(id))
//                .findAny()
//                .orElse(null);
//        return report;
//    }
//
//    // This method modifies details about a specific Report
//    @Override
//    public Report update(Report report)
//    {
//        Boolean deleteReport = delete(report.getReportId());
//        if (deleteReport)
//        {
//            this.reportDB.add(report);
//            return report;
//        }
//        return null;
//    }
//
//    // This method deletes a specified Report
//    @Override
//    public boolean delete(String id)
//    {
//        Report report = read(id);
//        if (report != null)
//        {
//            this.reportDB.remove(report);
//            return true;
//        }
//        return false;
//    }
//
//    // This method returns all Reports in the repository
//    @Override
//    public Set<Report> getAll()
//    {
//        return this.reportDB;
//    }
//}
