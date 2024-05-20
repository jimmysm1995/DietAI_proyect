import { Component, Input } from '@angular/core';
import { IngredientSummary } from 'src/app/models/ShoppingList';
import { ShoppingListService} from 'src/app/services/shopping-list.service';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent {
  @Input()idDieta: number = 0;

  shoppingList: IngredientSummary[] = [];
  steps: string[] = [];

  constructor(
    private shoppingListService: ShoppingListService,
  ) { }

  openModal(recipeId: number): void {
    this.shoppingListService.getShoppingList(recipeId).subscribe(data => {
      this.shoppingList = data;
    });
  }

  
}
