import { Component, OnInit } from '@angular/core';
import { Ingridient } from '../../models/Ingridient';
import { IngridientService } from '../../services/ingridient.service';

@Component({
    selector: 'app-ingridient',
    templateUrl: './ingridient.component.html',
    styleUrls: ['./ingridient.component.css'],
})
export class IngridientComponent {
    constructor(private ingridientService: IngridientService) {}

    public ingridient: Ingridient = new Ingridient();

    saveIngridient() {
      this.ingridientService.postIngridient(this.ingridient).then(Ingridient=>{
        
      })
    }
}
