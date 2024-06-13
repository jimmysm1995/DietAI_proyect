import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';
import { LoginResponse } from 'src/app/models/loginResponse';
import { UserStore } from 'src/app/store/userStore';
import { RoleStore } from '../../store/roleStore';
import { ApiError } from 'src/app/models/ApiError';
import { ClientStore } from 'src/app/store/clientStore';


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
        private userStore: UserStore,
        private roleStore: RoleStore,
        private clientStore: ClientStore
    ) {}

    logearUsuario(userData: User): void {
        this.userService
            .loginUser(userData)
            //cuando el login es correcto guarda el token y redireciona a home
            .then((response: LoginResponse) => {
                localStorage.setItem('sesion', response.token);
                //al tener almacenado en roleStore el role del usuario así se puede controlar desde adminGuarth. y authGuard
                this.roleStore.saveRole(response.authorities[0]);
                this.userService.getClient(response.idUser).then((client) => {
                    this.clientStore.saveClient(client);
                }).catch((error) => {
                    console.log(error);
                })
                //comprobamos si user es admin o no
                if(response.authorities[0]=="ADMIN"){
                    this.router.navigate(['/admin']);
                }else{
                    this.router.navigate(['/home']);
                }
                
            })
            .catch((error: ApiError) => {
                this.errorMessage = error.message;
                this.userForm.resetForm();
            });
    }
}
