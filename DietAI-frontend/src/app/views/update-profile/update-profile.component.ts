import { Component, inject, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from 'src/app/models/User';
import { UserStore } from 'src/app/store/userStore';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent {
  constructor(
    private userService: UserService, 
    private userStore: UserStore) {
  }

  public user: User = new User();

  ngOnInit(): void {
    this.userService.getCurrentUser().then((user: User) => {
      this.user = user;
      console.log("hola que ase2", this.user);
    });

  }
}
