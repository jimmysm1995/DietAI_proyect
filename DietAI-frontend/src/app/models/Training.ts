import { User } from "./User";
import { Client } from "./Client";
import { TrainingExercise } from "./Exercise";
import { TypeTraining } from "./Exercise";

export class Training {
    name: string = '';
    idTraining: number=0;
    typeTraining: TypeTraining=new TypeTraining();
    difficulty: number=0;
    days: number=0;
    distribution: string='';
    clients?: Client[]=[]; 
    trainingExercises?: TrainingExercise[];
}