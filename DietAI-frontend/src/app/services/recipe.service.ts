import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { RecipeWithIngredientsRequest } from '../models/RecipeWithIngredientsRequest';
import { Recipe, RecipeWithIngredients } from '../models/Recipe';
import { Allergy } from '../models/Allergy';


@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor() { }

  private baseUrl: string = environment.apiUrl+'/api/recipe';
  getRecipe(idRecipe: number) : Promise<Recipe> {
    return axios.get(this.baseUrl + "/" + idRecipe);
  }

  getAllRecipe(): Promise<Recipe[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  findAllergiesInRecipe(idRecipe: number): Promise<Allergy[]> {
    return axios.get(this.baseUrl + "/allergies/" + idRecipe).then((response) => response.data);
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
  getRecipeWithIngredients(idRecipe: number) : Promise<RecipeWithIngredients> {
    return axios.get(this.baseUrl + /recipesWithIngredient/ + idRecipe).then((response) => response.data);
  }
}
