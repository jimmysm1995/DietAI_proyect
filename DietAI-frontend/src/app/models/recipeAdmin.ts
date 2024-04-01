import { RecipeAdminService } from "../services/recipe-admin.service"; 
import { RecipeAdminComponent } from "../components/recipe-admin/recipe-admin.component";

export class Recipe {
    idRecipe: number = 0;
    name: string = "";
    calories: number = 0;
    recipeDiets: RecipeDiets[]= [];
    ingredientRecipe: IngridientRecipe[]=[];
} 

export class RecipeDiets{
    idRecipeDiet: number = 0;
    diet: number = 0;
    recipe: number = 0;
    dayOfWeek: string = "";
    mealTime: number = 0;
}

export class IngridientRecipe{
    idIngredient: number = 0;
    quantity: number = 0;
}
export class recipeAdmin {
    recipe: Recipe = new Recipe();
    // ingredientInRecipe: IngredientInRecipe[]=[];
}   
