import { Component } from '@angular/core';
import { HeaderComponent } from './header/header.component';
import { BienvenidaComponent } from './bienvenida/bienvenida.component';
import { InfoComponent } from './info/info.component';
import { FooterComponent } from './footer/footer.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'DietAI-frontend';
}
