package com.group12.service.issue.impl;

import com.group12.entity.Issue;
import com.group12.repository.issue.IssueRepository;
import com.group12.service.issue.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Set<Issue> getAll() {

        return this.issueRepository.findAll().stream().collect(Collectors.toSet());
    }

    //issueStatus true=open
    @Override
    public Issue resolveIssue(String issueID) {

        Issue resolvedIssue = null;

        try {

            if (this.issueRepository.existsById(issueID)) {

                Issue issueToResolve = this.issueRepository.getOne(issueID);

                    resolvedIssue = new Issue.Builder().copy(issueToResolve)
                            .setIsResolved(true)
                            .setIssueResolvedDate(LocalDateTime.now())
                            .build();

                    this.issueRepository.save(resolvedIssue);

            }

        }catch (Exception e){

            System.out.print(e.getCause());
        }

        return resolvedIssue;
    }

    @Override
    public Issue validateIssue(String issueID) {

        Issue validatedIssue = null;


        try {

            if (this.issueRepository.existsById(issueID)) {

                Issue issue = this.issueRepository.getOne(issueID);

                if (issue.getIsResolved() == true) {

                    validatedIssue = new Issue.Builder().copy(issue)
                            .setIsValidated(true)
                            .build();

                    this.issueRepository.save(validatedIssue);

                }else return null;

            } else return null;

        }catch (Exception e){

            System.out.printf(e.getMessage());
        }
        return validatedIssue;
    }

    @Override
    public Issue openIssue(String issueID) {

        Issue openedIssue = null;
        Issue issue = this.issueRepository.getOne(issueID);

        if( issue != null && issue.getIssueStatus() == false){

            openedIssue = new Issue.Builder().copy(issue)
                    .setIssueStatus(true)
                    .setIssueRaisedDate(LocalDateTime.now())
                    .build();

            this.issueRepository.save(openedIssue);
        }

        return openedIssue;
    }

    @Override
    public Issue closeIssue(String issueID) {

        Issue closedIssue = null;
        Issue issue = this.issueRepository.getOne(issueID);

        if(issue.getIsValidated() == true){

            closedIssue = new Issue.Builder().copy(issue)
                    .setIssueStatus(false)
                    .build();

            this.issueRepository.save(closedIssue);
        }

        return closedIssue;
    }

    @Override
    public Issue create(Issue t) {
        return this.issueRepository.save(t);
    }

    @Override
    public Issue read(String id) {
        return this.issueRepository.findById(id).orElse(null);
    }

    @Override
    public Issue update(Issue t) {

        if(this.issueRepository.existsById(t.getIssueID())) return this.issueRepository.save(t);
           else return null;

    }

    @Override
    public boolean delete(String id) {

        this.issueRepository.deleteById(id);

        if(this.issueRepository.existsById(id)) return false;
        else return true;

    }
}
