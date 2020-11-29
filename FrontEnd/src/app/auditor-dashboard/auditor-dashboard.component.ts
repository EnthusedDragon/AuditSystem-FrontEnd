import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from '../shared/session.service';

@Component({
  selector: 'app-auditor-dashboard',
  templateUrl: './auditor-dashboard.component.html',
  styleUrls: ['./auditor-dashboard.component.css']
})
export class AuditorDashboardComponent implements OnInit {

  constructor(private router:Router, private sessionService:SessionService) { }

  ngOnInit(): void {
    if(!this.sessionService.isLoggedIn)
    {
      this.router.navigate(['login']);
    }
  }

  onRaiseIssue()
  {
    this.router.navigate(['issue/raise']);
  }

  onViewIssue(){
    this.router.navigate(['issues']);
  }
}
