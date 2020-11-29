import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { IssueModel } from '../models/issue.model';
import { TicketModel } from '../models/ticket.mode';
import { HttpIssueDetailsService } from '../shared/http-issue.service';
import { HttpTicketDetailsService } from '../shared/http-ticket.service';
import { SessionService } from '../shared/session.service';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;

@Component({
  selector: 'app-view-issue',
  templateUrl: './view-issue.component.html',
  styleUrls: ['./view-issue.component.css']
})
export class ViewIssueComponent implements OnInit {
  issue:IssueModel = null;
  tickets:TicketModel[]=[];
  form: FormGroup;

  constructor(private route: ActivatedRoute, private router:Router, private httpIssueServuce:HttpIssueDetailsService, private sessionService: SessionService, private httpTicketServuce:HttpTicketDetailsService) { }

  ngOnInit(): void {
    if(!this.sessionService.isLoggedIn)
    {
      this.router.navigate(['login']);
    }

    this.form = new FormGroup({
      'newTicket': new FormControl(null, Validators.required),      
    });
    
    this.route.params.subscribe(
      (params:Params)=>
      {
        this.httpIssueServuce.get(params['id']).subscribe(result=>
          {
            console.log(result);
            this.issue = result;
            this.httpTicketServuce.getAll().subscribe(tickets=>{
              tickets.forEach(ticket => {
                if(ticket.issue.issueID === this.issue.issueID)
                  this.tickets.push(ticket);
              });
              console.log(tickets);
            });       
          });
      }
    );
    
  }

  onBack()
  {
    this.router.navigate(['issues']);
  }

  onCreateTicket(){
    let newTicket = new TicketModel();
    console.log(this.sessionService.loggedInUser);
    newTicket.createdByUser = this.sessionService.loggedInUser;
    newTicket.issue = this.issue;
    newTicket.ticketDesc = this.form.value.newTicket;

    this.httpTicketServuce.create(newTicket).subscribe(ticket=>{
      this.tickets.push(ticket);
      this.form.reset();
    });   
  }

  onValidate(){
    this.httpIssueServuce.validate(this.issue.issueID).subscribe(result=>{
      this.issue = result;
    });
  }

  onResolve(){
    this.httpIssueServuce.resolve(this.issue.issueID).subscribe(result =>{
      this.issue = result;
    });
  }

  generatePdf(){
    
    let docDefinition = {
      content: [
        {
          text:'Issue Report',
          style:['heading']
        },
        {
          text:'Issue Raised Date',
          style:['subheading']
        },
        {
          text: this.issue.issueRaisedDate,
          style:['content']
        },
        {
          text:'Raised By',
          style:['subheading']
        },
        {
          text: this.issue.raisedByUser.firstName + ' ' + this.issue.raisedByUser.surname,
          style:['content']
        },
        {
          text:'Issue Area',
          style:['subheading']
        },
        {
          text: this.issue.issueArea,
          style:['content']
        },
        {
          text:'Issue Faculty',
          style:['subheading']
        },
        {
          text: this.issue.department.faculty.facultyName,
          style:['content']
        },
        {
          text:'Issue Department',
          style:['subheading']
        },
        {
          text: this.issue.department.depName,
          style:['content']
        },
        {
          text:'Resolved Status',
          style:['subheading']
        },
        {
          text: this.issue.isResolved ? 'RESOLVED':'NOT RESOLVED',
          style:['content']
        },
        {
          text:'Resolved Date',
          style:['subheading']
        },
        {
          text: this.issue.issueResolvedDate === null ? '':this.issue.issueResolvedDate.toString(),
          style:['content']
        },
        {
          text:'Validated',
          style:['subheading']
        },
        {
          text: this.issue.isValidated? 'VALIDATED':'NOT VALIDATED',
          style:['content']
        },
        {
          text:'Issue Description',
          style:['subheading']
        },
        {
          text: this.issue.issueDescription,
          style:['content']
        }
        
      ],
      pageSize: 'A4',
      styles:{
        heading: {
          fontSize: 18,
          alignment: 'center',
          color: 'black'
        },
        subheading: {
          fontSize: 12,
          alignment: 'left',
          color: 'black',
          margin:[0,25,0,0]
        },
        content: {
          fontSize: 8,
          alignment: 'left',
          color: 'black'
        }
      }
    };

    this.tickets.forEach(ticket => {
      docDefinition.content.push(
        {
          text:'Ticket by '+ticket.createdByUser.firstName + ' ' + ticket.createdByUser.surname  +' @ '+ ticket.ticketDate,
          style: ['subheading']
        }
      );
      docDefinition.content.push(
        {
          text: ticket.ticketDesc,
          style: ['content']
        }
      );
    });
    
    pdfMake.createPdf(docDefinition).open();
   }
}
