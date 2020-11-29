import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpUserDetailsService } from '../shared/http-userdetails.service';
import { SessionService } from '../shared/session.service';
import { HttpLoginService } from './http-login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private route: ActivatedRoute, private router:Router, private httpLogin:HttpLoginService, private sessionService:SessionService, private httpUserDetail:HttpUserDetailsService) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      'email': new FormControl(null, Validators.required),
      'password': new FormControl(null, Validators.required),
      'accountType': new FormControl('auditor', Validators.required)
    });
  }

  onRegister(){
    this.router.navigate(['register']);
  }

  onLogin(){
    this.httpLogin.login(this.loginForm.value.email,this.loginForm.value.password,this.loginForm.value.accountType)
      .subscribe(result =>{
        this.sessionService.isLoggedIn = result !== null && result !== '';
        console.log(result);
        if(this.sessionService.isLoggedIn)
        {
          console.log(result);
            this.sessionService.userType = this.loginForm.value.accountType;
            this.httpUserDetail.get(result, this.loginForm.value.accountType).subscribe(result=>{
                this.sessionService.loggedInUser = result;
            });
            this.router.navigate(['dashboard']);
        }
    });
  }
  onAddFaculty()
  {
    this.router.navigate(['faculties/admin']);
  }
  onAddDepartment(){
    this.router.navigate(['departments/admin']);
  }
}
