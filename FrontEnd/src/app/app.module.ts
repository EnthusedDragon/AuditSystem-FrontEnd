import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DropdownDirective } from './shared/dropdown.directive';
import { StaffDashboardComponent } from './staff-dashboard/staff-dashboard.component';
import { AuditorDashboardComponent } from './auditor-dashboard/auditor-dashboard.component';
import { RaiseIssueComponent } from './raise-issue/raise-issue.component';
import { ViewIssueComponent } from './view-issue/view-issue.component';
import { CreateReportComponent } from './create-report/create-report.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { FacultiesEditComponent } from './faculties-edit/faculties-edit.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddFacultyComponent } from './add-faculty/add-faculty.component';
import { AddDepartmentComponent } from './add-department/add-department.component';
import { AdminComponent } from './admin/admin.component';
import { ViewIssuesComponent } from './view-issues/view-issues.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DropdownDirective,
    StaffDashboardComponent,
    AuditorDashboardComponent,
    RaiseIssueComponent,
    ViewIssueComponent,
    CreateReportComponent,
    FacultiesComponent,
    FacultiesEditComponent,
    DashboardComponent,
    AddFacultyComponent,
    AddDepartmentComponent,
    AdminComponent,
    ViewIssuesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
