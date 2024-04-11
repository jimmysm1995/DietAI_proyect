import { ExerciseInTraining } from "./ExercisesInTraining";
import { Training } from "./Training";

export class TrainingWithExercisesRequest {
    training? : Training = new Training();
    exercisesInTraining: ExerciseInTraining[]=[];
}