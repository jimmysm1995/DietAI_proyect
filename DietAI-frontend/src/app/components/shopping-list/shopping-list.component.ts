import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IngredientSummary } from 'src/app/models/ShoppingList';
import { ShoppingListService } from 'src/app/services/shopping-list.service';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent {
  @Input() idDieta: number = 1;
  private _isOpened: boolean;
    
  @Input() 
  set isOpened(value: boolean) {
    this._isOpened = value;

    if(this._isOpened)
      this.shoppingListService.getShoppingList(this.idDieta).subscribe(data => {
        this.shoppingList = data;
      });
  
  }
  get isOpened(): boolean {
    return this._isOpened;
  }

  @Output() aceptarFormulario = new EventEmitter();

  shoppingList: IngredientSummary[] = [];
  steps: string[] = [];

  constructor(
    private shoppingListService: ShoppingListService
  ) { 
    this._isOpened = false;
  }

  openModal(recipeId: number): void {
    this.shoppingListService.getShoppingList(recipeId).subscribe(data => {
      this.shoppingList = data;
    });
  }

}
