import { Component, OnInit } from '@angular/core';
import { DietService } from 'src/app/services/diet.service';
import { Diet } from 'src/app/models/Diet';
import { RecipeComponent } from '../recipe/recipe.component';
import { ClientStore } from '../../store/clientStore';
import { Recipe } from 'src/app/models/Recipe';
import { RecipeInDietResponse } from 'src/app/models/RecipeInDiet';

@Component({
    selector: 'app-diet',
    templateUrl: './diet.component.html',
    styleUrls: ['./diet.component.css'],
})
export class DietComponent {
    constructor(
        private dietService: DietService,
        private ClientStore: ClientStore
    ) {}

    public recipes: RecipeInDietResponse [] = [];


    ngOnInit(): void {
        this.dietService.getRecipesByDiet(1).then((recipes: RecipeInDietResponse[]) => {
            this.recipes = recipes;
            
        });
    }

    findRecipe(day: string, mealTime: string): Recipe {
        return{...(this.recipes.find(recipe => recipe.day === day && recipe.mealTime === mealTime)?.recipe || new Recipe())}
    }
    
}
