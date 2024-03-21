import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { ConsumedSubstances } from '../models/ConsumedSubstances';

@Injectable({
  providedIn: 'root'
})
export class ConsumedSubstancesService {

  private baseUrl: string = environment.apiUrl+'/api/consumedSubstances';

  getConsumedSubstances(): Promise<ConsumedSubstances[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }
}
