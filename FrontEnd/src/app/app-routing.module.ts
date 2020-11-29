import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddDepartmentComponent } from './add-department/add-department.component';
import { AddFacultyComponent } from './add-faculty/add-faculty.component';
import { CreateReportComponent } from './create-report/create-report.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FacultiesEditComponent } from './faculties-edit/faculties-edit.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { LoginComponent } from './login/login.component';
import { RaiseIssueComponent } from './raise-issue/raise-issue.component';
import { RegisterComponent } from './register/register.component';
import { ViewIssueComponent } from './view-issue/view-issue.component';
import { ViewIssuesComponent } from './view-issues/view-issues.component';

const routes: Routes = [
  { path:'', redirectTo:'/login', pathMatch: 'full' },
  { path:'login', component: LoginComponent },
  { path:'register', component: RegisterComponent },
  { path:'dashboard', component: DashboardComponent },
  { path:'issue/raise', component: RaiseIssueComponent },
  { path:'issues', component: ViewIssuesComponent },
  { path:'issue/:id', component: ViewIssueComponent },
  { path:'faculties', component: FacultiesComponent },
  { path:'faculties/admin', component: AddFacultyComponent },
  { path:'faculties/:id', component: FacultiesEditComponent },
  { path:'departments/admin', component: AddDepartmentComponent },
  { path:'report', component: CreateReportComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
