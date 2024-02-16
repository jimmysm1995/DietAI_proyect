import { Component, ViewChild } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { User } from 'src/app/models/User';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
    selector: 'app-form-register',
    templateUrl: './form-register.component.html',
    styleUrls: ['./form-register.component.css'],
})
export class FormRegisterComponent {
    errorMessage: string = '';
    @ViewChild('userForm') userForm!: NgForm; 

    constructor(private userService: UserService, private router: Router) {}

    registrarUsuario(userData: User): void {
        this.userService.registerUser(userData).subscribe(
            (response: any) => {
                console.log('User registered successfully');
                // Redirigir al usuario a la página de inicio
                this.router.navigate(['/login']);
            },
            (error) => {
                console.error('Error registering user:', error);
                // Mostrar mensaje de error en el cliente
                console.log(error);
                this.errorMessage = error; // error.error contiene el mensaje de error del backend
                this.userForm.reset();
            }
        );
    }
}
