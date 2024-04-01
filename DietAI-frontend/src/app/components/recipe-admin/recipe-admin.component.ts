import { Component } from '@angular/core';
import { RecipeAdminService } from 'src/app/services/recipe-admin.service';
import { recipeAdmin } from 'src/app/models/recipeAdmin';


@Component({
  selector: 'app-recipe-admin',
  templateUrl: './recipe-admin.component.html',
  styleUrls: ['./recipe-admin.component.css']
})
export class RecipeAdminComponent {
  constructor(private recipeAdmin: RecipeAdminService) { }

  // ingredientInRecipeList: ingredientInRecipeList = {
  //   recipeDto: {},
  //   ingredientInRecipeList: []
  // };

  saveRecipe(): void {
    // this.recipeService.saveRecipe(this.recipeAdmin).subscribe(
    //   response => {
    //     console.log('Receta guardada exitosamente:', response);
    //     // Aquí puedes realizar cualquier acción adicional después de guardar la receta, como redirigir al usuario a otra página
    //   },
    //   error => {
    //     console.error('Error al guardar la receta:', error);
    //     // Aquí puedes manejar el error de alguna manera, por ejemplo, mostrando un mensaje al usuario
    //   }
    // );
  }
}
