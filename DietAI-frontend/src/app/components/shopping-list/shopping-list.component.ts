import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IngredientSummary } from 'src/app/models/ShoppingList';
import { ClientService } from 'src/app/services/client.service';
import { ShoppingListService } from 'src/app/services/shopping-list.service';
import { ClientStore } from 'src/app/store/clientStore';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent {
  @Input() idClient: number = 1;
  private _isOpened: boolean;
    
  @Input() 
  set isOpened(value: boolean) {
    this._isOpened = value;

    if(this._isOpened)
      this.idClient = parseInt(this.clientStore.getRole() || '0');
    this.clientService.getDietByClient(this.idClient).then((diet) => {
      this.shoppingListService.getShoppingList(diet.idDiet || 0).subscribe(data => {
        this.shoppingList = data;
      });
    })
  
  }
  get isOpened(): boolean {
    return this._isOpened;
  }

  @Output() aceptarFormulario = new EventEmitter();

  shoppingList: IngredientSummary[] = [];
  steps: string[] = [];

  constructor(
    private shoppingListService: ShoppingListService,
    private clientStore: ClientStore,
    private clientService: ClientService
  ) { 
    this._isOpened = false;
  }

  openModal(recipeId: number): void {
    this.shoppingListService.getShoppingList(recipeId).subscribe(data => {
      this.shoppingList = data;
    });
  }

}
