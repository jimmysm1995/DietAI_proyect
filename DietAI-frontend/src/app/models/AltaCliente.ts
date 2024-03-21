import { Training } from './Training';
import { Gender } from './Gender';
import { JobType } from './JobType';
import { ConsumedSubstances } from './ConsumedSubstances';
import { Goal } from './Goal';
import { PreviusLevel } from './PreviusLevel';

export class AltaClienre {
    gender: Gender = new Gender();

    weight: string = '';

    height: string = '';

    goal: Goal = new Goal();

    jobType: JobType = new JobType();

    previusLevel: PreviusLevel = new PreviusLevel();

    consumedSubstances: ConsumedSubstances = new ConsumedSubstances();

    //   trainingTime: TrainingTime;

    //  dietAndExerciseFrequency: DietAndExerciseFrequency;

    //  training: Training;
}
