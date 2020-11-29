package com.group12.factory;

import com.group12.entity.Auditor;
import com.group12.entity.UniversityStaff;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AuditorFactoryTest {

    // tests if ID is not null
    @Test
    public void createAuditorID() {
        Auditor auditor = AuditorFactory.createAuditor("Shelly@gmail.com", "P@ssword123", false, LocalDate.now(), "Shelly", "Caledon", "0824338970");
        Assert.assertNotNull(auditor.getId());
    }

    // tests if the user did put in name correctly
    @Test
    public void createAuditorName() {
        Auditor auditor = AuditorFactory.createAuditor("Shelly@gmail.com", "P@ssword123", false, LocalDate.now(), "Shelly", "Caledon", "0824338970");
        Assert.assertEquals("Shelly", auditor.getFirstName());
    }

    // tests if the user did put in surname
    @Test
    public void createAuditorSurname() {
        Auditor auditor = AuditorFactory.createAuditor("Shelly@gmail.com", "P@ssword123", false, LocalDate.now(), "Shelly", "Caledon", "0824338970");
        Assert.assertEquals("Caledon", auditor.getSurname());
    }

    // tests if the user did put in the phone number
    @Test
    public void createAuditorCellphoneNumber() {
        Auditor auditor = AuditorFactory.createAuditor("Shelly@gmail.com", "P@ssword123", false, LocalDate.now(), "Shelly", "Caledon", "0824338970");
        Assert.assertEquals("0824338970", auditor.getCellPhone());
    }
}