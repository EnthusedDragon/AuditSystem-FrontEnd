package com.group12.service.account.impl;

import com.group12.entity.Auditor;
import com.group12.entity.UniversityStaff;
import com.group12.repository.account.AuditorRepository;
import com.group12.service.account.AuditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

/**  Author: Limpho Ranamane
 *   Date: 01-09-2020
 *   Description: Auditor service implementation responsible for providing service for repository on Auditor
 */

@Service //acts as a service over the internet
public class AuditorServiceImpl implements AuditorService {

    @Autowired //enforces singleton
    private AuditorRepository auditorRepository;


    @Override
    public Auditor create(Auditor t) {
        return this.auditorRepository.save(t);
    }

    @Override
    public Auditor read(String s) {
        return this.auditorRepository.findById(s).orElseGet(null);
    }

    @Override
    public Auditor update(Auditor t) {
        return this.auditorRepository.save(t);
    }

    @Override
    public boolean delete(String s) {
        this.auditorRepository.deleteById(s);
        if (this.auditorRepository.existsById(s)) return false;
        else return true;
    }

    @Override
    public Set<Auditor> getAll() {
        return this.auditorRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public String login(String email, String password){
        Set<Auditor> users = getAll();

        for (Auditor user: users) {
            if(user.getEmail().equals(email))
            {
                if(user.getPassword().equals(password))
                {
                    return  user.getId();
                }else
                {
                    return null;
                }
            }
        }

        return null;
    }
}