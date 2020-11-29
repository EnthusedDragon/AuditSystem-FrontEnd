package com.group12.service.account;

/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 02-09-2020
 *   Description: An Implementation of UserAccountService Interface  that implements the IService
 */

import com.group12.entity.UserAccount;
import com.group12.service.IService;
import java.util.Set;

public interface UserAccountService extends IService<UserAccount,String> {
    Set<UserAccount> getAll();

    // business logic for UserAccount
        //1 - I can check if the email address already exist, if so, user account cant be created again.
        UserAccount registerUserAccount(String email, String verifyEmail, String password, String verifyPassword, String firstname, String surname, String cellPhone) throws Exception;

        //2 -  change password, should be allowed for a password to be changed.
        boolean changePassword (String existingPassword, String newPassword, String verifyNewPassword, String email) throws Exception;

        //3 - update email address to new email address.
        boolean updateEmailAddress(String emailAddress, String newEmailAddress, String verifyNewEmailAddress, String password) throws Exception;

        //4 - forgot password, account reset to new password
        boolean forgotPassword(String emailAddress) throws Exception;

        //5 - gets UserAccount via email address
        UserAccount getUserAccountViaEmailAddress(String email);

        String login(String email, String password);


}
