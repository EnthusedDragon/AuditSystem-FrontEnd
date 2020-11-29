import { AccountModel } from './account.model';
import { IssueModel } from './issue.model';

export class TicketModel {
    ticketId:string;
    ticketDesc:string;
    ticketDate:Date;
    issue:IssueModel;
    createdByUser:AccountModel;
}