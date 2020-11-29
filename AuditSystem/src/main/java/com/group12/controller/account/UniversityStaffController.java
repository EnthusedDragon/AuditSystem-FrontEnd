package com.group12.controller.account;


import com.group12.entity.UniversityStaff;
import com.group12.entity.UserAccount;
import com.group12.factory.UniversityStaffFactory;
import com.group12.service.account.impl.UniversityStaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
/**  Author: Limpho Ranamane
 *   Date: 22-09-2020
 *   Description: Web enabled controller for University staff
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/AuditSystem/universityStaff") // class will be listening to requests through this path
public class UniversityStaffController {
    @Autowired
    // injecting the object of UniversityStaff services into controllers so it can be manipulated over internet requests
    private UniversityStaffServiceImpl universityStaffService;

    // methods as per the UniversityStaff service impl

    @PostMapping("/create") // Post is used to create a new record
    public UniversityStaff create(@RequestBody UniversityStaff universityStaff){
        UniversityStaff creatingNewUniversityStaff = UniversityStaffFactory.createUniversityStaff(universityStaff.getEmail(), universityStaff.getPassword(), universityStaff.isLoginStatus(), universityStaff.getRegisterDate(), universityStaff.getFirstName(), universityStaff.getSurname(), universityStaff.getCellPhone(), universityStaff.getDepartment().getDepid());
        return universityStaffService.create(creatingNewUniversityStaff);
    }

    @GetMapping("/read/{id}") // makes the variable part of the path, to specify what you actually trying to read
    public UniversityStaff read (@PathVariable String id)
    {
        UniversityStaff reading = universityStaffService.read(id);
        return reading;
    }

    @PutMapping("/update") // Put is to update an existing record
    public UniversityStaff update(@RequestBody UniversityStaff universityStaff)
    {
        UniversityStaff updated = universityStaffService.update(universityStaff);
        return updated;
    }

    @DeleteMapping("/delete/{id}") // makes the variable part of the path, to specify what you actually trying to delete
    public boolean delete(@PathVariable String id)
    {
        boolean deleted = universityStaffService.delete(id);
        return deleted;
    }

    @GetMapping("/all")
    public Set getAll(){
        return universityStaffService.getAll();
    }


    @GetMapping("/login")
    public String login(String email, String password){
        return universityStaffService.login(email, password);
    }
}

