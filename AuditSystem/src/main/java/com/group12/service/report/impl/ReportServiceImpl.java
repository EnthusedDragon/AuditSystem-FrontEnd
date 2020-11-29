package com.group12.service.report.impl;

import com.group12.entity.Report;
import com.group12.repository.report.ReportRepository;
import com.group12.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Service Implementation for report
 * Date: 28 August 2020
 */

@Service
public class ReportServiceImpl implements ReportService
{

    @Autowired
    private ReportRepository repository;

    // This method calls the create method in the ReportRepository class and adds a new report object
    @Override
    public Report create(Report report)
    {
        return this.repository.save(report);
    }

    // This method calls the read method in the ReportRepository class and searches for the specified report
    @Override
    public Report read(String id)
    {
        return this.repository.findById(id).orElse(null);
    }

    // This method calls the update method in the ReportRepository class and changes the details of the specified report
    @Override
    public Report update(Report report)
    {
        return create(report);
    }

    // This method calls the delete method in the ReportRepository class and deletes the specified report object
    @Override
    public boolean delete(String id)
    {
        this.repository.deleteById(id);
        if (this.repository.existsById(id))
            return false;
        else
            return true;
    }

    // This method retrieves all the report objects in the repository
    @Override
    public Set<Report> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
