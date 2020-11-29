package com.group12.repository.issue.impl;//package com.group12.repository.issue.impl;
//
//import com.group12.entity.Issue;
//import com.group12.repository.issue.IssueRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
////This class is used to override methods of IssueRepository for use of issue entity.
//public class IssueRepositoryImpl implements IssueRepository {
//
//    private static IssueRepository issueRepository = null;
//
//    private Set<Issue> issueDB;
//
//    private IssueRepositoryImpl(){
//
//        this.issueDB = new HashSet<>();
//    }
//
//    public static IssueRepository getIssueRepositoryInstance(){
//
//        if(issueRepository == null) issueRepository = new IssueRepositoryImpl();
//        return issueRepository;
//    }
//
//    //adds Issue record to Repository
//    @Override
//    public Issue create(Issue issue) {
//
//        this.issueDB.add(issue);
//        return issue;

//    }
//
//
//    @Override
//    public Issue read(String id) {
//
//        Issue issueToRead = null;
//        boolean found = false;
//
//        for(Issue issue: this.issueDB){
//
//            if(issue.getIssueID().equals(id)){
//
//                found = true;
//
//            } else found = false;
//
//            if(found == true){
//
//                issueToRead = issue;
//
//            }
//        }
//
//        return issueToRead;
//    }
//
//    @Override
//    public Issue update(Issue issue) {
//
//        Issue dbUpdatedIssue = null;
//        boolean found = false;
//
//        for(Issue i: this.issueDB){
//
//            if(i.getIssueID().equals(issue.getIssueID())){
//
//                found = true;
//                dbUpdatedIssue = issue;
//
//            }else {
//
//                found = false;
//            }
//
//            if(found == true) {
//
//                this.issueDB.remove(i);
//                this.issueDB.add(dbUpdatedIssue);
//            }
//        }
//
//
//
//        return dbUpdatedIssue;
//    }
//
//    @Override
//    public boolean delete(String id) {
//
//        boolean isDeleted = false;
//
//        for (Issue issue: this.issueDB){
//
//            if(issue.getIssueID().equals(id)){
//
//                isDeleted = true;
//
//            }else{
//
//                isDeleted = false;
//            }
//            this.issueDB.remove(id);
//        }
//        return isDeleted;
//    }
//
//    @Override
//    public Set<Issue> getAll() {
//
//        return this.issueDB;
//    }
//
//
//}
