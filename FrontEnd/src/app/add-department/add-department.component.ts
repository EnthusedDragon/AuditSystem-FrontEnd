import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DepartmentModel } from '../models/department.model';
import { FacultyModel } from '../models/faculty.model';
import { HttpDepartmentDetailsService } from '../shared/http-department.service';
import { HttpFacultyDetailsService } from '../shared/http-faculty.service';

@Component({
  selector: 'app-add-department',
  templateUrl: './add-department.component.html',
  styleUrls: ['./add-department.component.css']
})
export class AddDepartmentComponent implements OnInit {
  form: FormGroup;
  faculties:FacultyModel[] = [];
  constructor(private router:Router, private httpDepartmentService:HttpDepartmentDetailsService, private httpFacultyService:HttpFacultyDetailsService) { }

  setForm()
  {
    this.form = new FormGroup({
      'username': new FormControl(null, Validators.required),
      'password': new FormControl(null, Validators.required),
      'depName': new FormControl(null, Validators.required),
      'faculty': new FormControl(null, Validators.required)
    });
  }

  ngOnInit(): void {
    
    this.setForm();
    this.httpFacultyService.getAll().subscribe
    (
      result=> {
        console.log(result);
        this.faculties = result;
        this.form.controls['faculty'].setValue(result[0].facultyId);
        
      });
  }

  onCancel(){
    this.router.navigate(['login']);
  }

  onSubmit(){
    let department = new DepartmentModel();
    department.depName = this.form.value.depName;
    let faculty = new FacultyModel();
    faculty.facultyId = this.form.value.faculty;
    department.faculty = faculty;

    this.httpDepartmentService.createAdmin(department, this.form.value.username, this.form.value.password).subscribe(result=>
      {
        console.log(result);
        this.router.navigate(['login']);
      });
  }
}
