import { Client } from "./Client";

export class User {
  idUser?: number = 0;
  username: string = "";
  email: string = "";
  password: string = "";
  client?: Client;
  img: string='';
  
}