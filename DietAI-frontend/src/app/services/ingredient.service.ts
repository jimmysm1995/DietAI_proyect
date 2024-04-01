import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { Ingredient } from '../models/Ingredient';
@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private baseUrl: string = environment.apiUrl+'/api/ingredient';

  postIngredient(ingredient: Ingredient): Promise<Ingredient[]> {
    return axios.post(this.baseUrl, ingredient).then((response) => response.data);
  }}
