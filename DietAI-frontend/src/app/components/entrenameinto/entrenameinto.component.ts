import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/app/services/training.service';
import { Training, TrainingResponse } from 'src/app/models/Training';
import { FilterTrainingPipe } from './entrenamientoPipe';
import { ClientStore } from 'src/app/store/clientStore';
import { Client } from '../../models/Client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-entrenameinto',
  templateUrl: './entrenameinto.component.html',
  styleUrls: ['./entrenameinto.component.css']
})
export class EntrenameintoComponent {
  public training : TrainingResponse = new TrainingResponse();
  public trainings: TrainingResponse[] =[];
  public dias: number[]=[];
  constructor( 
    private trainingService: TrainingService,
    private clientStore: ClientStore,
    private clientService: ClientService
  ){ 
  }

  ngOnInit(): void {
    this.clientService.getTrainingByClient(this.clientStore.client.idClient || 0).then((training) => {
      this.trainingService.getById(training.idTraining || 0).then((trainings) => {
        this.dias = trainings.map((training) => training.orderWeek).filter((valor, indice, array) => {
          return array.indexOf(valor) === indice;
        }).sort();
        this.trainings = trainings
      })
    })
  }

  mostrarEntrenamiento(training: TrainingResponse){
    this.training = training
  }

}
