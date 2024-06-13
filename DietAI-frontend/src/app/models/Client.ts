import { Allergy } from './Allergy';
import { ConsumedSubstances } from './ConsumedSubstances';
import { Diet } from './Diet';
import { TypeTraining } from './Exercise';
import { Gender } from './Gender';
import { Goal } from './Goal';
import { Injury } from './Injury';
import { JobType } from './JobType';
import { PreviusLevel } from './PreviusLevel';
import { Training } from './Training';
import { User } from './User';

export class Client {
    idClient?: number = 0;
    birthDate?: Date;
    plan?: string = "";
    gender?: string = "";
    weight?: number = 0;
    height?: number = 0;
    goal?: string = "";
    injury?: Injury[];
    allergy?: Allergy[];
    jobType?: string = "";
    previousLevel?: string = "";
    consumedSubstances?: string = "";
    trainingTime?: number = 1;
    typeTraining?: string = "";
    user?: User;
    training?: Training;
    diet?: Diet;
}