//package com.group12.repository.faculty.impl;
//
//import com.group12.entity.Faculty;
//import com.group12.factory.FacultyFactory;
//import com.group12.repository.faculty.FacultyRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
///**
// * @author Ebenezer Mathebula - 217301827
// * Desc: Repository Implementation Test for Faculty
// * Date: 28 August 2020
// */
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class FacultyRepositoryImplTest {
//
//    @Autowired
//    private static FacultyRepository repo;
//
//    // Instances to test with
//    private static Faculty engineering = null;
//    private static Faculty accounting = null;
//    private static Faculty arts = null;
//
//    @Test
//    public void a_create() {
//        try {
//            engineering = FacultyFactory.createFaculty("Engineering");
//            accounting = FacultyFactory.createFaculty("Accounting");
//            arts = FacultyFactory.createFaculty("Arts and Culture");
//
//            repo.save(engineering);
//            repo.save(accounting);
//            repo.save(arts);
//
////            int expectedSizeOfDB = 3;
////            int actualSizeOfDB = repo.count();
////            Assert.assertEquals(expectedSizeOfDB, actualSizeOfDB);
//        }
//        catch (Exception e) {
//            Assert.fail();
//        }
//
//    }
//
//
//    @Test
//    public void b_read() {
//        try {
//            Faculty read = repo.findById(accounting.getFacultyId()).orElseGet(null);
//            System.out.println("READ: " + read.toString());
//            System.out.println("");
//
//            Assert.assertEquals(accounting, read);
//        }
//        catch (Exception ex){
//            Assert.fail();
//        }
//    }
//
//
//    @Test
//    public void c_update() {
//        try {
//            // copy old instance and set a new name for it
//            String newName = "Financial Accounting";
//            Faculty newFac = new Faculty.Builder().copy(accounting).setFacultyName(newName).build();
//            repo.save(newFac);
//
//            System.out.println("UPDATE: " + repo.findById(accounting.getFacultyId()).toString());
//            System.out.println("");
//
//            String actualNewName = repo.findById(accounting.getFacultyId()).orElseGet(null).getFacultyName();
//            Assert.assertEquals(newName, actualNewName);
//        }
//        catch (Exception ex){
//            Assert.fail();
//        }
//    }
//
//
//    @Test
//    public void delete() {
//        repo.deleteById(arts.getFacultyId());
//        boolean isDeleted = repo.existsById(arts.getFacultyId())?false:true;
//
//        System.out.println("DELETED: " + isDeleted);
//        System.out.println("");
//
//        Assert.assertTrue(isDeleted);
//    }
//
//    @Test
//    public void e_getAllFaculties() {
//        Assert.assertTrue(repo.findAll() instanceof Set);
//    }
//
//
//}