package com.group12.factory;
/**  Author: Limpho Ranamane
 *   Date: 02-07-2020
 *   Description: Auditor entity using Builder pattern
 */
import com.group12.entity.Auditor;
import com.group12.entity.UniversityStaff;
import com.group12.entity.UserAccount;
import com.group12.util.GenerateID;

import java.time.LocalDate;

public class AuditorFactory {

    /** Testing if user can input name, surname, and cellphone number
     * constraints: 1. None of the values should be null (therefore) include validations
     *              2. Validate that String should not include int
     *              3. Phone number must contain 10 digits and must start with 0
     *              4. All values must be correctly entered.
     * */

    public static Auditor createAuditor(String email, String password, boolean loginStatus, LocalDate registerDate, String firstname, String surname, String cellPhone )  {
        try {
            UserAccount userAccount = UserAccountFactory.createUserAccount(email, password, loginStatus, registerDate, firstname, surname, cellPhone);

            Auditor auditor = new Auditor.Builder()
                    .setId(userAccount.getId())
                    .setFirstName(userAccount.getFirstName())
                    .setSurname(userAccount.getSurname())
                    .setCellPhone(userAccount.getCellPhone())
                    .setEmail(userAccount.getEmail())
                    .setPassword(userAccount.getPassword())
                    .setLoginStatus(userAccount.isLoginStatus())
                    .setRegisterDate(userAccount.getRegisterDate())
                    .build();
            return auditor;
        }catch (Exception e)
        {
            return null;
        }
    }
}
