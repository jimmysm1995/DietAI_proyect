import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { MealTime } from '../models/MealTime';

@Injectable({
  providedIn: 'root'
})
export class MealTimeService {

  constructor() { }

  private baseUrl: string = environment.apiUrl+'/api/mealTime';

  getMealTimes(): Promise<string[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }
}
