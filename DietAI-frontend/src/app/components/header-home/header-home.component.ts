import { Component, ElementRef, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header-home',
  templateUrl: './header-home.component.html',
  styleUrls: ['./header-home.component.css']
})
export class HeaderHomeComponent {
  constructor(
    private elementRef: ElementRef,
    private router : Router,
    private userService : UserService) {}
    
  isAdmin: boolean = false; 

  openProfileModal() {
    
  }

  ngOnInit(): void {
    this.userService.getCurrentUser().then((user: User) => {
      this.userService.getAuthorities(user.idUser).then((authorities: string[]) => {
        if (authorities.includes('ADMIN')) {
          this.isAdmin = true;
        }
      })
    });
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

  toggleMenu() {
    const menuIcon = document.querySelector('.menu-icon');
    menuIcon?.classList.toggle('active');
  }
}


