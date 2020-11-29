import { AccountModel } from './account.model';
import { DepartmentModel } from './department.model';

export class IssueModel{
    issueID:string;
    issueRaisedDate:Date;
    issueArea:string;
    issueStatus:boolean;
    isResolved:boolean;
    isValidated:boolean;
    issueDescription:string;
    issueResolvedDate:Date;
    department:DepartmentModel;
    raisedByUser:AccountModel;
}