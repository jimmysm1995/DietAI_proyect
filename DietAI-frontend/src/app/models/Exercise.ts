export class Exercise {
    name: string = '';
    muscles?: MuscleInExercise[];
    difficult?: number;
    explanation?: string;
}

export class MuscleInExercise {
    muscle: Muscle = new Muscle();
}

export class Muscle{
    name: string = '';
    idMuscle?: number;
}