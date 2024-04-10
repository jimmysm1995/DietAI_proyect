import { Diet } from './Diet';
import { RecipeInDiet } from './RecipeInDiet';
export class DietWithRecipesRequest {
    diet: Diet = new Diet();
    recipeInDiet: RecipeInDiet[] = [];
}