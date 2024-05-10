import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';
import { IngredientSummary } from '../models/ShoppingList';
import { Observable, from } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {
  private baseUrl: string = environment.apiUrl+'/api/diet';
  constructor() { }

  getShoppingList(id: number): Observable<IngredientSummary[]> {
    return from(
      axios.get<IngredientSummary[]>(`${this.baseUrl}/listaCompra/${id}`)
        .then((response) => response.data)
    ).pipe(
      map(data => data as IngredientSummary[]) // Mapea los datos a un array de IngredientSummary
    );
  }
}