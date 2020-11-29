package com.group12.service.faculty.impl;

import com.group12.entity.Faculty;
import com.group12.repository.faculty.FacultyRepository;
import com.group12.service.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**  Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 05-09-2020
 *   Description: An Implementation of Faculty Service
 */


@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository repository;

    @Override
    public Set<Faculty> getAll() {
        Set<Faculty> answer = this.repository.findAll().stream().collect(Collectors.toSet());
        return answer;
    }


    @Override
    public Set<Faculty> getAllFacultyStartingWith(String start) {
        Set<Faculty> faculties = new HashSet<>();

        for (Faculty fac : getAll()){
            start = start.toLowerCase();
            String facName = fac.getFacultyName().toLowerCase();

            if(facName.startsWith(start)){
                faculties.add(fac);
            }
        }
        return faculties;
    }


    @Override
    public Faculty getFacultyByName(String name) {
        Faculty faculty = null;

        for (Faculty fac : this.repository.findAll()){
            if(fac.getFacultyName().equalsIgnoreCase(name)){
                faculty = fac;
            }
        }
        return faculty;
    }


    @Override
    public Faculty create(Faculty faculty) {
        return this.repository.save(faculty);
    }

    @Override
    public Faculty read(String id) {
        return this.repository.findById(id).orElseGet(null);
    }

    @Override
    public Faculty update(Faculty faculty) {
        if(this.repository.existsById(faculty.getFacultyId())){
            return this.repository.save(faculty);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        boolean isDeleted = this.repository.existsById(id)?false:true;

        return isDeleted;
    }

}
