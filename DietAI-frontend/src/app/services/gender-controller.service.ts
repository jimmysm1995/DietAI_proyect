import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Gender } from '../models/Gender';

@Injectable({
  providedIn: 'root'
})
export class GenderService {

  private baseUrl: string = environment.apiUrl+'/api/gender';

  getGender(): Promise<Gender[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }}
