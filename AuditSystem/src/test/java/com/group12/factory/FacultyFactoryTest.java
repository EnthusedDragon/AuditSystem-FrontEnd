package com.group12.factory;

import com.group12.entity.Faculty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FacultyFactoryTest {

    public Faculty faculty;

    @Before
    public void setup(){
        try{
            faculty = FacultyFactory.createFaculty("Engineering");
        }
        catch (Exception ex){
            Assert.fail();
        }
    }

    @Test
    public void facultyCreated() {
        System.out.println(faculty.toString());
        Assert.assertTrue(faculty instanceof Faculty);
    }

    @Test
    public void facultyIdValid(){
        System.out.println(faculty.getFacultyId());
        Assert.assertNotEquals(null, faculty.getFacultyId());
    }

    @Test
    public void facultyNameValid(){
        System.out.println(faculty.getFacultyName());
        Assert.assertNotEquals(null, faculty.getFacultyName());
    }

}
