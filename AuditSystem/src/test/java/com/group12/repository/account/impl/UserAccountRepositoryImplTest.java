//package com.group12.repository.account.impl;
//
//import com.group12.factory.UserAccountFactory;
//import com.group12.repository.account.UserAccountRepository;
//import com.group12.entity.UserAccount;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalDate;
//import java.util.stream.Collectors;
//
///**  Author: Rachael Klein
// *   Student no: 218 057 377
// *   Date: 25-08-2020
// *   Description: A UserAccount Repository Implementation using Test Driven Development
// */
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) //sorts my methods in an ascending order
//public class UserAccountRepositoryImplTest {
//
//    static LocalDate date = LocalDate.now();
//    //userAccountInformation is implemented using Singleton to implement CRUD methods to the database
//    //it's one and only one link/access to the database
//
//    @Autowired
//    private UserAccountRepository userAccountInformation;
//    // the Object userAccount used, using Factory
//    private static UserAccount userAccount;
//
//    // creating a new user account
//    @Test
//    public void a_create() {
//        try {
//            userAccount = UserAccountFactory.createUserAccount("rachaelk.private@gmail.com",
//                    "12345678rR1@!", true, date);
//            UserAccount created = userAccountInformation.save(userAccount);
//            //checks to see if the build using the Factory corresponds with the details saved in the database
//            Assert.assertEquals(userAccount.getUserId(), created.getUserId());
//            System.out.println("User account has been successfully created: "+ created);
//
//        }catch(Exception e)
//            {
//             Assert.fail();
//            }
//    }
//
//
//    // reads from the factory and checks if it's in the database using the userAccountInformation,
//    // and displays the data saved in the user account
//    @Test
//    public void b_read() {
//        try{
//            UserAccount read = userAccountInformation.findById(userAccount.getUserId()).orElseGet(null);
//            System.out.println("the current information within your user account is: " + read);
//            Assert.assertEquals(userAccount,read);
//        }catch(Exception e)
//            {
//            Assert.fail();
//            }
//        }
//
//    // deletes old data and updates the new data in it's place for the user account
//    // this is done by making a copy of the current userAccount details
//    // must make a copy first before you can modify a detail of the account
//    // so userAccount will correspond with the build using the factory userAccount
//    // then you can modify it, and call the build and update.
//    @Test
//    public void c_update() {
//
//        try {
//        UserAccount updated = new UserAccount.Builder().copy(userAccount).setEmail("RachaelJoubert@gmail.com").build();
//        updated = userAccountInformation.save(updated);
//        System.out.println("Account has been updated with: " + updated);
//        Assert.assertEquals("RachaelJoubert@gmail.com",updated.getEmail());
//        }catch(Exception e)
//            {
//            Assert.fail();
//            }
//}
//
//    // will return true if the user account has been deleted successfully
//    @Test
//    public void e_delete() {
//        try {
//            //
//            userAccountInformation.deleteById(userAccount.getUserId());
//            boolean deleted = userAccountInformation.existsById(userAccount.getUserId());
//            System.out.println("Account has been deleted: " + deleted);
//            Assert.assertTrue(deleted);
//        }catch(Exception e)
//            {
//            Assert.fail();
//            }
//    }
//    // will print out all information from the account
//    @Test
//    public void d_getAll() {
//            System.out.println("All information from user account is as follows: " + userAccountInformation.findAll().stream().collect(Collectors.toSet()));
//    }
//
//
//}
