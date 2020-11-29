package com.group12.controller.issue;

import com.group12.entity.Issue;
import com.group12.factory.IssueFactory;
import com.group12.service.issue.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/issue")
@CrossOrigin(origins = "*")
public class IssueController {

    //create, read, update, delete

    @Autowired
    private IssueService issueService;

    @PostMapping(value = "/createIssue", consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<Issue> createIssue(@RequestBody Issue requestIssue) {


        Issue responseIssue = null;
        Issue issue = IssueFactory.createIssue(requestIssue.getIssueArea(), requestIssue.getIssueDescription(), requestIssue.getDepartment().getDepid(), requestIssue.getRaisedByUser());

        if(issue.getIssueArea() != null && issue.getIssueDescription() != null) {

            try {

                responseIssue = issueService.create(issue);

            } catch (Exception e) {

                System.out.printf(e.getMessage());
            }

        }
        return ResponseEntity.ok(responseIssue);
    }

    @GetMapping(value = "/readIssue")
    public ResponseEntity<Issue> readIssue(@RequestParam String issueID){

        Issue issue = null;

            issue = issueService.read(issueID);

            if(issue != null){

                return ResponseEntity.ok(issue);
            }else
                return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/updateIssue")
    public ResponseEntity<Issue> updateIssue(@RequestBody Issue issue){

        Issue issue1 = issueService.update(issue);

        if(issue != null){

            return ResponseEntity.ok(issue1);

        }else{

            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping(value = "/deleteIssue")
    public ResponseEntity<Boolean> deleteIssue(@RequestParam String issueID){

        try {
            boolean isDeleted = false;

            if (issueID != null) {

                ResponseEntity<Issue> receivedIssue = readIssue(issueID);
                String receivedIssueID = receivedIssue.getBody().getIssueID();

                if(receivedIssueID != null) {

                    isDeleted = issueService.delete(receivedIssueID);
                    return ResponseEntity.ok(isDeleted);
                }else {

                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }

            } else return new ResponseEntity(HttpStatus.NOT_FOUND);

        }catch (Exception e){

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/resolveIssue")
    public ResponseEntity<Issue> resolveIssue(@RequestParam String issueID){

        Issue resolvedIssue = issueService.read(issueID);

        issueService.resolveIssue(resolvedIssue.getIssueID());

        if(resolvedIssue != null){

            return ResponseEntity.ok(resolvedIssue);

        }else return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    //validate, open, close, getAll

    @PutMapping(value = "/validateIssue")
    public ResponseEntity<Issue> validateIssue(@RequestParam String issueID){

        Issue validatedIssue = issueService.read(issueID);

        issueService.validateIssue(validatedIssue.getIssueID());

        if(validatedIssue != null && validatedIssue.getIsResolved() == true){

            return ResponseEntity.ok(validatedIssue);

        }else return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/openIssue")
    public ResponseEntity<Issue> openIssue(@RequestParam String issueID){

        Issue openedIssue = issueService.read(issueID);
        issueService.openIssue(issueID);

        if(openedIssue != null){

            return ResponseEntity.ok(openedIssue);

        }else return new ResponseEntity(HttpStatus.NOT_FOUND);


    }

    @PutMapping(value = "/closeIssue")
    public ResponseEntity<Issue> closeIssue(@RequestParam String issueID){

        Issue closedIssue = issueService.read(issueID);

        issueService.closeIssue(issueID);

        if(closedIssue != null){

            return ResponseEntity.ok(closedIssue);

        }else return new ResponseEntity(HttpStatus.NOT_FOUND);


    }

    @GetMapping(value = "/getAllIssues")
    public ResponseEntity<Set<Issue>> getAllIssues(){

        Set<Issue> issueSet = issueService.getAll();

        if(issueSet != null){

            return ResponseEntity.ok(issueSet);

        }else return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

}
