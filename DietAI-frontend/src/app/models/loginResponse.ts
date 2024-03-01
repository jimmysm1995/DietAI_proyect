import { User } from './User';

export class LoginResponse { 
    token: string = '';
    authorities: string[] = [];
    username:string = '';
}