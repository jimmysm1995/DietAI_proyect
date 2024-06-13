import { User } from "./User";
import { Client } from "./Client";
import { TypeTraining } from "./Exercise";
import { Exercise } from "./Exercise";

export class Training {
    idTraining: number=0;
    name: string = '';
    typeTraining: string = '';
    difficulty: number=1;
    days: number=1;
    distribution: string='';
    clients?: Client[]=[]; 
}

export class TrainingRequest{
    training: Training = new Training();
}

export class TrainingResponse{
    sets: number=1;
    reps: number=1;
    orderDay: number=1;
    orderWeek: number=1;
    exercise: Exercise = new Exercise();
}

