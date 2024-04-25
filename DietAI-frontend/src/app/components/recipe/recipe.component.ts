import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})

export class RecipeComponent {
  @Input() recipe1: any; // Recibe la receta como entrada desde el componente padre

  // ngOnInit() {
  //   this.recipeService.getRecipe(this.recipe.id).(recipe => {
  //     this.recipe = recipe
  //   })
  // }

  public recipe = {
    name: 'Pollo al horno',
    description: 'Deliciosa receta de pollo al horno.',
    ingredients: ['1 pollo entero', 'Sal', 'Pimienta', 'Hierbas aromáticas'],
    steps: ['Precalentar el horno a 180°C.', 'Sazonar el pollo con sal, pimienta y hierbas aromáticas.', 'Hornear durante 1 hora o hasta que esté dorado y cocido.'],
    imageUrl: 'https://www.hogarmania.com/archivos/202212/pollo-al-horno-portada-848x477x80xX.jpg'
  }

  constructor(private recipeService: RecipeService ) { } 
}
