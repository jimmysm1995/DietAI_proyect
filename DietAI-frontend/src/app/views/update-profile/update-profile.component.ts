import { Component, EventEmitter, inject, OnInit, Output } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from 'src/app/models/User';
import { UserStore } from 'src/app/store/userStore';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { RoleStore } from '../../store/roleStore';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent {


  constructor(
    private userService: UserService, 
    private roleStore: RoleStore,
    private router : Router) {
  }

  public user: User = new User();
  @Output() onCloseModal = new EventEmitter();


  ngOnInit(): void {
    this.userService.getCurrentUser().then((user: User) => {
      this.user = user;
      console.log(this.user);
    });

  }

  deleteUser() {
    this.userService.deleteUserById(this.user.idUser).then(() => {
      localStorage.removeItem('sesion');
      this.roleStore.deleteRole();
      this.onCloseModal.emit();
      this.router.navigate(['/']);
    });
  }
}
