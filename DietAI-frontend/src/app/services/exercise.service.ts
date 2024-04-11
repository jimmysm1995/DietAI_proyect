import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Exercise } from '../models/Exercise';
import { Muscle } from '../models/Exercise';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService {

  private baseUrl: string = environment.apiUrl+'/api/exercises';
  getExercise(idExercise: number) {
    return axios.get(this.baseUrl + 'exercises/' + idExercise);
  }

  postExercise(exercise: Exercise) {
    return axios.post(this.baseUrl, exercise)
    .then((response) => response.data)
    .catch((error) => {
      if (error.response && error.response.data) {
          return Promise.reject(error.response.data);
      } else {
          return Promise.reject('Error desconocido');
      }
  });
  }

  getMuscles(): Promise<Muscle[]> {
    return axios.get(environment.apiUrl+'/api/muscles').then((response) => response.data);
  }

  getTypeTraining(): Promise<string[]> {
    return axios.get(environment.apiUrl+'/api/typeTraining').then((response) => response.data);
  }

  
}
