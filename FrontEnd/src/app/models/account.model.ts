import { DepartmentModel } from './department.model';

export class AccountModel{
    id:string;
    firstName:string;
    surname:string;
    email:string;
    password:string;
    cellphone:string;
    loginStatus:boolean;
    registerDate: Date;
    department?:DepartmentModel;
}