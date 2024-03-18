import { Client } from "./Client";

export class User {
  id?: number = 0;
  username: string = "";
  email: string = "";
  password: string = "";
  client?: Client;
  img: string='';
  
}