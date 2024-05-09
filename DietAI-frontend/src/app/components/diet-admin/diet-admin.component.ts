import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DietService } from 'src/app/services/diet.service';
import { DayOfWeekService } from '../../services/day-of-week.service';
import { MealTimeService } from 'src/app/services/meal-time.service';
import { Recipe } from '../../models/Recipe';
import { RecipeService } from 'src/app/services/recipe.service';
import { DietWithRecipesRequest } from 'src/app/models/DietWithRecipesRequest';
import { RecipeInDiet } from 'src/app/models/RecipeInDiet';
import { Diet } from '../../models/Diet';
import { Allergy } from 'src/app/models/Allergy';
import { AllergyService } from 'src/app/services/allergy.service';

@Component({
    selector: 'app-diet-admin',
    templateUrl: './diet-admin.component.html',
    styleUrls: ['./diet-admin.component.css'],
})
export class DietAdminComponent {
    @ViewChild('dietForm') dietForm!: NgForm;

    public dayOfWeek: string[] = [];
    public mealTime: string[] = [];
    public recipes: Recipe[] = [];
    public recipe: Recipe = new Recipe();
    public recipesInDiet: RecipeInDiet[] = [];
    public dietWithRecipes: DietWithRecipesRequest =
        new DietWithRecipesRequest();
    public diet: Diet = new Diet();
    public diets: Diet[] = [];
    public selectedDietId: number = 0;
    public allergies: Allergy[] = [];
    public filteredAllergies: Allergy[] = [];

    constructor(
        private dietService: DietService,
        private recipeService: RecipeService,
        private dayOfWeekService: DayOfWeekService,
        private mealTimeService: MealTimeService,
        private allergyService: AllergyService
    ) {}

    ngOnInit(): void {
        this.dayOfWeekService.getDayOfWeek().then((dayOfWeek) => {
            this.dayOfWeek = dayOfWeek;
        });
        this.mealTimeService.getMealTimes().then((mealTime) => {
            this.mealTime = mealTime;
        });
        this.recipeService.getAllRecipe().then((recipe) => {
            this.recipes = recipe;
        });
        this.dietService.getDiets().then((diet) => {
            this.diets = diet;
        });
        this.allergyService.getAllergies().then((allergies) => {
            this.allergies = allergies;
        });
    }

    saveIngredients(recipe: Recipe, dayOfWeek: string, mealTime: string) {
        for (let i = 0; i < this.recipesInDiet.length; i++) {
            if (
                this.recipesInDiet[i].dayWeek === dayOfWeek &&
                this.recipesInDiet[i].mealTime === mealTime
            ) {
                this.recipesInDiet.splice(i, 1);
            }
        }
        this.recipesInDiet.push({
            recipe: recipe,
            dayWeek: dayOfWeek,
            mealTime: mealTime,
        });
    }
    registrarDiet(formData: any) {
        this.dietWithRecipes.diet.name = formData.name;
        this.dietWithRecipes.recipeInDiet = this.recipesInDiet;
        this.dietWithRecipes.diet.allergy = this.filteredAllergies;
        this.dietService.createDiet(this.dietWithRecipes).then((newDiet) => {
            this.dietForm.reset();
            this.recipesInDiet = [];
        });
    }

    async onAllergySelected() {
      const filteredRecipes: Recipe[] = [];
      const recipes = await this.recipeService.getAllRecipe();
  
      for (const recipe of recipes) {
          const allergiesInRecipe = await this.recipeService.findAllergiesInRecipe(recipe.idRecipe || 0);
          
          // Verificar si la receta contiene al menos una alergia seleccionada
          const containsAnyAllergy = this.filteredAllergies.some(filterAllergy =>
              allergiesInRecipe.some(allergy => allergy.idAllergy === filterAllergy.idAllergy)
          );
  
          // Si la receta no contiene ninguna alergia seleccionada, agregarla a la lista de recetas filtradas
          if (!containsAnyAllergy) {
              filteredRecipes.push(recipe);
          }
      }
  
      this.recipes = filteredRecipes;
  }
  
  

    deleteDiet() {
        console.log(this.selectedDietId);
        this.dietService.deleteDiet(this.selectedDietId).then((diet) => {
            this.selectedDietId = 0;
            this.ngOnInit();
        });
    }

    limpiarLista() {
        this.recipesInDiet = [];
        this.dietForm.reset();
    }
}
