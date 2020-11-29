package com.group12.service.account.impl;

import com.group12.entity.Department;
import com.group12.entity.UniversityStaff;
import com.group12.entity.UserAccount;
import com.group12.repository.account.UniversityStaffRepository;
import com.group12.repository.department.DepartmentRepository;
import com.group12.service.account.UniversityStaffService;
import com.group12.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**  Author: Limpho Ranamane
 *   Date: 01-09-2020
 *   Description: UniversityStaff service implementation responsible for providing service for repository on University Staff
 */

@Service
public class UniversityStaffServiceImpl implements UniversityStaffService {
    @Autowired //enforces singleton
    private UniversityStaffRepository universityStaffRepository;
    @Autowired //enforces singleton
    private DepartmentService departmentService;

    @Override
    public UniversityStaff create(UniversityStaff t) {
        Department department = departmentService.read(t.getDepartment().getDepid());
        if(department == null)
        {
            return null;
        }
        UniversityStaff universityStaff = new UniversityStaff.Builder().copy(t).setDepartment(department).build();
        return this.universityStaffRepository.save(universityStaff);
    }

    @Override
    public UniversityStaff read(String s) {
        return this.universityStaffRepository.findById(s).orElseGet(null);
    }

    @Override
    public UniversityStaff update(UniversityStaff t) {
        Department department = departmentService.read(t.getDepartment().getDepid());
        if(department == null)
        {
            return null;
        }
        UniversityStaff universityStaff = new UniversityStaff.Builder().copy(t).setDepartment(department).build();
        return this.universityStaffRepository.save(universityStaff);
    }

    @Override
    public boolean delete(String s) {
        this.universityStaffRepository.deleteById(s);
        if(this.universityStaffRepository.existsById(s)) return false;
        else return true;
    }

    @Override
    public Set<UniversityStaff> getAll() {
        return this.universityStaffRepository.findAll().stream().collect(Collectors.toSet());
    }


    @Override
    public String login(String email, String password){
        Set<UniversityStaff> users = getAll();

        for (UniversityStaff user: users) {
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

