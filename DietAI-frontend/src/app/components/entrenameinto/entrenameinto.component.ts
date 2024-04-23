import { Component } from '@angular/core';
import { TrainingService } from 'src/app/services/training.service';

@Component({
  selector: 'app-entrenameinto',
  templateUrl: './entrenameinto.component.html',
  styleUrls: ['./entrenameinto.component.css']
})
export class EntrenameintoComponent {
  constructor( private trainingService: TrainingService){ 
  }

  verEntrenamiento(){
    this.trainingService.getById(1).then((trainings) => {
      
    })
  }

}
