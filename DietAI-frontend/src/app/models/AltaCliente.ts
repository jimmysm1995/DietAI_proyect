import { Training } from './Training';
import { Gender } from './Gender';
import { JobType } from './JobType';
import { ConsumedSubstances } from './ConsumedSubstances';
import { Goal } from './Goal';
import { PreviusLevel } from './PreviusLevel';
import { Allergy } from './Allergy';
import { Injury } from './Injury';

export class AltaCliente {

    idClient: number = 0;

    birthday: Date = new Date();

    gender: Gender = new Gender();

    height: number = 0;

    weight: number =0;

    goal: Goal = new Goal();

    jobType: JobType = new JobType();

    previusLevel: PreviusLevel = new PreviusLevel();

    consumedSubstances: ConsumedSubstances = new ConsumedSubstances();

    allergy: Allergy = new Allergy();

    injury: Injury = new Injury();

    trainingTime: number = 0;

    plan: string = "";


    //  dietAndExerciseFrequency: DietAndExerciseFrequency;

    //  training: Training;
}
