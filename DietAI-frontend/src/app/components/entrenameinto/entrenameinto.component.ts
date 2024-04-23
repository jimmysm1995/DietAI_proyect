import { Component } from '@angular/core';
import { TrainingService } from 'src/app/services/training.service';
import { Training, TrainingResponse } from 'src/app/models/Training';
import { FilterTrainingPipe } from './entrenamientoPipe';

@Component({
  selector: 'app-entrenameinto',
  templateUrl: './entrenameinto.component.html',
  styleUrls: ['./entrenameinto.component.css']
})
export class EntrenameintoComponent {
  public trainings: TrainingResponse[] =[];
  public dias: number[]=[];
  constructor( private trainingService: TrainingService){ 
  }

  verEntrenamiento(){
    this.trainingService.getById(1).then((trainings) => {
      this.dias = trainings.map((training) => training.orderWeek).filter((valor, indice, array) => {
        return array.indexOf(valor) === indice;
      }).sort();
      this.trainings = trainings
    })
  }

}
