package com.group12.service.account;

import com.group12.entity.UniversityStaff;
import com.group12.service.IService;

import java.util.Set;

/**  Author: Limpho Ranamane
 *   Date: 01-09-2020
 *   Description: Interface responsible for handling the call for all values for tor the repository for University Staff
 */
public interface UniversityStaffService extends IService<UniversityStaff, String> {
    Set<UniversityStaff> getAll();
    String login(String email, String password);
}
