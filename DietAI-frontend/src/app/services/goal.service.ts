import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Goal } from '../models/Goal';

@Injectable({
  providedIn: 'root'
})
export class GoalService {

  private baseUrl: string = environment.apiUrl+'/api/goal';

  getGoal(): Promise<Goal[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }}
