import { Injectable } from '@angular/core';
import { ShoppingListService } from './shopping-list.service';
import { IngredientSummary } from '../models/ShoppingList';


@Injectable({
  providedIn: 'root',
})
export class SharingService {
  constructor(private shoppingListService: ShoppingListService) { }

  private generateSharingString(ingredientList: IngredientSummary[]) {
    let emailbody = 'Lista de la compra:\n\n';
    ingredientList.forEach((ingredientSummary) => {
      emailbody += `- ${ingredientSummary.totalQuantity}gr ${ingredientSummary.name}\n`;
    });
    emailbody += '\n\n';

    return emailbody;
  }

  copyToClipboard(id: number): Promise<void> {

    return new Promise<void>(() => {
      this.shoppingListService.getShoppingList(id).subscribe((res) => {
        navigator.clipboard.writeText(this.generateSharingString(res));
      });
    });

  }

  generateEmailBody(id: number): Promise<string> {

    return new Promise<string>((resolve, reject) => {

      this.shoppingListService.getShoppingList(id).subscribe((res) => {

        if (res) {
          resolve(encodeURI(this.generateSharingString(res)));
        }
      });
    
    });
  }
}
