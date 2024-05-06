import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  menuActive: boolean = false;
  toggleMenu() {
    const menuIcon = document.querySelector('.menu-icon');
    menuIcon?.classList.toggle('active');
  }
}
