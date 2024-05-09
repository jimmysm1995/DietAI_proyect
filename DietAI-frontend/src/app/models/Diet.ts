import { User } from "./User";
import { Allergy } from './Allergy';

export class Diet {
    idDiet?: number = 0;
    name: string = '';
    calories?: number = 0;
    allergy?: Allergy[] = [];
}