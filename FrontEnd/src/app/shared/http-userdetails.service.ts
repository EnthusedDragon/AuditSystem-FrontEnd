import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountModel } from '../models/account.model';
import { SessionService } from '../shared/session.service';

@Injectable({providedIn: 'root'})
export class HttpUserDetailsService{
    constructor(private httpClient: HttpClient, private sessionService:SessionService){}

    get(id:string, accountType:string){
        let url = '';

        if(accountType==='auditor')
        {
            url = 'http://localhost:8080/AuditSystem/auditor/read/';
        }else if(accountType==='staff')
        {
            url = 'http://localhost:8080/AuditSystem/universityStaff/read/';
        }

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.get<AccountModel>(url+id, 
            {
                headers: headers
            });
    }
}