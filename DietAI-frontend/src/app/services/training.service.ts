import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Training,  TrainingRequest} from '../models/Training';



@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  private baseUrl: string = environment.apiUrl+'/api';

  constructor() { }

  postTraining(training: Training) {
    let trainingRequest: TrainingRequest = {
      training: training,
      exercisesInTraining: training.trainingExercises||[]
    }
    return axios.post(`${this.baseUrl}/trainings`, trainingRequest).then((response) => response.data);
  }

  getAllExercises() {
    return axios.get(`${this.baseUrl}/exercises`).then((response) => response.data);
  }


}
