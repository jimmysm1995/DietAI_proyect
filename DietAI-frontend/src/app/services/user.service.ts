import { Injectable } from '@angular/core';
import axios from 'axios';
import { User } from '../models/User';
import { environment } from 'src/environments/environment';
import { LoginResponse } from '../models/loginResponse';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private baseUrl: string = environment.apiUrl+'/api/users';


  getUsers(): Promise<User[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  getUser(id: number): Promise<User> {
    return axios.get(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  createUser(user: any): Promise<User> {
    return axios.post(this.baseUrl, user).then((response) => response.data);
  }

  updateUser(user: any): Promise<User> {
    return axios.put(`${this.baseUrl}/${user.idUser}`, user).then((response) => response.data);
  }

  deleteUser(id: number): Promise<User> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  loginUser(userData: User): Promise< LoginResponse> {
    return axios.post(`${this.baseUrl}/login`, userData)
    .then((response) => response.data)
    .catch((error) => {
      if (error.response && error.response.data) {
          return Promise.reject(error.response.data);
      } else {
          return Promise.reject('Error desconocido');
      }
  });
  }

  registerUser(userData: User): Promise<User>{
    return axios.post(`${this.baseUrl}/register`, userData)
    .then((response) => response.data)
    .catch((error) => {
      if (error.response && error.response.data) {
          return Promise.reject(error.response.data);
      } else {
          return Promise.reject('Error desconocido');
      }
  });
  }
}
