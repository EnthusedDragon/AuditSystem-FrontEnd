package com.group12.service.issue;

import com.group12.entity.Auditor;
import com.group12.entity.Issue;
import com.group12.entity.UniversityStaff;
import com.group12.entity.UserAccount;
import com.group12.service.IService;

import java.util.Set;

public interface IssueService extends IService<Issue, String> {

    Set<Issue> getAll();

    Issue resolveIssue(String issueID);

    Issue validateIssue(String issueID);

    Issue openIssue(String issueID);

    Issue closeIssue(String issueID);


}
