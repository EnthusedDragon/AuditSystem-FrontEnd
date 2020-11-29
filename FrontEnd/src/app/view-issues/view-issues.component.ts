import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IssueModel } from '../models/issue.model';
import { HttpIssueDetailsService } from '../shared/http-issue.service';
import { SessionService } from '../shared/session.service';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;

@Component({
  selector: 'app-view-issues',
  templateUrl: './view-issues.component.html',
  styleUrls: ['./view-issues.component.css']
})
export class ViewIssuesComponent implements OnInit {
  issues:IssueModel[] = [];

  constructor(private httpIssuesService:HttpIssueDetailsService, private sessionService:SessionService, private router:Router) { }

  ngOnInit(): void {
    if(!this.sessionService.isLoggedIn)
    {
      this.router.navigate(['login']);
    }

    this.httpIssuesService.getAll().subscribe(result=>
    {
      this.issues = result;
      console.log(result);
    });
  }

  onSelect(issueID:string)
  {
    this.router.navigate(['issue/'+issueID]);
  }

  onBack(){
    this.router.navigate(['dashboard']);
  }
  generatePdf(){
    let body = [
      ['Issue Area', 'Faculty', 'Department', 'Resolved', 'Resolved Date', 'Validated', 'Raised By', 'Raised Date']
    ];

    this.issues.forEach(issue => {
      let resDate = issue.issueResolvedDate === null ? '':issue.issueResolvedDate.toString();
      body.push([issue.issueArea, issue.department.faculty.facultyName, issue.department.depName, issue.isResolved ? 'RESOLVED':'NOT RESOLVED', resDate, issue.isValidated ? 'VALIDATED':'NOT VALIDATED', issue.raisedByUser.firstName + ' ' + issue.raisedByUser.surname, issue.issueRaisedDate.toString()]);
    });

    const docDefinition = {
      content: [
        {
          text:'Report',
          style:['heading']
        },        
        {
          layout: 'lightHorizontalLines', // optional
          table: {
            headerRows: 1,    
            body: body
          },
          style:['table']
        }
      ],
      pageSize: 'A4',
      styles:{
        table: {
          fontSize: 8,
          alignment: 'left',
          color: 'black',
          margin: [0, 5, 0, 15]
        },
        heading: {
          fontSize: 18,
          alignment: 'center',
          color: 'black'
        }
      }
    };
    
    pdfMake.createPdf(docDefinition).open();
   }
}
