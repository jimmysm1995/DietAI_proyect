import { Component, OnInit, ViewChild  } from '@angular/core';
import { DietService } from 'src/app/services/diet.service';
import { Diet } from 'src/app/models/Diet';
import { RecipeComponent } from '../recipe/recipe.component';
import { ClientStore } from '../../store/clientStore';
import { Recipe } from 'src/app/models/Recipe';
import { RecipeInDietResponse } from 'src/app/models/RecipeInDiet';
import { ClientService } from 'src/app/services/client.service';
import { ShoppingListService } from 'src/app/services/shopping-list.service'; 
import { IngredientSummary } from 'src/app/models/ShoppingList';
import { ShoppingListComponent } from '../shopping-list/shopping-list.component';

@Component({
    selector: 'app-diet',
    templateUrl: './diet.component.html',
    styleUrls: ['./diet.component.css'],
})
export class DietComponent {
    @ViewChild('shoppingList') shoppingList!: ShoppingListComponent;

    shoppingListData: IngredientSummary[] = [];
    constructor(
        private dietService: DietService,
        private clientStore: ClientStore,
        private clientService: ClientService,
        private shoppingListService: ShoppingListService) {}

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
    

    showShoppingList(){
        try {
            const id =1;
            // this.shoppingListData = await this.shoppingListService.getShoppingList(id).toPromise();
          } catch (error) {
            console.error('Error al obtener la lista de compras:', error);
          }
    }
}
