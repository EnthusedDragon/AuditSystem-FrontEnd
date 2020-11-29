package com.group12.controller.faculty;

import com.group12.entity.Faculty;
import com.group12.factory.FacultyFactory;
import com.group12.service.faculty.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


/**  Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 26-09-2020
 *   Description: Faculty Controller to expose Faculty business logic to the web
 */


@RestController
@RequestMapping("/AuditSystem/faculty")
@CrossOrigin(origins = "*")
public class FacultyController {

    @Autowired
    private FacultyServiceImpl service;


    @PostMapping("/create")
    public Faculty create(@RequestBody Faculty faculty){
        try {
            Faculty newFac = FacultyFactory.createFaculty(faculty.getFacultyName());
            return service.create(newFac);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @GetMapping("/getAll")
    public Set<Faculty> getAll(){
        return service.getAll();
    }


    @GetMapping("/getAllStartWith/{start}")
    public Set<Faculty> getAllStartingWith(@PathVariable String start){
        return service.getAllFacultyStartingWith(start);
    }


    @GetMapping("/getByName/{name}")
    public Faculty getByName(@PathVariable String name){
        return service.getFacultyByName(name);
    }


    @GetMapping("/getById/{id}")
    public Faculty getById(@PathVariable String id){
        return service.read(id);
    }


    @PutMapping("/update")
    public Faculty update(@RequestBody Faculty faculty){
        return service.update(faculty);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }


}
