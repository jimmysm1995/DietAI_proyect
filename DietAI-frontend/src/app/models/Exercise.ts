import { Client } from './Client';
import { Training } from './Training';

export class Exercise {
    idExercise: number=0;
    name: string='';
    imgExercise: string='';
    initialPosition: string='';
    execution: string='';
    advices: string='';
    typeTraining: string='';
    muscle?: Muscle[];
}

export class MuscleInExercise {
    muscle: Muscle = new Muscle();
}

export class Muscle{
    name: string = '';
    idMuscle?: number;
}

export class DayOfWeek {
    day: number = 0;
}

export class TypeTraining {
    name: string = '';
}
