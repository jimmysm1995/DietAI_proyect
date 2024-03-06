import { Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-header-home',
  templateUrl: './header-home.component.html',
  styleUrls: ['./header-home.component.css']
})
export class HeaderHomeComponent {
  constructor(private elementRef: ElementRef) {}

  openProfileModal() {
    console.log('Abriendo modal de perfil...');
    const modal = this.elementRef.nativeElement.querySelector('#updateProfileModal');
    modal.classList.add('show');
    document.body.classList.add('modal-open');
  }
  

  closeProfileModal() {
    const modal = this.elementRef.nativeElement.querySelector('#updateProfileModal');
    modal.classList.remove('show');
    document.body.classList.remove('modal-open');
  }
}
