package com.group12.controller.account;

import com.group12.entity.Auditor;
import com.group12.factory.AuditorFactory;
import com.group12.service.account.impl.AuditorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**  Author: Limpho Ranamane
 *   Date: 22-09-2020
 *   Description: Web enabled controller for Auditor
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/AuditSystem/auditor") // class will be listening to requests through this path
public class AuditorController {

    @Autowired // injecting the object of Auditor services into controllers so it can be manipulated over internet requests
    private AuditorServiceImpl auditorService;

    // methods as per the Auditor service impl

    @PostMapping("/create") // Post is used to create a new record
    public Auditor create(@RequestBody Auditor auditor){
        Auditor creatingNewAuditor = AuditorFactory.createAuditor(auditor.getEmail(), auditor.getPassword(),
                auditor.isLoginStatus(), auditor.getRegisterDate(), auditor.getFirstName(), auditor.getSurname(), auditor.getCellPhone());
        if(creatingNewAuditor == null)
        {
            return null;
        }

        return auditorService.create(creatingNewAuditor);
    }

    @GetMapping("/read/{id}") // makes the variable part of the path, to specify what you actually trying to read
    public Auditor read (@PathVariable String id)
    {
        Auditor reading = auditorService.read(id);
        return reading;
    }

    @PutMapping("/update") // Put is to update an existing record
    public Auditor update(@RequestBody Auditor auditor)
    {
        Auditor updated = auditorService.update(auditor);
        return updated;
    }

    @DeleteMapping("/delete/{id}") // makes the variable part of the path, to specify what you actually trying to delete
    public boolean delete(@PathVariable String id)
    {
        boolean deleted = auditorService.delete(id);
        return deleted;
    }

    @GetMapping("/all")
    public Set getAll(){
        return auditorService.getAll();
    }


    @GetMapping("/login")
    public String login(String email, String password){
        return auditorService.login(email, password);
    }
}
