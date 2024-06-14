import { Component, ElementRef, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';
import { RoleStore } from 'src/app/store/roleStore';
import { UserStore } from 'src/app/store/userStore';


@Component({
  selector: 'app-header-home',
  templateUrl: './header-home.component.html',
  styleUrls: ['./header-home.component.css']
})
export class HeaderHomeComponent {
  public menuActive:boolean = false;
  constructor(
    private elementRef: ElementRef,
    private router : Router,
    private userService : UserService,
    private roleStore: RoleStore,
    private userStore: UserStore) {}
    
  isAdmin: boolean = false; 
  isLoggedIn: boolean = false;
  @Input()
  public enableBackground: boolean = false;

  openProfileModal() {
    
  }

  ngOnInit(): void {
    this.userService.getCurrentUser().then((user: User) => {

      if (user) {
        this.isLoggedIn = true;
      }

      
        if (this.roleStore.getRole() === 'ADMIN') {
          this.isAdmin = true;
        }
      
    });
  }
  
  closeProfileModal() {
    const modal = this.elementRef.nativeElement.querySelector('#updateProfileModal');
    modal.classList.remove('show');
    document.body.classList.remove('modal-open');
  }

  logout() {
    localStorage.removeItem('sesion');
    this.roleStore.deleteRole();
    this.userStore.updateUser(new User());
    this.router.navigate(['/login']);
  }

  toggleMenu() {
    console.log("toggleMenu")
    this.menuActive = !this.menuActive;
  }
}


