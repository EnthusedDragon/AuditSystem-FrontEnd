import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DepartmentModel } from '../models/department.model';
import { FacultyModel } from '../models/faculty.model';
import { IssueModel } from '../models/issue.model';
import { HttpDepartmentDetailsService } from '../shared/http-department.service';
import { HttpIssueDetailsService } from '../shared/http-issue.service';
import { SessionService } from '../shared/session.service';

@Component({
  selector: 'app-raise-issue',
  templateUrl: './raise-issue.component.html',
  styleUrls: ['./raise-issue.component.css']
})
export class RaiseIssueComponent implements OnInit {

  form: FormGroup;
  departments:DepartmentModel[]=[];

  constructor(private route: ActivatedRoute, private router:Router, private httpDepartmentService:HttpDepartmentDetailsService, private httpIssueServuce:HttpIssueDetailsService, private sessionService: SessionService) { }

  ngOnInit(): void {
    if(!this.sessionService.isLoggedIn)
    {
      this.router.navigate(['login']);
    }

    this.form = new FormGroup({
      'issueArea': new FormControl(null, Validators.required),
      'issueDescription': new FormControl(null, Validators.required),
      'department': new FormControl(null, Validators.required)
    });

    this.httpDepartmentService.getAll().subscribe(result=>
      {
        console.log(result);
        this.departments = result;
        this.form.controls['department'].setValue(result[0].depid);
        
      });
  }

  onCancel(){
    this.router.navigate(['dashboard']);
  }

  onSubmit()
  {
    let issue = new IssueModel();
    issue.issueArea = this.form.value.issueArea;
    issue.issueDescription = this.form.value.issueDescription;
    
    this.departments.forEach(dep => {
      if(dep.depid === this.form.value.department)
      {
        issue.department = dep;
      }
    }); 

    issue.raisedByUser = this.sessionService.loggedInUser;

    this.httpIssueServuce.raise(issue).subscribe(
      result=>
      {
        console.log(result);
        this.onCancel();
      }
    );
  }

}
