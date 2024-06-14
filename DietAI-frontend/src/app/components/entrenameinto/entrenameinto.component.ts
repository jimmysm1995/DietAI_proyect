import { AfterContentChecked, AfterViewInit, Component } from '@angular/core';
import { TrainingService } from 'src/app/services/training.service';
import { TrainingResponse } from 'src/app/models/Training';
import { ClientService } from 'src/app/services/client.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-entrenameinto',
  templateUrl: './entrenameinto.component.html',
  styleUrls: ['./entrenameinto.component.css']
})
export class EntrenameintoComponent implements AfterViewInit {
  public training: TrainingResponse = new TrainingResponse();
  public trainings: TrainingResponse[] = [];
  public dias: number[] = [];
  public errorMessage = '';

  constructor(
    private trainingService: TrainingService,
    private userService: UserService,
    private clientService: ClientService
  ) {
  }

  ngAfterViewInit(): void {
    this.errorMessage = '';

    this.clientService.getCurrentClient().then((user: any) => {

      this.userService.getClient(user.idUser).then((client) => {

        this.clientService.getTrainingByClient(client.idClient || 0).then((training) => {

          if (!training) {
            this.errorMessage = 'No se han encontrado entrenamientos.';
            return;
          }


          this.trainingService.getById(training.idTraining || 0).then((trainings) => {
            this.dias = trainings.map((training) => training.orderWeek).filter((valor, indice, array) => {
              return array.indexOf(valor) === indice;
            }).sort();
            this.trainings = trainings
          })

        })

      })
      
    })

  }

  mostrarEntrenamiento(training: TrainingResponse) {
    this.training = training
  }

  clearErrorMessage() {
    this.errorMessage = '';
  }

}
