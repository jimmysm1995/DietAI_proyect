import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Client } from '../models/Client';
import { AltaCliente } from '../models/AltaCliente';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private baseUrl: string = environment.apiUrl+'/api/clients';

  getClients(): Promise<Client[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  getClient(id: number): Promise<Client> {
    return axios.get(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  createClient(user: any): Promise<Client> {
    return axios.post(this.baseUrl, user).then((response) => response.data);
  }

  deleteClient(id: number): Promise<Client> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  registerClient(userData: Client): Promise<Client>{
    return axios.post(this.baseUrl, userData)
    .then((response) => response.data)
    .catch((error) => {
      if (error.response && error.response.data) {
          return Promise.reject(error.response.data);
      } else {
          return Promise.reject('Error desconocido');
      }
  });
  }
  
  getCurrentClient():Promise<Client>{
    return axios.get(`${this.baseUrl}/currentClient`).then((response) => response.data);
  }

  asignarDieta(idClient: number):Promise<Client>{
    return axios.post(`${this.baseUrl}/diet/${idClient}`).then((response) => response.data);
  }

  asignarEntrenamiento(idClient: number):Promise<Client>{
    return axios.post(`${this.baseUrl}/training/${idClient}`).then((response) => response.data);
  }

}
