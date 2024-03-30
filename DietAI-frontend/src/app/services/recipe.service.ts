import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor() { }

  private baseUrl: string = environment.apiUrl+'/api/recipes';
  getRecipe(idRecipe: number) {
    return axios.get(this.baseUrl + 'recipe/' + idRecipe);
  }

}
