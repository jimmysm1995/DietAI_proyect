import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-form-login',
    templateUrl: './form-login.component.html',
    styleUrls: ['./form-login.component.css'],
})
export class FormLoginComponent {

    username: string = '';
    password: string = '';

    hacerLogin() {
        const formData = new FormData();
        formData.append('username', this.username);
        formData.append('password', this.password);

        fetch('http://localhost:3000/login', {
            method: 'POST',
            body: formData,
        })
            .then((response) => {
                // Handle response
            })
            .catch((error) => {
                // Handle error
            });
    }

  errorMessage: string = '';
  @ViewChild('userForm') userForm!: NgForm; 

  constructor(private userService: UserService, private router: Router) {}

  logearUsuario(userData: User): void {
      this.userService.loginUser(userData).then((User: User) => {
      this.router.navigate(['/home']);
    }).catch((error) => {
      this.errorMessage = error;
      this.userForm.resetForm();
    })
  }

}
