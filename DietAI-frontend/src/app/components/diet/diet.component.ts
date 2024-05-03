import { Component, OnInit } from '@angular/core';
import { DietService } from 'src/app/services/diet.service';
import { Diet } from 'src/app/models/Diet';
import { RecipeComponent } from '../recipe/recipe.component';
import { ClientStore } from '../../store/clientStore';
import { Recipe } from 'src/app/models/Recipe';
import { RecipeInDietResponse } from 'src/app/models/RecipeInDiet';
import { ClientService } from 'src/app/services/client.service';

@Component({
    selector: 'app-diet',
    templateUrl: './diet.component.html',
    styleUrls: ['./diet.component.css'],
})
export class DietComponent {
    constructor(
        private dietService: DietService,
        private clientStore: ClientStore,
        private clientService: ClientService
    ) {}

    public recipes: RecipeInDietResponse [] = [];


    ngOnInit(): void {
        if (this.clientStore.client.idClient !== undefined) {
            this.clientService.getDietByClient(this.clientStore.client.idClient || 0).then((diet) => {
                this.dietService.getRecipesByDiet(diet.idDiet || 0).then((recipes: RecipeInDietResponse[]) => {
                    this.recipes = recipes;
                });
            });
        }
    }
    

    findRecipe(day: string, mealTime: string): Recipe {
        return this.recipes.find(recipe => recipe.dayWeek === day && recipe.mealTime === mealTime)?.recipe || new Recipe()
    }
    
}
