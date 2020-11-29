//package com.group12.repository.account.impl;
//
//import com.group12.entity.UniversityStaff;
//import com.group12.repository.account.UniversityStaffRepository;
//
//import java.util.HashSet;
//import java.util.Set;
///**  Author: Limpho Ranamane
// *   Date: 26-08-2020
// *   Description: University Staff implementation Repository in charge for manipulating data
// */
//public class UniversityStaffRepositoryImpl implements UniversityStaffRepository {
//
//    private Set<UniversityStaff> universityStaffStorage; // data storage/database for UniversityStaff using a data structure
//    private static UniversityStaffRepository universityStaffRepository = null;
//
//    private UniversityStaffRepositoryImpl() {
//        this.universityStaffStorage = new HashSet<>();
//    }
//
//    //singleton to only access and enforce a single entry to the DB
//    //enforces only one instance of this class
//    public static UniversityStaffRepository getUniversityStaffRepository(){
//        if(universityStaffRepository ==null) universityStaffRepository =new UniversityStaffRepositoryImpl();
//        return universityStaffRepository;
//    }
//
//    //the following methods implements manipulation to the DB (AuditorStorage) by adding, reading, updating, getting all that's in the database and deleting by PK
//    @Override
//    public UniversityStaff create(UniversityStaff universityStaff) {
//        this.universityStaffStorage.add(universityStaff);
//        return universityStaff;
//    }
//
//    @Override
//    public UniversityStaff read(String universityStaffID) {
//        for (UniversityStaff universityStaff: this.universityStaffStorage)
//        {
//            if(universityStaff.getUniversityStaffID().equalsIgnoreCase(universityStaffID)) { //checks whether passed PK is in the DB and if there, it reads the data
//                return universityStaff;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public UniversityStaff update(UniversityStaff universityStaff) {
//        boolean previousUniversityStaffDetails = delete(universityStaff.getUniversityStaffID()); //if PK correlates then it deletes the version
//        if(previousUniversityStaffDetails)
//        {
//            this.universityStaffStorage.add(universityStaff);//adds new version of the data
//            return universityStaff;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String universityStaffID) {
//        UniversityStaff universityStaff = read(universityStaffID);//checks if data does exists by PK
//        if (universityStaff != null) {
//            this.universityStaffStorage.remove(universityStaff);//if data exists it deletes
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<UniversityStaff> getAll() {
//        return this.universityStaffStorage;//returns all data in the DBS
//    }
//}
//
