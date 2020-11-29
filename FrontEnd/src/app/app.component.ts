import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from './shared/session.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ADP-Audit';

  constructor(private router:Router, private sessionService:SessionService){

  }

  onLogout()
  {
    this.sessionService.isLoggedIn = false;
    this.sessionService.loggedInUser = null;
    this.sessionService.userType = '';
    this.router.navigate(['login']);
  }
}
