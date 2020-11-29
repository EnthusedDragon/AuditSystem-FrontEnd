package com.group12.controller.report;

import com.group12.entity.Login;
import com.group12.entity.Report;
import com.group12.factory.ReportFactory;
import com.group12.service.report.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Controller for report
 * Date: 22 September 2020
 */
@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "*")
public class ReportController
{
    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping("/create")
    public Report create(@RequestBody Report report)
    {
        return reportService.create(report);
    }

    @GetMapping("/read/{id}")
    public Report read(@PathVariable String id)
    {
        return reportService.read(id);
    }

    @PostMapping("/update")
    public Report update(@RequestBody Report report)
    {
        return reportService.update(report);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return reportService.delete(id);
    }

    @GetMapping("/all")
    public Set<Report> getAll()
    {
        return reportService.getAll();
    }
}
