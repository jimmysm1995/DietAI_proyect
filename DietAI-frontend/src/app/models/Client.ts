import { Diet } from './Diet';
import { Training } from './Training';
import { User } from './User';

export class Client {
    name?: string = "";
    lastName?: string = "";
    birthDate?: Date | null = null;
    plan?: string = "";
    gender?: string = "";
    weight?: number = 0;
    height?: number = 0;
    goal?: string = "";
    injuries?: string = "";
    allergy?: string = "";
    jobType?: string = "";
    previousLevel?: string = "";
    consumedSubstances?: string = "";
    trainingTime?: number = 0;
    dietAndExerciseFrequency?: string = "";
    user?: User;
    training?: Training;
    diet?: Diet;
}