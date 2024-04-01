import { IngridientComponent } from "../components/ingridient/ingridient.component";
import { IngridientService } from '../services/ingridient.service';

export class Ingridient{
    name: string = '';
    calories?: number = 0;
    carbohydrates?: number = 0;
    fats?: number = 0;
    protein?: number = 0;
}