import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';
import { LoginResponse } from 'src/app/models/loginResponse';
import { UserStore } from 'src/app/store/userStore';


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

    constructor(
        private userService: UserService,
        private router: Router,
        //mediante el constructor la instancia que está en el registro se inyecta en este componente
        private userStore: UserStore
    ) {}

    logearUsuario(userData: User): void {
        this.userService
            .loginUser(userData)
            //cuadno el login es correcto guarda el token y redireciona a home
            .then((response: LoginResponse) => {
                localStorage.setItem('sesion', response.token);
                localStorage.setItem('autorities', response.authorities[0]);
                this.router.navigate(['/home']);
            })
            .catch((error) => {
                this.errorMessage = error;
                this.userForm.resetForm();
            });
    }
}
