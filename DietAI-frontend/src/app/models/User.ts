import { Client } from "./Client";

export class User {
  username: string = "";
  email: string = "";
  password: string = "";
  client?: Client;
}