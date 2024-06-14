import { Component, Input, OnInit, ViewChild  } from '@angular/core';
import { DietService } from 'src/app/services/diet.service';
import { ClientStore } from '../../store/clientStore';
import { Recipe } from 'src/app/models/Recipe';
import { RecipeInDietResponse } from 'src/app/models/RecipeInDiet';
import { ClientService } from 'src/app/services/client.service';
import { SharingService } from '../../services/sharing.service';
import { Diet } from '../../models/Diet';
import { UserStore } from 'src/app/store/userStore';
import { MealTimeService } from 'src/app/services/meal-time.service';
import { DayOfWeekService } from 'src/app/services/day-of-week.service';
import { DayOfWeek } from 'src/app/models/DayOfWeek';
import { MealTime } from 'src/app/models/MealTime';

@Component({
    selector: 'app-diet',
    templateUrl: './diet.component.html',
    styleUrls: ['./diet.component.css'],
})
export class DietComponent {

    public showShoppingList: boolean = false;
    constructor(
        private dietService: DietService,
        private clientStore: ClientStore,
        private clientService: ClientService,
        private userStore: UserStore,
        private mealTimeService: MealTimeService,
        private daysOfWeekService: DayOfWeekService,
        private sharingService: SharingService) {}

    public recipes: RecipeInDietResponse [] = [];
    public isModalOpened: boolean = false;
    private selectedDiet?: Diet;
    public mailtoStr = "";
    public dayOfWeek: string[] = [];
    public mealTime: string[] = [];

    ngOnInit(): void {
        this.mealTimeService.getMealTimes().then((mealTimes) => {
            this.mealTime = mealTimes;
        })
        this.daysOfWeekService.getDayOfWeek().then((daysOfWeek) => {
            this.dayOfWeek = daysOfWeek;
        })
        let idClient: number = parseInt(this.clientStore.getRole() || '0');
        if (idClient !== undefined) {
            this.clientService.getDietByClient(idClient).then((diet) => {
                this.selectedDiet = diet;
                this.dietService.getRecipesByDiet(diet.idDiet || 0).then((recipes: RecipeInDietResponse[]) => {
                    this.recipes = recipes;
                });
            });
        }
    }
    

    findRecipe(day: string, mealTime: string): Recipe {
        return this.recipes.find(recipe => recipe.dayWeek === day && recipe.mealTime === mealTime)?.recipe || new Recipe()
    }

    cerrarModal() {
        document.getElementById('close')?.click();
        this.isModalOpened = false;
    }

    onOpenModal() {
        this.isModalOpened = true;
    }

    generateEmail() {

        this.mailtoStr = `mailto:${this.userStore.user.email}?Subject="Take a look to my shopping list"&body=`;

        this.sharingService.generateEmailBody(this.selectedDiet?.idDiet || 0).then((emailBody) => {
            this.mailtoStr += emailBody;
            setTimeout(() => document.getElementById('mailLink')?.click(), 0);
        });
    }


    copyToClipboard() {
        this.sharingService.copyToClipboard(this.selectedDiet?.idDiet || 0);
    }
}
