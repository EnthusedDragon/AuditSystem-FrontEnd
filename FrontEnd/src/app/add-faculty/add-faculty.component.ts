import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FacultyModel } from '../models/faculty.model';
import { HttpFacultyDetailsService } from '../shared/http-faculty.service';

@Component({
  selector: 'app-add-faculty',
  templateUrl: './add-faculty.component.html',
  styleUrls: ['./add-faculty.component.css']
})
export class AddFacultyComponent implements OnInit {
  addFacultyForm: FormGroup;
  constructor(private router:Router, private httpFacultyService:HttpFacultyDetailsService) { }

  ngOnInit(): void {
    this.addFacultyForm = new FormGroup({
      'username': new FormControl(null, Validators.required),
      'password': new FormControl(null, Validators.required),
      'facultyName': new FormControl(null, Validators.required)
    });
  }

  onCancel(){
    this.router.navigate(['login']);
  }

  onSubmit(){
    let faculty = new FacultyModel();
    faculty.facultyName = this.addFacultyForm.value.facultyName;
    this.httpFacultyService.createAdmin(faculty, this.addFacultyForm.value.username, this.addFacultyForm.value.password).subscribe(result=>
      {
        console.log(result);
        this.router.navigate(['login']);
      });
  }
}
