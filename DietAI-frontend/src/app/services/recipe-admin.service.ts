import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RecipeAdminService {

  private apiUrl = 'http://localhost:8080/api/recipe'; // Reemplaza esto con la URL de tu backend


  // saveRecipe(ingredientInRecipeList: ingredientInRecipeList): Observable<any> {
  //   return this.http.post<any>(`${this.apiUrl}`, recipeWithIngredients);
  // }
}
