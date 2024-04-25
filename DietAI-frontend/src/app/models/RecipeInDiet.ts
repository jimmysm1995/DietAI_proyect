import { Recipe } from './Recipe';
export class RecipeInDiet {
    recipe: Recipe = new Recipe();
    dayOfWeek: string = '';
    mealTime: string = '';
}

export class RecipeInDietResponse {
    recipe: Recipe = new Recipe();
    day: string = '';
    mealTime: string = '';
}