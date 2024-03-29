import { Component, OnInit } from '@angular/core';
import { DietService } from 'src/app/services/diet.service';
import { Diet } from 'src/app/models/Diet';

@Component({
    selector: 'app-diet',
    templateUrl: './diet.component.html',
    styleUrls: ['./diet.component.css'],
})
export class DietComponent {
    constructor(private dietService: DietService) {}

    public diet: Diet = new Diet();

    ngOnInit(): void {
        this.dietService.getDiet(1).then((diet: Diet) => {
            this.diet = Diet;
        });
    }
}
