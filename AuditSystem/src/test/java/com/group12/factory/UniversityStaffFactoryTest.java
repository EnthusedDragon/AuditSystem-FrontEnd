package com.group12.factory;

import com.group12.entity.UniversityStaff;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class UniversityStaffFactoryTest {
    // tests if ID is not null
    @Test
    public void createUniversityStaffID() {
        UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff( "Limpho@gmail.com","P@ssword123",false, LocalDate.now(),"Limpho","Ranamane", "0824568970", "1234-1234");
        Assert.assertNotNull(universityStaff.getId());
    }

    // tests if the user did put in name correctly
    @Test
    public void createUniversityStaffName() {
        UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff( "Limpho@gmail.com","P@ssword123",false, LocalDate.now(),"Limpho","Ranamane", "0824568970", "1234-1234");
        Assert.assertEquals("Limpho", universityStaff.getFirstName());
    }

    // tests if the user did put in surname
    @Test
    public void createUniversityStaffSurname() {
        UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff( "Limpho@gmail.com","P@ssword123",false, LocalDate.now(),"Limpho","Ranamane", "0824568970", "1234-1234");
        Assert.assertEquals("Ranamane", universityStaff.getSurname());
    }

    // tests if the user did put in the phone number
    @Test
    public void createUniversityStaffCellphoneNumber() {
        UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff( "Limpho@gmail.com","P@ssword123",false, LocalDate.now(),"Limpho","Ranamane", "0824568970", "1234-1234");
        Assert.assertEquals("0824568970", universityStaff.getCellPhone());
    }
}