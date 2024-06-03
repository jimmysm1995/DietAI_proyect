import { Component, inject, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from 'src/app/models/User';
import { UserStore } from 'src/app/store/userStore';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent {
deleteUser() {
    this.userService.deleteUserById(this.user.idUser).then(() => {
    localStorage.removeItem('sesion');
    this.router.navigate(['/login']);
  });
}
  constructor(
    private userService: UserService, 
    private userStore: UserStore,
    private router : Router) {
  }

  public user: User = new User();

  ngOnInit(): void {
    this.userService.getCurrentUser().then((user: User) => {
      this.user = user;
      console.log(this.user);
    });

  }
}
