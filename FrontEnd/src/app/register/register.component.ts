import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DepartmentModel } from '../models/department.model';
import { HttpDepartmentDetailsService } from '../shared/http-department.service';
import { HttpRegisterService } from './http-register';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  departments:DepartmentModel[]=[];

  constructor(private route: ActivatedRoute, private router:Router, private httpRegisterService:HttpRegisterService, private httpDepartmentService:HttpDepartmentDetailsService) { }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      'firstName': new FormControl(null, Validators.required),
      'surname': new FormControl(null, Validators.required),
      'cellPhone': new FormControl(null, Validators.required),
      'email': new FormControl(null, Validators.required),
      'confirmEmail': new FormControl(null, Validators.required),
      'password': new FormControl(null, Validators.required),
      'confirmPassword': new FormControl(null, Validators.required),
      'accountType': new FormControl('auditor', Validators.required),
      'department': new FormControl(null, Validators.required)
    });

    this.httpDepartmentService.getAll().subscribe(result=>
      {
        console.log(result);
        this.departments = result;
        this.registerForm.controls['department'].setValue(result[0].depid);
        
      });
  }

  onCancel(){
    this.router.navigate(['login']);
  }

  onRegister()
  {
    this.httpRegisterService.register(this.registerForm.value, this.registerForm.value.accountType)
    this.onCancel();
  }
}
