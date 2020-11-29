import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FacultyModel } from '../models/faculty.model';

@Injectable({providedIn: 'root'})
export class HttpFacultyDetailsService{
    constructor(private httpClient: HttpClient){}

    create(faculty:FacultyModel){
        return this.createAdmin(faculty, 'Boss', '123');
    }

    createAdmin(faculty:FacultyModel, username:string, password:string){
        let url = 'http://localhost:8080/AuditSystem/faculty/create';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa(username+':'+password));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.post<FacultyModel>(url, faculty,
        {
            headers: headers
        });
    }

    getAll(){
        let url = 'http://localhost:8080/AuditSystem/faculty/getAll';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.get<FacultyModel[]>(url, 
        {
            headers: headers
        });
    }
}