import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Training,  TrainingRequest} from '../models/Training';
import { TrainingWithExercisesRequest } from '../models/TrainingWithExercisesRequest';



@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  private baseUrl: string = environment.apiUrl+'/api';

  constructor() { }

  postTraining(training: TrainingWithExercisesRequest) {
    return axios.post(`${this.baseUrl}/trainings`, training).then((response) => response.data);
  }

  getAllExercises() {
    return axios.get(`${this.baseUrl}/exercises`).then((response) => response.data);
  }

  getById(idTraining: number) {
    return axios.get(`${this.baseUrl}/trainings/exercises/${idTraining}`).then((response) => response.data);
  }
}
