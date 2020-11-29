package com.group12.repository.account;
/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 25-08-2020
 *   Description: Interface UserAccount Respository
 */

import com.group12.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,String>{

}
