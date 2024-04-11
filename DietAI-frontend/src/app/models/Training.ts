import { User } from "./User";
import { Client } from "./Client";
import { TypeTraining } from "./Exercise";

export class Training {
    idTraining: number=0;
    name: string = '';
    typeTraining: number=0;
    difficulty: number=0;
    days: number=0;
    distribution: string='';
    clients?: Client[]=[]; 
}

export class TrainingRequest{
    training: Training = new Training();
}