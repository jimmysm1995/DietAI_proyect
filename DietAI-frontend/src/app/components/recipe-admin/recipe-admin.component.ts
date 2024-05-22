import { Component, OnInit, ViewChild } from '@angular/core';
import { RecipeAdminService } from 'src/app/services/recipe-admin.service';
import { recipeAdmin } from 'src/app/models/recipeAdmin';
import { FormArray, FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { IngredientService } from '../../services/ingredient.service';
import { Ingredient } from '../../models/Ingredient';
import { RecipeWithIngredientsRequest } from '../../models/RecipeWithIngredientsRequest';
import { IngredientInRecipe } from '../../models/IngredientInRecipe';
import { RecipeService } from '../../services/recipe.service';
import { Recipe } from 'src/app/models/Recipe';
import { AllergyService } from 'src/app/services/allergy.service';
import { Allergy } from 'src/app/models/Allergy';


@Component({
  selector: 'app-recipe-admin',
  templateUrl: './recipe-admin.component.html',
  styleUrls: ['./recipe-admin.component.css']
})
export class RecipeAdminComponent {
  @ViewChild('recipeForm') recipeForm!: NgForm;
  @ViewChild('ingredientInRecipeForm') ingredientInRecipeForm!: NgForm;

  public ingredient : Ingredient[] = [];
  public ingredientsInRecipe: IngredientInRecipe[] = [];
  public recipeWithIngredientsRequest: RecipeWithIngredientsRequest = new RecipeWithIngredientsRequest();
  public recipes : Recipe[] = [];
  public recipe : Recipe = new Recipe();
  public selectedRecipeId: number = 0;
  public allergies : Allergy[] = [];

  constructor(private recipeAdminService: RecipeAdminService, 
    private ingredientService: IngredientService,
    private recipeService: RecipeService, 
    private allergyService: AllergyService) { 
  }

  ngOnInit(): void {
    this.ingredientService.getAllIngredient().then((ingredient) => {
        this.ingredient = ingredient;
    });
    this.recipeService.getAllRecipe().then((recipe) => {
        this.recipes = recipe;
    })
    this.allergyService.getAllergies().then((allergies) => {
      this.allergies = allergies;
  });
}

registraIngredientInRecipe(ingredientInRecipe: IngredientInRecipe) {
  this.ingredientsInRecipe.push(ingredientInRecipe);
  this.ingredientInRecipeForm.reset();

}

registrarRecipe(recipe : Recipe) {
  console.log(recipe);
  this.recipeWithIngredientsRequest.recipe = recipe;
  this.recipeWithIngredientsRequest.ingredientInRecipe = this.ingredientsInRecipe;
  this.recipeService.postRecipe(this.recipeWithIngredientsRequest).then((newRecipe) => {
    this.recipeForm.reset();
    this.ingredientsInRecipe = [];
    this.ingredientInRecipeForm.reset();
  })
  window.location.reload();
}

limpiarLista() {
    this.ingredientsInRecipe = [];
  }

  deleteRecipe() {
    console.log(this.selectedRecipeId);
    this.recipeService.deleteRecipe(this.selectedRecipeId).then((recipe) => {
        this.selectedRecipeId = 0
        this.ngOnInit();
    })
    }
}