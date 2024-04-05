import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../../models/Ingredient';
import { IngredientService } from '../../services/ingredient.service';

@Component({
    selector: 'app-ingredient',
    templateUrl: './ingredient.component.html',
    styleUrls: ['./ingredient.component.css'],
})
export class IngredientComponent {
    constructor(private ingredientService: IngredientService) {}

    public ingredient: Ingredient = new Ingredient();

    saveIngredient() {
      this.ingredientService.postIngredient(this.ingredient).then(Ingredient=>{
      })
    }
}
