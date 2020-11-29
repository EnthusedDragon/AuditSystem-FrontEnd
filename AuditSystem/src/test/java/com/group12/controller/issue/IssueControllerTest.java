package com.group12.controller.issue;

import com.group12.entity.Issue;
import com.group12.entity.UserAccount;
import com.group12.factory.IssueFactory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class IssueControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    String url = "http://localhost:8080/issue";

    //admin can do everything
    private static final String Admin_Username = "Boss";
    private static final String Admin_Password = "123";


    ResponseEntity<Issue> issue = null;


    void setup(){

        Issue setupIssue = IssueFactory.createIssue("Safety","Broken bathroom mirrors", "1234-1234",new UserAccount.Builder().build());
        issue = restTemplate.postForEntity(url+"/createIssue", setupIssue,Issue.class);

    }

    @Test
    void d_createIssue() {

        try{

            Issue createIssue = IssueFactory.createIssue("Area Of New Issue","Description of New Issue", "1234-1234",new UserAccount.Builder().build());
            ResponseEntity<Issue> expectedIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                    .postForEntity(url+"/createIssue", createIssue,Issue.class);

            System.out.printf(expectedIssue.getBody()+ "\n");

            String issueArea = expectedIssue.getBody().getIssueArea();
            String issueDescription = expectedIssue.getBody().getIssueDescription();

            if(issueArea != null && issueDescription != null) {

                assertEquals(expectedIssue.getStatusCode(), HttpStatus.OK);
                assertNotNull(expectedIssue);
            }



        }catch(Exception e){

            System.out.printf(e.getMessage());
        }
    }

    @Test
    void b_readIssue() {

        setup();
        String urlRead = url+"/readIssue?issueID="+issue.getBody().getIssueID();

        ResponseEntity<Issue> responseIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(urlRead, Issue.class);

        System.out.printf(responseIssue.getBody().toString()+"\n");

        assertNotNull(responseIssue);
        assertEquals(responseIssue.getStatusCode(), HttpStatus.OK);
        assertEquals(issue.getBody().getIssueID(), responseIssue.getBody().getIssueID());

    }

    @Test
    void c_updateIssue() {

        String urlUpdate = url+"/updateIssue";

        Issue issueToUpdate = IssueFactory.createIssue("IssueToUpdateArea","IssueToUpdateDescription", "1234-1234",new UserAccount.Builder().build());
        ResponseEntity<Issue> updateIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .postForEntity(url+"/createIssue", issueToUpdate,Issue.class);

        Issue updatedIssue = new Issue.Builder().copy(updateIssue.getBody())
                .setIsResolved(true)
                .build();

        HttpEntity<Issue> issueHttpEntity = new HttpEntity<Issue>(updatedIssue, null);
        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .exchange(urlUpdate, HttpMethod.PUT, issueHttpEntity, Issue.class);

        ResponseEntity<Issue> updatedIssueResponse = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(url+"/readIssue?issueID="+issueHttpEntity.getBody().getIssueID(), Issue.class);

        System.out.printf(issueHttpEntity.toString()+"\n");
        System.out.printf(updatedIssue.toString()+"\n");
        System.out.printf(updatedIssueResponse.getBody().toString());

        assertNotNull(updatedIssueResponse);
        assertNotEquals(issueHttpEntity, updatedIssueResponse);
        assertEquals(issueHttpEntity.getBody().getIssueID(), updatedIssueResponse.getBody().getIssueID());
    }

    @Test
    void a_deleteIssue() {


        Issue issueToDelete = IssueFactory.createIssue("IssueToDeleteArea","IssueToDeleteDescription", "1234-1234",new UserAccount.Builder().build());

        ResponseEntity<Issue> expectedIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .postForEntity(url+"/createIssue", issueToDelete,Issue.class);

        String issueID = expectedIssue.getBody().getIssueID();

        System.out.printf(expectedIssue.getBody().toString()+"\n");

        String urlDelete = url+"/deleteIssue?issueID="+issueID;

        ResponseEntity<Boolean> isDeleted = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .exchange(urlDelete, HttpMethod.DELETE,null , boolean.class);

        System.out.printf(isDeleted.getStatusCode()+"\n"+isDeleted.getBody());

        assertTrue(isDeleted.getBody());
        assertEquals(isDeleted.getStatusCode(), HttpStatus.OK);
    }


    @Test
    void f_resolveIssue() {

        setup();

        String urlRead = url+"/readIssue?issueID="+issue.getBody().getIssueID();

        ResponseEntity<Issue> responseIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(urlRead, Issue.class);

        System.out.printf(responseIssue.toString()+"\n");

        //resolve endpoint

        String urlResolve = url+"/resolveIssue?issueID="+responseIssue.getBody().getIssueID();

        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .put(urlResolve, Issue.class);

        ResponseEntity<Issue> returnedIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(urlRead, Issue.class);

        System.out.printf(returnedIssue.toString());

        assertTrue(returnedIssue.getBody().getIsResolved());

    }

    @Test
    void g_validateIssue() {

        setup();

        String urlResolve = url+"/resolveIssue?issueID="+issue.getBody().getIssueID();

        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .put(urlResolve, Issue.class);

        String urlRead = url+"/readIssue?issueID="+issue.getBody().getIssueID();

        ResponseEntity<Issue> returnedIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(urlRead, Issue.class);

        String urlValidate = url+"/validateIssue?issueID="+returnedIssue.getBody().getIssueID();

        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .put(urlValidate, Issue.class);

        ResponseEntity<Issue> validatedIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(urlRead, Issue.class);

        System.out.printf(validatedIssue.toString());

        assertTrue(validatedIssue.getBody().getIsValidated());


    }

    @Test
    void e_openIssue() {

        setup();

        //setting issueStatus to false/closed
        String urlCloseIssue = url+"/closeIssue?issueID="+issue.getBody().getIssueID();
        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(urlCloseIssue, Issue.class);

        ResponseEntity<Issue> readClosedIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(url+"/readIssue?issueID="+issue.getBody().getIssueID(), Issue.class);

        System.out.printf(readClosedIssue.getBody().toString());

        //this is the endpoint to test
        String urlOpenIssue = url+"/openIssue?issueID="+readClosedIssue.getBody().getIssueID();

        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(urlOpenIssue, Issue.class);

        ResponseEntity<Issue> issueResponseEntity = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(url+"/readIssue?issueID="+readClosedIssue.getBody().getIssueID(), Issue.class);


        System.out.printf(issueResponseEntity.getBody().toString()+"\n");

        assertEquals(issueResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(readClosedIssue.getBody().getIssueID(), issueResponseEntity.getBody().getIssueID());
        assertEquals(true, issueResponseEntity.getBody().getIssueStatus());


    }

    @Test
    void h_closeIssue() {

        setup();

        String urlResolve = url+"/resolveIssue?issueID="+issue.getBody().getIssueID();
        String urlValidate = url+"/validateIssue?issueID="+issue.getBody().getIssueID();
        String urlClose = url+"/closeIssue?issueID="+issue.getBody().getIssueID();

        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .put(urlResolve, Issue.class);
        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .put(urlValidate, Issue.class);
        restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .put(urlClose, Issue.class);

        String urlRead = url+"/readIssue?issueID="+issue.getBody().getIssueID();
        ResponseEntity<Issue> returnedIssue = restTemplate.withBasicAuth(Admin_Username, Admin_Password)
                .getForEntity(urlRead, Issue.class);

        System.out.printf(returnedIssue.toString());

        assertFalse(returnedIssue.getBody().getIssueStatus());




    }

    @Test
    void i_getAllIssues() {

        String urlGetAllIssues = url+"/getAllIssues";

        ResponseEntity<Set> setResponseEntity = restTemplate
                .withBasicAuth(Admin_Username, Admin_Password).getForEntity(urlGetAllIssues, Set.class);

        System.out.printf(setResponseEntity.getBody().size()+"");

        assertEquals(setResponseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(setResponseEntity);


    }
}