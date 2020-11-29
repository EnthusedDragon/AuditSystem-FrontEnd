import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IssueModel } from '../models/issue.model';

@Injectable({providedIn: 'root'})
export class HttpIssueDetailsService{
    constructor(private httpClient: HttpClient){}

    raise(issue:IssueModel){
        let url = 'http://localhost:8080/issue/createIssue';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.post<IssueModel>(url, issue,
            {
                headers: headers
            });
    }

    getAll()
    {
        let url = 'http://localhost:8080/issue/getAllIssues';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.get<IssueModel[]>(url,
        {
            headers: headers
        });
    }

    get(id:string)
    {
        let url = 'http://localhost:8080/issue/readIssue';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.get<IssueModel>(url,
        {
            params:{
                'issueID':id
            },
            headers: headers
        });
    }

    validate(issueID:string){
        let url = 'http://localhost:8080/issue/validateIssue';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.put<IssueModel>(url, null,
            {
                params:{
                    issueID: issueID
                },
                headers: headers
            });
    }

    resolve(issueID:string){
        let url = 'http://localhost:8080/issue/resolveIssue';

        let headers = new HttpHeaders();
        headers = headers.append('Authorization', 'Basic ' + btoa('Boss:123'));
        headers = headers.append('Access-Control-Allow-Origin','*');

        return this.httpClient.put<IssueModel>(url, null,
            {
                params:{
                    issueID: issueID
                },
                headers: headers
            });
    }
}