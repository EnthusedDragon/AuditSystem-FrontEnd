package com.group12.controller.department;

import com.group12.entity.Department;
import com.group12.factory.DepartmentFactory;
import com.group12.service.department.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


/**  Author: Enver Human
 *   Student no: 216174929
 *   Date: 27-09-2020
 *   Description:  Exposing department business logic to the web through department controller
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/AuditSystem/department")
public class DepartmentController {


    @Autowired
    private DepartmentServiceImpl service;


    @PostMapping("/create")
    public Department create(@RequestBody Department department){
        try {
            Department newDepartment = DepartmentFactory.createDepartment(department.getDepName(), department.getFaculty().getFacultyId());
            return service.create(newDepartment);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @GetMapping("/getAll")
    public Set<Department> getAll(){
        return service.getAll();
    }




    @GetMapping("/getById/{id}")
    public Department getById(@PathVariable String id){
        return service.read(id);
    }


    @PutMapping("/update")
    public Department update(@RequestBody Department department){
        return service.update(department);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }


}