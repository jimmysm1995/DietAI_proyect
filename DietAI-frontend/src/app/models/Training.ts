import { User } from "./User";
import { Client } from "./Client";
import { TypeTraining } from "./Exercise";
import { Exercise } from "./Exercise";

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

export class TrainingResponse{
    sets: number=0;
    reps: number=0;
    orderDay: number=0;
    orderWeek: number=0;
    exercise: Exercise = new Exercise();
}

