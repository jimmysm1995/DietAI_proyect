import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { PreviusLevel } from '../models/PreviusLevel';
@Injectable({
  providedIn: 'root'
})
export class PreviusLevelService {

  private baseUrl: string = environment.apiUrl+'/api/previusLevel';

  getPreviusLevels(): Promise<PreviusLevel[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }
}
