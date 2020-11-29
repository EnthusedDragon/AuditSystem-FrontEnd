package com.group12.repository.report;

import com.group12.entity.Report;
import com.group12.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Repository Implementation for report
 * Date: 24 August 2020
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, String>
{

}
