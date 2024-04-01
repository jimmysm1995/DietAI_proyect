import { IngredientComponent } from "../components/ingredient/ingredient.component";
import { IngredientService } from '../services/ingredient.service';

export class Ingredient{
    idIngredient?: number = 0
    name: string = '';
    calories?: number = 0;
    carbohydrates?: number = 0;
    fats?: number = 0;
    protein?: number = 0;
}