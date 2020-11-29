import { Injectable } from '@angular/core';
import { AccountModel } from '../models/account.model';

@Injectable({providedIn:'root'})
export class SessionService{
    isLoggedIn = false;
    userType = null;
    loggedInUser:AccountModel;
}