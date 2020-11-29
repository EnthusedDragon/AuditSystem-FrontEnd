//package com.group12.repository.account.impl;
///**  Author: Rachael Klein
// *   Student no: 218 057 377
// *   Date: 25-08-2020
// *   Description: An Implementation of an Interface UserAccount Respository
// */
//import com.group12.repository.account.UserAccountRepository;
//import com.group12.entity.UserAccount;
//
//import java.util.HashSet;
//import java.util.Set;
//
////UserAccountRepositoryImpl will act as a point of entry to the database
//public class UserAccountRepositoryImpl implements UserAccountRepository {
//    // setting the repository to null is the interface and is initialised to null
//    private static UserAccountRepository repository = null;
//
//    // I prefer using hashcode which is part of the Collection class as it has many benefits
//    // called my Hashcode Set userAccount, cause it will contain many userAccounts
//    private Set<UserAccount> userAccountDB;
//
//    //creating a private method, to encapsulate the collection stored.
//    //Hashset is part of the collection class that allows to store null values as well
//    private UserAccountRepositoryImpl(){
//        this.userAccountDB = new HashSet<>();
//    }
//
//
//    //implements Singleton design pattern, creates and enforces one instance access to the database
//    // so there is only one access to the database
//    public static UserAccountRepository getInstance(){
//        if(repository == null)repository = new UserAccountRepositoryImpl();
//        return repository;
//    }
//
//    // this method saves the data and set it to the hashcode set collection
//    @Override
//    public UserAccount create(UserAccount userAccount) {
//        this.userAccountDB.add(userAccount); // save new user account and their details
//        return userAccount;
//    }
//
//    // this method read what data was saved and displays it
//    @Override
//    public UserAccount read(String id) {
//        for (UserAccount userAcc : this.userAccountDB){
//            if (userAcc.getUserId().equalsIgnoreCase(id)){ // reads out the saved value no matter if it's in uppper or lower case
//                return userAcc;
//            }
//
//        }
//
//        return null;
//    }
//
//    // this method updates a user account details if needed
//    @Override
//    public UserAccount update(UserAccount userAccount) {
//        boolean deleteAccount = delete(userAccount.getUserId()); // have to delete the existing value
//        if(deleteAccount){ // if the existing value is deleted
//            this.userAccountDB.add(userAccount); // the new value will then be added
//            return userAccount;
//        } return  null;
//    }
//
//    // this method delete a user Account if needed
//    @Override
//    public boolean delete(String id) {
//       UserAccount userAccount = read(id); //reads to see if there is a value
//       if(userAccount !=null){ // if not null and has a value, it is then removed on line 71
//           this.userAccountDB.remove(userAccount);
//           return true; // returns true is it was successfully removed
//       } return false;
//    }
//
//    // this method displays all details of the user account
//    @Override
//    public Set<UserAccount> getAll() {
//        return this.userAccountDB;
//    }
//
//}
