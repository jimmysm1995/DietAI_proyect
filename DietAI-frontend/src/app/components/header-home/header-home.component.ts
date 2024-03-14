import { Component, ElementRef } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-home',
  templateUrl: './header-home.component.html',
  styleUrls: ['./header-home.component.css']
})
export class HeaderHomeComponent {
  constructor(
    private elementRef: ElementRef,
    private router : Router) {}

  openProfileModal() {
    
  }
  

  closeProfileModal() {
    const modal = this.elementRef.nativeElement.querySelector('#updateProfileModal');
    modal.classList.remove('show');
    document.body.classList.remove('modal-open');
  }

  logout() {
    localStorage.removeItem('sesion');
    this.router.navigate(['/login']);
  }
}


