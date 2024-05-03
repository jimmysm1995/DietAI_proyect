import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';
import { Recipe, RecipeWithIngredients } from 'src/app/models/Recipe';
import { RecipeWithIngredientsRequest } from 'src/app/models/RecipeWithIngredientsRequest';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})

export class RecipeComponent {
  @Input() recipe: Recipe = new Recipe(); // Recibe la receta como entrada desde el componente padre

  public isDataLoaded: boolean = false;
  public completeRecipe: RecipeWithIngredientsRequest = new RecipeWithIngredientsRequest();
  public steps: string[] = [];

  ngOnInit() {
    
  }

  public recipeEjemplo = {
    name: 'Pollo al horno',
    description: 'Deliciosa receta de pollo al horno.',
    ingredients: ['1 pollo entero', 'Sal', 'Pimienta', 'Hierbas aromáticas'],
    steps: ['Precalentar el horno a 180°C.', 'Sazonar el pollo con sal, pimienta y hierbas aromáticas.', 'Hornear durante 1 hora o hasta que esté dorado y cocido.'],
    imageUrl: 'https://www.hogarmania.com/archivos/202212/pollo-al-horno-portada-848x477x80xX.jpg'
  }

  constructor(private recipeService: RecipeService ) { } 

  public firstLoad(){
    if(this.isDataLoaded){
      return
    }
    this.recipeService.getRecipeWithIngredients(this.recipe.idRecipe || 1).then ((recipe: RecipeWithIngredients ) => {
      this.steps = this.dividirPasos(recipe.recipe.steps);
      this.isDataLoaded = true;
      this.completeRecipe = recipe;
      console.log(this.completeRecipe)
    })
  }

  public dividirPasos(inputString: string) : string[] {
    return inputString.split(".").filter(part => part !== "");
}
}
