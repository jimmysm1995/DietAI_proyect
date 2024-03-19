import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import axios from 'axios';
import { Injury } from '../models/Injury';

@Injectable({
  providedIn: 'root'
})
export class InjuryService {
  private baseUrl: string = environment.apiUrl+'/api/injury';

  getInjuries(): Promise<Injury[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  obtenerImagen(injuryname : string): Promise<string> {
    return axios.get<string>(`${this.baseUrl}/imagen`).then((response) => response.data);
  }

  getInjury(id: number): Promise<Injury> {
    return axios.get(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  getInjuryByInjuryname(injuryname: string): Promise<Injury> {
    return axios.get(`${this.baseUrl}/injury/${injuryname}`).then((response) => response.data);
  }

  createInjury(injury: any): Promise<Injury> {
    return axios.post(this.baseUrl, injury).then((response) => response.data);
  }

  updateInjury(injury: Injury): Promise<Injury> {
    return axios.put(`${this.baseUrl}/${injury.idInjury}`, injury).then((response) => response.data);
  }

  deleteInjury(id: number): Promise<Injury> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

}
