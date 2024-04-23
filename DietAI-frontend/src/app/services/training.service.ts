import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Training,  TrainingRequest, TrainingResponse} from '../models/Training';
import { TrainingWithExercisesRequest } from '../models/TrainingWithExercisesRequest';



@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  private baseUrl: string = environment.apiUrl+'/api/trainings';

  constructor() { }

  postTraining(training: TrainingWithExercisesRequest) {
    return axios.post(this.baseUrl, training).then((response) => response.data);
  }

  deleteTraining(id: number): Promise<void> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  getAllTrainings(): Promise<Training[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  getById(idTraining: number): Promise<TrainingResponse[]>{
    return axios.get(`${this.baseUrl}/exercises/${idTraining}`).then((response) => response.data);
  }
}
