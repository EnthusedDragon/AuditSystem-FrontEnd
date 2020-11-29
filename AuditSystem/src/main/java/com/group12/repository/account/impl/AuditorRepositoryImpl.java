//package com.group12.repository.account.impl;
//
//import com.group12.entity.Auditor;
//import com.group12.repository.account.AuditorRepository;
//import java.util.HashSet;
//import java.util.Set;
///**  Author: Limpho Ranamane
// *   Date: 24-08-2020
// *   Description: Auditor implementation Repository in charge for manipulating data
// */
//public class AuditorRepositoryImpl implements AuditorRepository {
//
//    private Set<Auditor> auditorStorage; // data storage/database for Auditor using a data structure
//    private static AuditorRepository auditorRepository = null;
//
//    private AuditorRepositoryImpl() {
//        this.auditorStorage = new HashSet<>();
//    }
//
//    //singleton to only access and enforce a single entry to the DB
//    //enforces only one instance of this class
//    public static AuditorRepository getAuditorRepository(){
//        if(auditorRepository==null) auditorRepository=new AuditorRepositoryImpl();
//        return auditorRepository;
//    }
//
//    //the following methods implements manipulation to the DB (AuditorStorage) by adding, reading, updating, getting all that's in the database and deleting by PK
//    /**
//     *
//     * @param auditor
//     * @return
//     */
//    @Override
//    public Auditor create(Auditor auditor)
//    {
//        this.auditorStorage.add(auditor);
//        return auditor;
//    }
//
//    /**
//     *
//     * @param auditorID
//     * @return
//     */
//    @Override
//    public Auditor read(String auditorID)
//    {
//        for (Auditor auditor: this.auditorStorage)
//        {
//            if(auditor.getAuditorID().equalsIgnoreCase(auditorID)) { //checks whether passed PK is in the DB and if there, it reads the data
//                return auditor;
//            }
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @param auditor
//     * @return
//     */
//    @Override
//    public Auditor update(Auditor auditor)
//    {
//        boolean previousAuditorDetails = delete(auditor.getAuditorID());//if PK correlates then it deletes the version
//        if(previousAuditorDetails)
//        {
//            this.auditorStorage.add(auditor);//adds new version of the data
//            return auditor;
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @param auditorID
//     */
//    @Override
//    public boolean delete(String auditorID) {
//        Auditor auditor = read(auditorID); //checks if data does exists by PK
//        if (auditor != null) {
//            this.auditorStorage.remove(auditor);//if data exists it deletes
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Auditor> getAll() {
//        return this.auditorStorage;
//    }//returns all data in the DBS
//}
//
