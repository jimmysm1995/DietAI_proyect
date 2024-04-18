import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { RecipeWithIngredientsRequest } from '../models/RecipeWithIngredientsRequest';
import { Recipe } from '../models/Recipe';


@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor() { }

  private baseUrl: string = environment.apiUrl+'/api/recipe';
  getRecipe(idRecipe: number) {
    return axios.get(this.baseUrl + 'recipe/' + idRecipe);
  }

  getAllRecipe(): Promise<Recipe[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  deleteRecipe(id: number): Promise<void> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  postRecipe(recipe: RecipeWithIngredientsRequest) {
    return axios.post(this.baseUrl, recipe)
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
