import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css']
})
export class FormLoginComponent {
  errorMessage: string = '';
  @ViewChild('userForm') userForm!: NgForm; 

  constructor(private userService: UserService, private router: Router) {}

  logearUsuario(userData: User): void {
    this.userService.loginUser(userData).subscribe(
      (response: any) => {
        console.log('User logged in successfully');
        // Redirigir al usuario a la página de inicio
        this.router.navigate(['/home']);
      },
      (error) => {
        console.error('Error logging in user:', error);
        // Mostrar mensaje de error en el cliente
        console.log(error);
        this.errorMessage = error; // error.error contiene el mensaje de error del backend
        this.userForm.reset();
      }
    );
  }
}
