import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpUserDetailsService } from '../shared/http-userdetails.service';
import { SessionService } from '../shared/session.service';

@Injectable({providedIn: 'root'})
export class HttpLoginService{
    constructor(private httpClient: HttpClient){}

    login(email:string, password:string, accountType:string){
        let url = '';

        if(accountType==='auditor')
        {
            url = 'http://localhost:8080/AuditSystem/auditor/login';
        }else if(accountType==='staff')
        {
            url = 'http://localhost:8080/AuditSystem/universityStaff/login';
        }

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.get<string>(url, 
            {
                params: {
                    email: email,
                    password: password
                },
                headers: headers,
                responseType: 'text' as 'json'
            });
    }
}