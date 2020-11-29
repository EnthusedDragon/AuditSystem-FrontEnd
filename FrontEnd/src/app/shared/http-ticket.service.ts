import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TicketModel } from '../models/ticket.mode';

@Injectable({providedIn: 'root'})
export class HttpTicketDetailsService{
    constructor(private httpClient: HttpClient){}

    create(issue:TicketModel){
        let url = 'http://localhost:8080/ticket/create';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.post<TicketModel>(url, issue,
            {
                headers: headers
            });
    }

    getAll()
    {
        let url = 'http://localhost:8080/ticket/all';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.get<TicketModel[]>(url,
        {
            headers: headers
        });
    }
}