import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  public showDieta: boolean = false;
  public showEntrenamiento: boolean = false;

  verDieta() {
    this.showDieta = !this.showDieta;
  }

  verEntrenamiento() {
    this.showEntrenamiento = !this.showEntrenamiento;
  }
}
