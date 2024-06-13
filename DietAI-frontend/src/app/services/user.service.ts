import { Injectable } from '@angular/core';
import axios from 'axios';
import { User } from '../models/User';
import { environment } from 'src/environments/environment';
import { LoginResponse } from '../models/loginResponse';
import { Client } from '../models/Client';
import { ApiError } from '../models/ApiError';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private baseUrl: string = environment.apiUrl+'/api/users';

  getUsers(): Promise<User[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  obtenerImagen(username : string): Promise<string> {
    return axios.get<string>(`${this.baseUrl}/imagen`).then((response) => response.data);
  }

  getUser(id: number): Promise<User> {
    return axios.get(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  getAuthorities(id?: number): Promise<string[]> {
    return axios.get(`${this.baseUrl}/getAuthorities/${id}`).then((response) => response.data);
  }

  getUserByUsername(username: string): Promise<User> {
    return axios.get(`${this.baseUrl}/user/${username}`).then((response) => response.data);
  }

  createUser(user: any): Promise<User> {
    return axios.post(this.baseUrl, user).then((response) => response.data);
  }

  updateUser(user: User): Promise<User> {
    return axios.put(`${this.baseUrl}/${user.idUser}`, user).then((response) => response.data);
  }

  deleteUserById(id?: number): Promise<User> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  deleteUser(userData: any): Promise<User> {
    return axios.delete(this.baseUrl, userData).then((response) => response.data);
  }

  loginUser(userData: User): Promise< LoginResponse> {
    return axios.post(`${environment.apiUrl}/auth/login`, userData)
    .then((response) => response.data)
    .catch((error) => {
      if (error.response && error.response.data) {
        const apiError = new ApiError(error.response.data);
        return Promise.reject(apiError);
      } else {
          return Promise.reject('Error desconocido');
      }
  });
  }

  registerUser(userData: User): Promise<User>{
    console.log("registerUser");
    return axios.post(`${environment.apiUrl}/auth/register`, userData)
    .then((response) => response.data)
    .catch((error) => {
      if (error.response && error.response.data) {
        const apiError = new ApiError(error.response.data);
        return Promise.reject(apiError);
      } else {
          return Promise.reject('Error desconocido');
      }
  });
  }

  getCurrentUser():Promise<User>{
    return axios.get(`${environment.apiUrl}/auth/currentUser`).then((response) => response.data);
  }

  getClient(id: number): Promise<Client> {
    return axios.get(`${this.baseUrl}/client/${id}`).then((response) => response.data);
}

}
