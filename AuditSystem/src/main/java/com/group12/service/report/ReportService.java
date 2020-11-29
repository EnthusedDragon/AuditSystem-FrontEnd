package com.group12.service.report;

import com.group12.entity.Report;
import com.group12.service.IService;

import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Service Implementation for report
 * Date: 28 August 2020
 */
public interface ReportService extends IService<Report, String>
{
    Set<Report> getAll();
}
