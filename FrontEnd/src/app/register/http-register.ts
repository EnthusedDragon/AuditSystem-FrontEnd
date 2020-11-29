import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountModel } from '../models/account.model';
import { DepartmentModel } from '../models/department.model';
import { SessionService } from '../shared/session.service';

@Injectable({providedIn: 'root'})
export class HttpRegisterService{
    constructor(private httpClient: HttpClient, private sessionService:SessionService){}

    register(newAccount:AccountModel,accountType:string){
        let deptId = newAccount.department;

        let department = new DepartmentModel();
        department.depid = String(deptId);
        newAccount.department = department;
        let url = '';

        if(accountType==='auditor')
        {
            url = 'http://localhost:8080/AuditSystem/auditor/create';
        }else if(accountType==='staff')
        {
            url = 'http://localhost:8080/AuditSystem/universityStaff/create';
        }

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        this.httpClient
        .post<AccountModel>(url, newAccount,
        {
            headers: headers
        })
        .subscribe(result =>{
            console.log(result);
        });
    }
}