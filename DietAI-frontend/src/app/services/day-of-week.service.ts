import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { DayOfWeek } from '../models/DayOfWeek';

@Injectable({
  providedIn: 'root'
})
export class DayOfWeekService {

  constructor() { }

  private baseUrl: string = environment.apiUrl+'/api/dayOfWeek';

  getDayOfWeek(): Promise<string[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }
}
