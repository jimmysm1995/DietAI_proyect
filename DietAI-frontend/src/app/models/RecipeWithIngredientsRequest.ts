import { IngredientInRecipe } from './IngredientInRecipe';
import { Recipe } from './Recipe';
export class RecipeWithIngredientsRequest {
    recipe: Recipe = new Recipe();
    ingredientInRecipe: IngredientInRecipe[]=[];
}

