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
    public ingredients: Ingredient[] = [];
    public selectedIngredientId: number = 0;

    ngOnInit(): void {
        this.getIngredients();
    }
    getIngredients () {
        this.ingredientService.getAllIngredient().then((ingredients) => {
            this.ingredients = ingredients;
        });
    }

    saveIngredient() {
        this.ingredientService
            .postIngredient(this.ingredient)
            .then((ingredient) => {
                this.ingredient = new Ingredient();
                this.getIngredients();
                window.location.reload();
            });
    }

    deleteIngredient() {
        console.log(this.selectedIngredientId);
        this.ingredientService
            .deleteIngredient(this.selectedIngredientId)
            .then((ingredient) => {
                this.ingredient = new Ingredient();
                this.selectedIngredientId = 0;
                this.ngOnInit();
            });
    }
}
