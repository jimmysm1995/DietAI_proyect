import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { JobType } from '../models/JobType';

@Injectable({
  providedIn: 'root'
})
export class JobTypeService {

  private baseUrl: string = environment.apiUrl+'/api/jobType';

  getJobTypes(): Promise<JobType[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }
}
