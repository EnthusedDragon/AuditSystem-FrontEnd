package com.group12.factory;
/**  Author: Limpho Ranamane
 *   Date: 02-07-2020
 *   Description: Auditor entity using Builder pattern
 */
import com.group12.entity.Department;
import com.group12.entity.UniversityStaff;
import com.group12.entity.UserAccount;
import com.group12.util.GenerateID;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniversityStaffFactory {

    public static UniversityStaff createUniversityStaff(String email, String password, boolean loginStatus, LocalDate registerDate, String firstname, String surname, String cellPhone, String departmentId)
    {
        try {
            UserAccount userAccount = UserAccountFactory.createUserAccount(email, password, loginStatus, registerDate, firstname, surname, cellPhone);

            UniversityStaff universityStaff = new UniversityStaff.Builder()
                    .setId(userAccount.getId())
                    .setFirstName(userAccount.getFirstName())
                    .setSurname(userAccount.getSurname())
                    .setCellPhone(userAccount.getCellPhone())
                    .setEmail(userAccount.getEmail())
                    .setPassword(userAccount.getPassword())
                    .setLoginStatus(userAccount.isLoginStatus())
                    .setRegisterDate(userAccount.getRegisterDate())
                    .setDepartment(new Department.Builder().setDepid(departmentId).build())
                    .build();
            return universityStaff;
        }catch (Exception e)
        {
            return null;
        }
    }
}
