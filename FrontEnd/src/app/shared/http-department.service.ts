import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DepartmentModel } from '../models/department.model';

@Injectable({providedIn: 'root'})
export class HttpDepartmentDetailsService{
    constructor(private httpClient: HttpClient){}

    create(department:DepartmentModel){
        return this.createAdmin(department, 'Boss', '123');
    }

    createAdmin(department:DepartmentModel, username:string, password:string){
        let url = 'http://localhost:8080/AuditSystem/department/create';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa(username+':'+password));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.post<DepartmentModel>(url, department,
        {
            headers: headers
        });
    }

    getAll(){
        let url = 'http://localhost:8080/AuditSystem/department/getAll';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.get<DepartmentModel[]>(url, 
        {
            headers: headers
        });
    }
}