package com.group12.repository.account;

import com.group12.entity.Auditor;
import com.group12.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**  Author: Limpho Ranamane
 *   Date: 24-08-2020
 *   Description: Interface directly responsible for handling the call for all values in the Auditor DB
 */

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, String> {

}
