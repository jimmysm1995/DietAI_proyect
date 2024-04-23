import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'filterTraining',
})
export class FilterTrainingPipe implements PipeTransform {
    transform(trainings: any[], dia: number): any[] {
        if (!trainings || !dia) {
            return trainings;
        }
        return trainings.filter((training) => training.orderWeek === dia);
    }
}
