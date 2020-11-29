package com.group12.service.issue.impl;

import com.group12.entity.Issue;
import com.group12.entity.UserAccount;
import com.group12.factory.IssueFactory;
import com.group12.service.issue.IssueService;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


//This class is used to test the methods of the IssueServiceImpl.class
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IssueServiceImplTest {

    @Autowired
    private IssueService issueService;

    private static Issue issue = IssueFactory.createIssue("Safety", "Broken mirrors", "1234-1234",new UserAccount.Builder().build());

    @Test
    public void z_getAll() {

        try {

            Set<Issue> issueSet = issueService.getAll();

            assertEquals(2, issueSet.size());//Expected size = 2 because read() and delete() each saves 1 Issue

        }catch (Exception e){

            System.out.println(e.getMessage());
        }

    }

    @Test
    public void f_getIssueByID() {

        try {

        Issue expectedIssue = issue;
        Issue actualIssue = issueService.read(issue.getIssueID());

        assertEquals(expectedIssue.getIssueID(), actualIssue.getIssueID());
    }catch (Exception e){

        System.out.println(e.getMessage());
    }

    }

    @Test
    public void g_resolveIssue() {

        try {

        issueService.resolveIssue(issue.getIssueID());

        Issue actualIssue = issueService.read(issue.getIssueID());
        System.out.printf(""+actualIssue.getIsResolved());
        assertTrue(actualIssue.getIsResolved());

    }catch (Exception e){

        System.out.println(e.getMessage());
        }
    }


    @Test
    public void h_validateIssue() {

        try {

        issueService.validateIssue(issue.getIssueID());

        Issue actualIssue = issueService.read(issue.getIssueID());
        System.out.printf("resolved: "+actualIssue.getIsResolved()+"   validated: " + actualIssue.getIsValidated());
        assertTrue(actualIssue.getIsValidated());

        }catch (Exception e){

        System.out.println(e.getMessage());
        }

    }

    @Test
    public void i_openIssue() {

        try {

        issueService.openIssue(issue.getIssueID());

        Issue actualIssue = issueService.read(issue.getIssueID());

        assertTrue(actualIssue.getIssueStatus());
        }catch (Exception e){

        System.out.println(e.getMessage());
        }

    }

    @Test
    public void j_closeIssue() {

        try {

        issueService.closeIssue(issue.getIssueID());

        Issue actualIssue = issueService.read(issue.getIssueID());
        System.out.printf(""+actualIssue.getIssueStatus());
        assertFalse(actualIssue.getIssueStatus());
        }catch (Exception e){

        System.out.println(e.getMessage());
        }
    }

    @Test
    public void a_create() {

        try {

        Issue expectedIssue = issueService.create(issue);
        Issue actualIssue = issueService.read(issue.getIssueID());
        assertEquals(expectedIssue.getIssueID(), actualIssue.getIssueID());

        }catch (Exception e){

        System.out.println(e.getMessage());
        }

    }

    @Test
    public void b_read() {

        try {

        Issue expectedIssue = issueService.create(issue);
        Issue actualIssue = issueService.read(issue.getIssueID());

        assertEquals(expectedIssue, actualIssue);

        }catch (Exception e){

        System.out.println(e.getMessage());
        }
    }

    @Test
    public void c_update() {

        try {

        Issue expectedIssue = issue;

        Issue issue1 = new Issue.Builder().copy(expectedIssue).setIssueDescription("Broken glass on ground")
                .build();

        issueService.update(issue1);
        Issue actualIssue = issueService.read(issue1.getIssueID());

        assertEquals(expectedIssue.getIssueID(), actualIssue.getIssueID());
        assertNotEquals(expectedIssue.getIssueDescription(), actualIssue.getIssueDescription());
        }catch (Exception e){

        System.out.println(e.getMessage());
        }

    }

    @Test
    public void d_delete() {

        try {

        Issue expectedIssue = issueService.create(issue);
        boolean expectedResult = true;
        boolean actualResult = issueService.delete(expectedIssue.getIssueID());

        assertTrue(actualResult);
        }catch (Exception e){

        System.out.println(e.getMessage());
        }

    }
}