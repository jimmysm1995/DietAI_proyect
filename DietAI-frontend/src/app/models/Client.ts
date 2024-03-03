import { Diet } from './Diet';
import { Training } from './Training';
import { User } from './User';

export class Client {
    name?: string;
    lastName?: string;
    birthDate?: Date;
    plan?: string;
    gender?: string;
    weight?: number;
    height?: number;
    goal?: string;
    injuries?: string;
    jobType?: string;
    previousLevel?: string;
    consumedSubstances?: string;
    trainingTime?: number;
    dietAndExerciseFrequency?: string;
    user?: User;
    training?: Training;
    diet?: Diet;
}