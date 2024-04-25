import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Diet } from '../models/Diet';
import { DietWithRecipesRequest } from '../models/DietWithRecipesRequest';
import { Recipe } from '../models/Recipe';
import { RecipeInDietResponse } from '../models/RecipeInDiet';

@Injectable({
  providedIn: 'root'
})

export class DietService {
  private baseUrl: string = environment.apiUrl+'/api/diet';

  getDiets(): Promise<Diet[]> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }

  obtenerImagen(dietname : string): Promise<string> {
    return axios.get<string>(`${this.baseUrl}/imagen`).then((response) => response.data);
  }

  getDiet(id: number): Promise<Diet> {
    return axios.get(`${this.baseUrl}/${id}`).then((response) => response.data);
  }

  getDietByDietname(dietname: string): Promise<Diet> {
    return axios.get(`${this.baseUrl}/diet/${dietname}`).then((response) => response.data);
  }

  createDiet(diet: DietWithRecipesRequest): Promise<Diet> {
    return axios.post(this.baseUrl, diet).then((response) => response.data);
  }

  updateDiet(diet: Diet): Promise<Diet> {
    return axios.put(`${this.baseUrl}/${diet.idDiet}`, diet).then((response) => response.data);
  }

  deleteDiet(id: number): Promise<Diet> {
    return axios.delete(`${this.baseUrl}/${id}`).then((response) => response.data);
  }
  
  getRecipesByDiet(id: number): Promise<RecipeInDietResponse[]> {
    return axios.get(`${this.baseUrl}/recipes/${id}`).then((response) => response.data);
  }
}
