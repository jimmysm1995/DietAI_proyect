import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import axios from 'axios';
import { Allergy } from '../models/Allergy';

@Injectable({
  providedIn: 'root'
})
export class AllergyService {


  private baseUrl: string = environment.apiUrl+'/api/allergy';

  getAllergies(): Promise<Allergy[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  obtenerImagen(allergyname : string): Promise<string> {
    return axios.get<string>(`${this.baseUrl}/imagen`).then((response) => response.data);
  }

  getAllergy(id: number): Promise<Allergy> {
    return axios.get(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  getAllergyByAllergyname(allergyname: string): Promise<Allergy> {
    return axios.get(`${this.baseUrl}/allergy/${allergyname}`).then((response) => response.data);
  }

  createAllergy(allergy: any): Promise<Allergy> {
    return axios.post(this.baseUrl, allergy).then((response) => response.data);
  }

  updateAllergy(allergy: Allergy): Promise<Allergy> {
    return axios.put(`${this.baseUrl}/${allergy.idAllergy}`, allergy).then((response) => response.data);
  }

  deleteAllergy(id: number): Promise<Allergy> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

}
