import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Ingredient } from '../models/Ingredient';
import { ApiError } from '../models/ApiError';
@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private baseUrl: string = environment.apiUrl+'/api/ingredient';

  postIngredient(ingredient: Ingredient): Promise<Ingredient[]> {
    return axios.post(this.baseUrl, ingredient).then((response) => response.data)
    .catch((error) => {
      if (error.response && error.response.data) {
        const apiError = new ApiError(error.response.data);
        return Promise.reject(apiError);
      } else {
          return Promise.reject('Error desconocido');
      }
    });
  }

  getAllIngredient(): Promise<Ingredient[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  deleteIngredient(id: number): Promise<void> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

}


