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
        this.userService.registerUser(userData).then((User: User) => {
            this.router.navigate(['/login']);
        }).catch((error) => {
            this.errorMessage = error;
            this.userForm.resetForm();
        })
    }
}
