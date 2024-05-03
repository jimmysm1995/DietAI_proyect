import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DayOfWeek } from 'src/app/models/DayOfWeek';
import { MealTime } from 'src/app/models/MealTime';
import { DietService } from 'src/app/services/diet.service';
import { DayOfWeekService } from '../../services/day-of-week.service';
import { MealTimeService } from 'src/app/services/meal-time.service';
import { Recipe } from '../../models/Recipe';
import { RecipeService } from 'src/app/services/recipe.service';
import { DietWithRecipesRequest } from 'src/app/models/DietWithRecipesRequest';
import { RecipeInDiet } from 'src/app/models/RecipeInDiet';
import { Diet } from '../../models/Diet';

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
    public dietWithRecipes: DietWithRecipesRequest =new DietWithRecipesRequest();
    public diet: Diet = new Diet();
    public diets: Diet[] = [];
    public selectedDietId: number = 0;

    constructor(
        private dietService: DietService,
        private recipeService: RecipeService,
        private dayOfWeekService: DayOfWeekService,
        private mealTimeService: MealTimeService
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
        })
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
        })
    }
    registrarDiet(formData: any) {
      console.log(this.recipesInDiet.length);
      this.dietWithRecipes.diet.name = formData.name;
      this.dietWithRecipes.recipeInDiet = this.recipesInDiet;
      this.dietService.createDiet(this.dietWithRecipes).then((newDiet) => {
        this.dietForm.reset();
        this.recipesInDiet = [];
      });
    }

    deleteDiet() {
      console.log(this.selectedDietId);
      this.dietService.deleteDiet(this.selectedDietId).then((diet) => {
          this.selectedDietId = 0
          this.ngOnInit();
      })
      }

    limpiarLista() {
      this.recipesInDiet = [];
      this.dietForm.reset();
  }
}
