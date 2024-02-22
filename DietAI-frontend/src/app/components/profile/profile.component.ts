import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  
})
export class ProfileComponent {
  public user: User = new User();

  constructor(private userService: UserService) {}
  ngOnInit(): void {
    this.userService.getUser(1).then((user: User) => {
      this.user = user;
    })
  }
  
}
