import { User } from './User';

export class LoginResponse { 
    username:string = '';
    idUser: number = 0;
    authorities: string[] = [];
    token: string = '';
}