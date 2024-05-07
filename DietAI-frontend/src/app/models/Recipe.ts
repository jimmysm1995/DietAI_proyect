import { Allergy } from "./Allergy";
import { IngredientInRecipe } from "./IngredientInRecipe";

export class Recipe{
    idRecipe?: number = 0
    name: string = '';
    calories?: number = 0;
    steps: string = '';
    ingredients?: IngredientInRecipe[] = [];
    imageUrl?: string = '';
    allergy?: Allergy[];
}

export class RecipeWithIngredients{
    recipe: Recipe = new Recipe();
    ingredientInRecipe: IngredientInRecipe[] = [];
    
}