import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Ingridient } from '../models/Ingridient';
@Injectable({
  providedIn: 'root'
})
export class IngridientService {

  private baseUrl: string = environment.apiUrl+'/api/ingridient';

  postIngridient(ingridient: Ingridient): Promise<Ingridient[]> {
    return axios.post(this.baseUrl, ingridient).then((response) => response.data);
  }}
