import { User } from "./User";

export class Diet {
    name: string = '';
    difficulty?: number;
    days?: number;
    distribution?: string;
    usuarios?: User[];
    idDiet?: number = 0;
}