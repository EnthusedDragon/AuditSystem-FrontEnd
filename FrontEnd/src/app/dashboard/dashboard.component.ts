import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from '../shared/session.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  accountType = null;

  constructor(private sessionService:SessionService, private routing: Router) { }

  ngOnInit(): void {
    this.accountType = this.sessionService.userType;
    if(this.accountType === null)
      this.routing.navigate(['login']);
  }
}
