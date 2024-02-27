import { User } from './User';

export class LoginResponse { 
    token: string = '';
    authorities: string[] = [];
    user:User = new User();
}